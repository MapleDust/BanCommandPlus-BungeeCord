package xyz.fcidd.bancommandplus;

import lombok.SneakyThrows;
import net.md_5.bungee.api.plugin.Plugin;
import xyz.fcidd.bancommandplus.handler.ConfigHandler;
import xyz.fcidd.bancommandplus.listener.Events;

public class BanCommandPlus extends Plugin {
    @SneakyThrows
    @Override
    public void onEnable() {
        System.out.println("§2[BanCommandPlus]已经加载");
        //将配置文件输出到/plugins/BanCommandPlus
        ConfigHandler.creat();
        //监听器
        getProxy().getPluginManager().registerListener(this, new Events());
    }
}
