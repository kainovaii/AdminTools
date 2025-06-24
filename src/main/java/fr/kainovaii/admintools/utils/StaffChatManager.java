package fr.kainovaii.admintools.utils;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class StaffChatManager implements Listener
{
    private final Set<UUID> toggledPlayers = new HashSet<>();

    public boolean isToggled(Player player) { return toggledPlayers.contains(player.getUniqueId()); }

    public void toggle(Player player)
    {
        UUID uuid = player.getUniqueId();
        if (toggledPlayers.contains(uuid)) {
            toggledPlayers.remove(uuid);
            player.sendMessage("§7[§6StaffChat§7] §cStaff chat désactivé.");
        } else {
            toggledPlayers.add(uuid);
            player.sendMessage("§7[§6StaffChat§7] §aStaff chat activé.");
        }
    }

    @EventHandler
    public void onChat(AsyncChatEvent event)
    {
        Player player = event.getPlayer();
        if (!isToggled(player)) return;
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
