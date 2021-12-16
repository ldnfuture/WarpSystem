package at.ldnfuture.warpsystem.commands;

import at.ldnfuture.warpsystem.main.Main;
import at.ldnfuture.warpsystem.util.ConfigHandler;
import at.ldnfuture.warpsystem.util.PlayerCommand;
import at.ldnfuture.warpsystem.util.Warp;
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author LDN_Future
 * @version 1.0.0
 * created at 13.12.2021
 */
public class Warps extends PlayerCommand {
    public Warps(JavaPlugin pl, String commandName) {
        super(pl, commandName);
    }

    public boolean command(Player p, String[] args) {
        ConfigHandler cfg = new ConfigHandler(Main.getInstance().getCfg());
        String out = "";
        if ((new Warp()).getWarps().isEmpty()) {
            p.sendMessage(cfg.getPrefix("message.Prefix") + (cfg.getPrefix("message.Prefix").endsWith(" ") ? "" : " ") + cfg.translateChatColors("message.No_Warps_Set"));
            return true;
        } else {
            Iterator<?> var6 = (new Warp()).getWarps().iterator();

            while(var6.hasNext()) {
                Warp w = (Warp)var6.next();
                if (w.hasPermission()) {
                    if (p.hasPermission(w.getPermission())) {
                        out = out + "§a" + w.getName() + "§7, ";
                    } else {
                        out = out + "§c" + w.getName() + "§7, ";
                    }
                } else {
                    out = out + "§a" + w.getName() + "§7, ";
                }
            }

            out = out.trim();
            out = out.substring(0, out.length() - 1);
            p.sendMessage(cfg.getPrefix("message.Prefix") + (cfg.getPrefix("message.Prefix").endsWith(" ") ? "" : " ") + cfg.translateChatColors("message.Available_Warps").replace("{WARPS}", out));
            return false;
        }
    }
}
