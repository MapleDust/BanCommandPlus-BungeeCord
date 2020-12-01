package xyz.fcidd.bancommandplus.command.bancommand;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import xyz.fcidd.bancommandplus.config.LoadConfig;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CommandHandler {
    private static Configuration configuration = LoadConfig.getConfiguration();

    public static void removeBannedCommand(String[] args, CommandSender sender) throws IOException {
        // 读取banned-command列表命令
        List<String> list = (List<String>) configuration.getList("banned-command");
        // 处理玩家输入的命令
        // 创建StringBuilder
        StringBuilder builder = new StringBuilder();
        // 在StringBuilder后追加下标为1的args数值
        builder.append(args[1]);
        for (int i = 2; i < args.length; i++) {
            // 将数组的值逐个追加到builder的后面
            builder.append(" " + args[i]);
        }
        // 转成字符串
        String value = builder.toString();
        if (list.contains(value)) {
            // 直接移除命令
            list.remove(value);
            // 将list集合放入banned-command
            configuration.set("banned-command", list);
            // 将list集合写入文件中
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, new File("./plugins/BanCommandPlus/config.yml"));
            // 并返回删除成功的消息
            sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4命令'/" + value + "'已从banned-command列表中移除").create());
        } else {
            sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4命令'/" + value + "'未在banned-command列表中").create());
        }
    }

    public static void addBannedCommand(String[] args, CommandSender sender) throws IOException {
        // 读取banned-command列表命令
        List<String> list = (List<String>) configuration.getList("banned-command");
        // 处理玩家输入的命令
        // 创建StringBuilder
        StringBuilder builder = new StringBuilder();
        // 在StringBuilder后追加下标为1的args数值
        builder.append(args[1]);
        // 将数组的值逐个追加到builder的后面
        for (int i = 2; i < args.length; i++) {
            builder.append(" " + args[i]);
        }
        // 转成字符串
        String value = builder.toString();
        if (!list.contains(value)) {
            // 创建集合link
            List<String> link = new LinkedList<>();
            // link = list列表
            link.addAll(list);
            // 将输入的命令直接添加到link集合中
            link.add(value);
            // 并将link集合放入banned-command列表中
            configuration.set("banned-command", link);
            // 将link集合的数据保存到config.yml文件中
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, new File("./plugins/BanCommandPlus/config.yml"));
            // 返回添加成功提示
            sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4成功将'/" + value + "'添加到banned-command列表").create());
        } else {
            sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4命令'/" + value + "'已在banned-command列表中").create());
        }
    }
}