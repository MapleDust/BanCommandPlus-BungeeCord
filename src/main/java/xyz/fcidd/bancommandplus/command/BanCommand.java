package xyz.fcidd.bancommandplus.command;

import lombok.SneakyThrows;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;
import xyz.fcidd.bancommandplus.config.LoadConfig;
import xyz.fcidd.bancommandplus.handler.CommandHandler;
import xyz.fcidd.bancommandplus.list.BannedCommandList;

import java.util.LinkedList;
import java.util.List;

public class BanCommand extends Command implements TabExecutor {

    public BanCommand() {
        super(command());
    }

    public static String command() {
        LoadConfig loadConfig = new LoadConfig();
        // 获取配置文件中设置的主命令
        String command = loadConfig.getMainCommand();
        return command;
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        // 创建命令推荐列表
        List<String> list = new LinkedList<>();
        // 在玩家输入内容长度为1时
        if (args.length == 0) {
            list.add(command());
        //当玩家输入的长度为1时
        } else if (args.length == 1) {
            //将子指令推荐给玩家
            list.add("add");
            list.add("remove");
            list.add("reload");
            list.add("list");
        //当玩家输入的指令的长度为2时，并且是remove时
        } else if (args.length == 2 && args[0].equals("remove")) {
            //获取被Ban指令的列表
            LoadConfig loadConfig = new LoadConfig();
            List<?> banCommands = loadConfig.getBanCommand();
            //将被ban指令的列表推荐给玩家
            banCommands.forEach(banCommand -> list.add((String) banCommand));
        }
        // 返回list即向玩家发送
        return list;
    }

    @SneakyThrows
    @Override
    public void execute(CommandSender sender, String[] args) {
        //创建权限
        final boolean commandAuth = sender.hasPermission("bancommandplus.command.bancommand");
        final boolean addAuth = sender.hasPermission("bancommandplus.command.bancommand.add");
        final boolean removeAuth = sender.hasPermission("bancommandplus.command.bancommand.remove");
        final boolean reloadAuth = sender.hasPermission("bancommandplus.command.bancommand.reload");
        final boolean listAuth = sender.hasPermission("bancommandplus.command.bancommand.listAuth");
        switch (args[0]) {
            case "add":
                // 判断权限都没有则警告
                if (!addAuth && !commandAuth) {
                    sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4你没有使用该命令的权限！").create());
                } else if ((removeAuth || commandAuth) && args.length > 1) {
                    CommandHandler.addBannedCommand(args, sender);
                    // 有权限且数组长度>1(说明输入了后续内容)
                } else {
                    // 否则说明没有输入后续内容，显示警告
                    sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4请输入你要屏蔽的命令！").create());
                }
                break;
            case "remove":
                // 判断权限都没有则警告
                if (!removeAuth && !commandAuth) {
                    sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4你没有使用该命令的权限！").create());
                } else if ((removeAuth || commandAuth) && args.length > 1) {
                    // 有权限且数组长度>1(说明输入了后续内容)
                    CommandHandler.removeBannedCommand(args, sender);
                } else {
                    // 否则说明没有输入后续内容，显示警告
                    sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4请输入你要屏蔽的命令！").create());
                }
                break;
            case "reload":
                // 判断权限都没有则警告
                if (!reloadAuth && !commandAuth) {
                    sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4你没有使用该命令的权限！").create());
                } else if ((removeAuth || commandAuth)) {
                    // 有权限
                    LoadConfig.loadConfig();
                    sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4已重新加载").create());
                }
                break;
            case "list":
                // 判断权限都没有则警告
                if (!listAuth && !commandAuth) {
                    sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4你没有使用该命令的权限！").create());
                } else if ((listAuth || commandAuth)) {
                    // 有权限
                    BannedCommandList.showBannedCommandList(sender);
                }
                break;
            default:
                // 未输入或未输入正确的子命令
                sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4未知的子命令，请使用[add/remove/reload/list]").color(ChatColor.RED).create());
                break;
        }
    }
}