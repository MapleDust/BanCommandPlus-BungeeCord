package xyz.fcidd.bancommandplus.list;

import java.util.List;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.config.Configuration;
import xyz.fcidd.bancommandplus.config.LoadConfig;

public class BannedCommandList {
    public static void showBannedCommandList(CommandSender sender) {
        // 读取配置文件
        Configuration configuration = LoadConfig.getConfiguration();
        // 获取被Ban指令的列表
        List<?> list = configuration.getList("banned-command");
        // 返回消息
        if (list.isEmpty()) {
            sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4此服务器未屏蔽命令").create());
        } else {
            sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4已被此服务器屏蔽的命令：").create());
            for (Object command : list) {
                sender.sendMessage(new ComponentBuilder("§8[§6BanCommandPlus§8]§4- /" + command).create());
            }
        }
    }
}