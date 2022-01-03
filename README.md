- **简体中文**
- [English](./README-EN.md)
# BanCommandPlus
一个Bungeecord插件，可以屏蔽任何命令，或屏蔽命令中特定的的子命令！
- 使用说明
  - 在`v1.1.0`或`v1.1.0`以后我们弃用了`properties`作为配置文件，使用了`yml`作为配置文件
  - 将从`Releases`上下载的插件放入Bungeecord端根目录的`plugins`文件夹里
  - 首次运行会在`plugins`文件里生成`BanCommandPlus`文件夹下的`config.yml`配置文件，推荐使用`Notepad++`来编辑
  - 本插件`config.yml`配置文件规范：
    - banned-command
      - 用"*"表示不限制
      - 例如:
        ```yml
        banned-command:
        - scoreboard player set * * 1
        - gamemode survival
        - gamemode creative
        - kill
        ```
    - main-command
      - 可以自定义主命令，留空默认"bancommand"
      - 例如：
        ```yaml
        main-command: bcmd
        ```
- 相关指令(这里使用默认主命令来演示)
  - 添加被ban指令：/bancommand add <指令>
  - 删除被ban指令：/bancommand remove <指令>
  - 被ban指令列表：/bancommand list
  - 重载本插件：/bancommand reload
- 相关权限：
  - 命令最高权限：bancommandplus.command.bancommand
  - 添加被ban指令：bancommandplus.command.bancommand.add
  - 删除被ban指令：bancommandplus.command.bancommand.remove
  - 被ban指令列表：bancommandplus.command.bancommand.list
  - 重载本插件：bancommandplus.command.bancommand.reload
- 更新日志
  - v1.2.0
    - 添加子命令`remove`Tab列表推荐被Ban指令
  - v1.1.0
    - 添加使用指令来查看、删除或添加被Ban的指令
    - 改用yml文件来作为配置文件
  - v1.0.0
    - 添加根据配置文件的指令来拦截子指令
