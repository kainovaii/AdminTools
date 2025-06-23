package fr.kainovaii.admintools.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import fr.kainovaii.admintools.utils.StaffChatManager;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import io.papermc.paper.event.player.AsyncChatEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@CommandAlias("staffchat|sc")
@Description("Permet de parler ou d'activer le mode Staff Chat.")
public class StaffChatCommand extends BaseCommand
{
    private final StaffChatManager manager;
    private final Set<UUID> toggledPlayers = new HashSet<>();

    public StaffChatCommand(StaffChatManager staffChatManager) {
        this.manager = staffChatManager;
    }

    @Default
    @Syntax("<message>")
    @Description("Envoie un message dans le chat staff")
    public void send(Player player, @Single String message)
    {
        String formatted = "§7[§6StaffChat§7] §f" + player.getName() + " §7» §f" + message;
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target.hasPermission("staff.chat")) {
                target.sendMessage(formatted);
            }
        }
    }

    @Subcommand("toggle")
    @Description("Active/désactive le mode staff chat")
    public void onToggle(Player player)
    {
        manager.toggle(player);
    }

    @EventHandler
    public void onChat(AsyncChatEvent event)
    {
        Player player = event.getPlayer();

        player.sendMessage(toggledPlayers.toString());

        if (toggledPlayers.contains(player.getUniqueId())) return;

        event.setCancelled(true);
        event.viewers().clear();

        String message = PlainTextComponentSerializer.plainText().serialize(event.originalMessage());
        String formatted = "§7[§6StaffChat§7] §f" + player.getName() + " §7» §f" + message;

        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target.hasPermission("staffchat.view"))
            {
                target.sendMessage(formatted);
            }
        }
    }
}
