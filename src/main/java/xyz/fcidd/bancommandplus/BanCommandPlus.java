package xyz.fcidd.bancommandplus;

import lombok.SneakyThrows;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.fcidd.bancommandplus.handler.ConfigFileHandler;
import xyz.fcidd.bancommandplus.command.BanCommand;
import xyz.fcidd.bancommandplus.listener.Events;

public class BanCommandPlus extends Plugin {
    @SneakyThrows
    @Override
    public void onEnable() {
        // 将配置文件输出到/plugins/BanCommandPlus
        ConfigFileHandler.create();
        // 注册指令
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new BanCommand());
        // 监听器
        getProxy().getPluginManager().registerListener(this,new Events());
        System.out.println("§2[BanCommandPlus]加载已完成");
    }
}