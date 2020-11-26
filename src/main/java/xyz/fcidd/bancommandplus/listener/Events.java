package xyz.fcidd.bancommandplus.listener;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import xyz.fcidd.bancommandplus.config.LoadConfig;

public class Events implements Listener {


    @EventHandler
    public void onChat(ChatEvent chatEvent) {
        //如果玩家发送给服务器是
        if (chatEvent.isCommand()) {
            String msg = chatEvent.getMessage();
            String[] S_msg = msg.substring(1).split(" ");
            //读取配置文件
            LoadConfig loadConfig = new LoadConfig();
            // 获取处理后的配置文件
            String[] banCommand = loadConfig.getBanCommand();
            Boolean isEqu;
            //便利处理后的配置文件
            for (int i = 0; i < banCommand.length; i++) {
                //将便利后的数据用空格拆分
                String[] mainCommand = banCommand[i].split(" ");
                //如果配置文件的数组长度等于客户端发送过来的长度
                if (mainCommand.length == S_msg.length) {
                    //先将isEqu设为true
                    isEqu = true;
                    //便利配置文件的命令
                    for (int j = 0; j < mainCommand.length; j++) {
                        //如果配置文件的命令不等于玩家指令并且配置文件含有*的命令
                        if (!mainCommand[j].equals(S_msg[j]) && !mainCommand[j].equals("*")) {
                            //把isEqu设为false
                            isEqu = false;
                        }
                    }
                    //如果isEqu为true
                    if (isEqu) {
                        //将命令取消
                        chatEvent.setCancelled(true);
                        CommandSender player = (CommandSender) chatEvent.getSender();
                        player.sendMessage("§4/" + banCommand[i] + "命令在此服务禁止使用");
                        break;
                    }
                }
            }
        }
    }

}
