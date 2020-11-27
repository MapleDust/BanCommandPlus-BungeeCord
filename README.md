- **简体中文**
- [English](./README-EN.md)

# BanCommandPlus

一个Bungeecord插件，可以屏蔽任何命令，或屏蔽命令中特定的的子命令！

- 使用说明

  - 将从`Releases`上下载的插件放入Bungeecord端根目录的`plugins`文件夹里
  - 首次运行会在`plugins`文件里生成`BanCommandPlus`文件夹下的`config.properties`配置文件，推荐使用`Notepad++`来编辑
  - 本插件`config.properties`配置文件规范：
    - 用"|"分隔，用"*"表示不限制
    - 例如：scoreboard player set * * 1|gamemode survival|gamemode creative|kill
- 更新日志
  - v1.0
    - 添加根据配置文件的指令来拦截指令
