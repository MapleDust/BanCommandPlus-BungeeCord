- [简体中文](./README.md)
- **English**

# BanCommandPlus

A Bungeecord plugin that blocks any command, or specific subcommands of a command!

- Instructions for Use

  - Place the plugins downloaded from `Releases` in the `plugins` folder in the root directory of the Bungeecord.
  - The first run will generate the `config.properties` configuration file in the `plugins` file in the `BanCommandPlus` folder, and we recommend using `Notepad++` to edit the `config.properties` configuration file.
  - This plug-in `config.properties` configuration file specification.
    - Separated by "|" and unrestricted by "*".
    - For example：scoreboard player set * * 1|gamemode survival|gamemode creative|kill
- Update Log
  - v1.0.0
    - Adding the ability to intercept sub-instructions based on the instructions in the configuration file
