- [简体中文](./README.md)
- **English**

# BanCommandPlus

A Bungeecord plugin that blocks any command, or specific subcommands of a command!

- Instructions for Use

  - After `v1.1.0` or `v1.1.0` we deprecated `properties` as a configuration file and used `yml` as a configuration file!

  - Place the plugins downloaded from `Releases` in the `plugins` folder in the root directory of the Bungeecord.

  - The first run will generate the `config.yml` configuration file in the `plugins` file in the `BanCommandPlus` folder, and we recommend using `Notepad++` to edit the `config.yml` configuration file.

  - This plug-in `config.yml` configuration file specification.

    - banned-command

      - Use "*" for no restrictions

      - For example：

        ```yaml
        banned-command:
        - scoreboard player set * * 1
        - gamemode survival
        - gamemode creative
        - kill
        ```

    - main-command

      - The main command can be customised, leaving the default "bancommand" blank.

      - For example：

        ```yaml
        main-command: bcmd
        ```

- Related commands (demonstrated here using the default master command)
  - Add the ban command: /bancommand add <command>
  - To remove a ban command: /bancommand remove <command>
  - List of ban commanded: /bancommand list
  - Reload this plug-in: /bancommand reload
- Relevant permissions.
  - Command highest authority: bancommandplus.command.bancommand
  - Adding the ban command: bancommandplus.command.bancommand.add
  - Remove the ban command: bancommandplus.command.bancommand.remove
  - List of ban commanded: bancommandplus.command.bancommand.list
  - Reload this plugin: bancommandplus.command.bancommand.reload
- Update Log
  - v1.2.1
    - Fix the corresponding subcommand permission error
  - v1.2.0
    - Add subcommand `remove` Tab list recommended by Ban command
  - v1.1.0
    - Add the use of commands to view, delete or add commands that have been Ban'd
    - Use yml files as configuration files instead
  - v1.0.0
    - Adding instructions to intercept sub-instructions based on the configuration file
