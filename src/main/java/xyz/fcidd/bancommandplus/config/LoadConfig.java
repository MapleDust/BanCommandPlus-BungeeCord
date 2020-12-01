package xyz.fcidd.bancommandplus.config;

import lombok.Data;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Data
public class LoadConfig {
    private List<?> banCommand = configuration.getList("banned-command");
    private String mainCommand = configuration.getString("main-command", "bancommand");

    private static Configuration configuration;

    /**
     * 读取配置文件
     */
    public static Configuration loadConfig() {
        try {
            LoadConfig.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class)
                    .load(new File("./plugins/BanCommandPlus/config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LoadConfig.configuration;
    }

    public static Configuration getConfiguration() {
        return LoadConfig.configuration;
    }
}