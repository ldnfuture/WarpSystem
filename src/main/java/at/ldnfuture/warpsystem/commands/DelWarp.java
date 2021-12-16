package at.ldnfuture.warpsystem.commands;

import at.ldnfuture.warpsystem.main.Main;
import at.ldnfuture.warpsystem.util.ConfigHandler;
import at.ldnfuture.warpsystem.util.PlayerCommand;
import at.ldnfuture.warpsystem.util.Warp;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author LDN_Future
 * @version 1.0.0
 * created at 13.12.2021
 */
public class DelWarp extends PlayerCommand {
    public DelWarp(JavaPlugin pl, String commandName) {
        super(pl, commandName);
    }

    public boolean command(Player p, String[] args) {
        ConfigHandler cfg = new ConfigHandler(Main.getInstance().getCfg());
        if (!p.hasPermission("warp.delwarp")) {
            p.sendMessage(cfg.getPrefix("message.Prefix") + (cfg.getPrefix("message.Prefix").endsWith(" ") ? "" : " ") + cfg.translateChatColors("message.No_Permission"));
            return true;
        } else if (args.length != 1) {
            p.sendMessage(cfg.getPrefix("message.Prefix") + "§fBitte benutze §3/delwarp <Name>§f!");
            return true;
        } else {
            Warp w = new Warp(args[0]);
            if (!w.exist()) {
                p.sendMessage(cfg.getPrefix("message.Prefix") + (cfg.getPrefix("message.Prefix").endsWith(" ") ? "" : " ") + cfg.translateChatColors("message.Warp_Does_Not_Exist").replace("{WARP}", args[0]));
                return true;
            } else {
                w.delete();
                p.sendMessage(cfg.getPrefix("message.Prefix") + (cfg.getPrefix("message.Prefix").endsWith(" ") ? "" : " ") + cfg.translateChatColors("message.Warp_Delete").replace("{WARP}", args[0]));
                return false;
            }
        }
    }
}