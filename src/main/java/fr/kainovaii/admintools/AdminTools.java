package fr.kainovaii.admintools;

import fr.kainovaii.admintools.utils.Loader;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdminTools extends JavaPlugin
{
    private static AdminTools plugin;

    @Override
    public void onEnable()
    {
        plugin = this;
        Loader loader = new Loader(this);
        loader.registerMotd();
        loader.registerCommands();
        loader.registerListeners();
    }

    @Override
    public void onDisable() {}

    public static AdminTools getPlugin() {return plugin;}
}