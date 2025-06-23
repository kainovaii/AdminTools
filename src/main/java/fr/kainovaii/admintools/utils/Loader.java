package fr.kainovaii.admintools.utils;

import fr.kainovaii.admintools.AdminTools;
import co.aikar.commands.PaperCommandManager;
import fr.kainovaii.admintools.commands.InfoCommand;
import fr.kainovaii.admintools.commands.MainCommand;
import fr.kainovaii.admintools.commands.StaffChatCommand;

public class Loader
{
    private final AdminTools plugin;
    StaffChatManager staffChatManager;
    PaperCommandManager commandManager;

    public Loader(AdminTools plugin)
    {
        this.plugin = plugin;
        this.commandManager = new PaperCommandManager(plugin);
        this.staffChatManager = new StaffChatManager();
    }

    public void registerMotd()
    {
        plugin.getLogger().info("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        plugin.getLogger().info("\u001B[36m    _       _           _____           _     \u001B[0m");
        plugin.getLogger().info("\u001B[36m   / \\   __| | ___ _ __|_   _|__   ___ | |___ \u001B[0m");
        plugin.getLogger().info("\u001B[36m  / _ \\ / _` |/ _ \\ '__|| |/ _ \\ / _ \\| / __|\u001B[0m");
        plugin.getLogger().info("\u001B[36m / ___ \\ (_| |  __/ |   | | (_) | (_) | \\__ \\\u001B[0m");
        plugin.getLogger().info("\u001B[36m/_/   \\_\\__,_|\\___|_|   |_|\\___/ \\___/|_|___/\u001B[0m");
        plugin.getLogger().info("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
    }

    public void registerCommands()
    {
        plugin.getLogger().info("Loading commands");
        commandManager.registerCommand(new MainCommand());
        commandManager.registerCommand(new InfoCommand());
        commandManager.registerCommand(new StaffChatCommand(this.staffChatManager));
    }

    public void registerListeners()
    {
        plugin.getLogger().info("Loading listeners");
        plugin.getServer().getPluginManager().registerEvents(staffChatManager, plugin);
    }
}
