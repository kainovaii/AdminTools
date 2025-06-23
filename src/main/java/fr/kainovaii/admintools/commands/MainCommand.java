package fr.kainovaii.admintools.commands;


import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import org.bukkit.entity.Player;

@CommandAlias("admintools|adt")
@Description("Main command")
public class MainCommand extends BaseCommand
{
    public MainCommand() {}

    @Default
    public void index(Player player) {}
}
