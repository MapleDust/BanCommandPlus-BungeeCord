package xyz.fcidd.bancommandplus.config;

import lombok.Data;

import java.io.*;
import java.util.Properties;

@Data
public class LoadConfig implements Serializable {
    private String[] banCommand = LoadConfig.load().getProperty("ban.command").split("\\|");

    private static Properties load() {
        //创建读取文件配置对象
        Properties properties = new Properties();
        try {
            //通过类加载器获取配置文件输入流
            InputStream raf = new FileInputStream("./plugins/BanCommandPlus/config.properties");
            //让对象和输入流关联
            properties.load(raf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
