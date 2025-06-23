package fr.kainovaii.admintools.commands;


import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import fr.kainovaii.admintools.AdminTools;
import io.papermc.paper.plugin.configuration.PluginMeta;
import org.bukkit.entity.Player;

@CommandAlias("admintools|adt")
@Description("Main command")
public class InfoCommand extends BaseCommand
{
    @Subcommand("info")
    public void info(Player player)
    {
        PluginMeta minevote = AdminTools.getPlugin().getPluginMeta();
        String[] messages = new String[]
        {
            "§6§m────────§7[§bAdminTools§7]§6§m────────",
            "§7┌ §6Author §7↪ §b" + minevote.getAuthors(),
            "§7├ §6Version §7↪ §b" + minevote.getVersion(),
            "§7├ §6Api Version §7↪ §b" + minevote.getAPIVersion(),
            "§7└ §6Depend §7↪ §b" + minevote.getPluginDependencies(),
            "§6§m──────────────────────"
        };
        player.sendMessage(messages);
    }
}
