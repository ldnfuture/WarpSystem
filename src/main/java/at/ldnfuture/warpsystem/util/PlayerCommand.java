package at.ldnfuture.warpsystem.util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author LDN_Future
 * @version 1.0.0
 * created at 13.12.2021
 */
public abstract class PlayerCommand implements CommandExecutor {
    public PlayerCommand(JavaPlugin pl, String commandName) {
        pl.getCommand(commandName).setExecutor(this);
    }

    public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
        return !(arg0 instanceof Player) ? true : this.command((Player)arg0, arg3);
    }

    public abstract boolean command(Player var1, String[] var2);
}
