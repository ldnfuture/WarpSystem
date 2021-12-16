package at.ldnfuture.warpsystem.commands;

import at.ldnfuture.warpsystem.main.Main;
import at.ldnfuture.warpsystem.util.ConfigHandler;
import at.ldnfuture.warpsystem.util.PlayerCommand;
import at.ldnfuture.warpsystem.util.PlayerWarpEvent;
import at.ldnfuture.warpsystem.util.Warp;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author LDN_Future
 * @version 1.0.0
 * created at 13.12.2021
 */
public class WarpCMD extends PlayerCommand {
    public WarpCMD(JavaPlugin pl, String commandName) {
        super(pl, commandName);
    }

    public boolean command(Player p, String[] args) {
        ConfigHandler cfg = new ConfigHandler(Main.getInstance().getCfg());
        if (args.length != 1) {
            p.chat("/warps");
            return true;
        } else {
            Warp w = new Warp(args[0]);
            if (!w.exist()) {
                p.sendMessage(cfg.getPrefix("message.Prefix") + (cfg.getPrefix("message.Prefix").endsWith(" ") ? "" : " ") + cfg.translateChatColors("message.Warp_Does_Not_Exist").replace("{WARP}", args[0]));
                return true;
            } else if (w.hasPermission() && !p.hasPermission(w.getPermission())) {
                p.sendMessage(cfg.getPrefix("message.Prefix") + (cfg.getPrefix("message.Prefix").endsWith(" ") ? "" : " ") + cfg.translateChatColors("message.No_Warp_Permission").replace("{WARP}", args[0]));
                return true;
            } else {
                Bukkit.getPluginManager().callEvent(new PlayerWarpEvent(p, w));
                p.teleport(w.getLocation());
                p.sendMessage(cfg.getPrefix("message.Prefix") + (cfg.getPrefix("message.Prefix").endsWith(" ") ? "" : " ") + cfg.translateChatColors("message.Warp_Teleport").replace("{WARP}", args[0]));
                return false;
            }
        }
    }
}
