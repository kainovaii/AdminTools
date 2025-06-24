package fr.kainovaii.admintools.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import fr.kainovaii.admintools.utils.StaffChatManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("staffchat|sc")
@Description("Permet de parler ou d'activer le mode Staff Chat.")
public class StaffChatCommand extends BaseCommand
{
    private final StaffChatManager manager;

    public StaffChatCommand(StaffChatManager staffChatManager) {  this.manager = staffChatManager; }

    @Default
    @Syntax("<message>")
    @CommandPermission("staffchat.view")
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
    @CommandPermission("staffchat.view")
    public void onToggle(Player player) { manager.toggle(player); }
}
