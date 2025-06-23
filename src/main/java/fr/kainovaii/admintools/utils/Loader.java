package fr.kainovaii.admintools.utils;

import fr.kainovaii.admintools.AdminTools;
import co.aikar.commands.PaperCommandManager;

public class Loader
{
    AdminTools plugin;

    public Loader(AdminTools plugin)
    {
        this.plugin = plugin;
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
        PaperCommandManager paperCommandManager = new PaperCommandManager(plugin);
    }
}
