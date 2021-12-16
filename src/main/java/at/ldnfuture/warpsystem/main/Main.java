package at.ldnfuture.warpsystem.main;

import at.ldnfuture.warpsystem.commands.DelWarp;
import at.ldnfuture.warpsystem.commands.SetWarp;
import at.ldnfuture.warpsystem.commands.SetWarpPermission;
import at.ldnfuture.warpsystem.commands.WarpCMD;
import at.ldnfuture.warpsystem.commands.Warps;
import at.ldnfuture.warpsystem.util.FileBuilder;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author LDN_Future
 * @version 1.0.0
 * created at 13.12.2021
 */
public class Main extends JavaPlugin {
    private static Main instance;

    public Main() {
    }

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        this.iniConfig();
        new DelWarp(instance, "delwarp");
        new SetWarp(instance, "setwarp");
        new SetWarpPermission(instance, "setwarppermission");
        new WarpCMD(instance, "warp");
        new Warps(instance, "warps");
    }

    public void onDisable() {
    }

    public FileBuilder getCfg() {
        return new FileBuilder("plugins//Warps//", "config.yml");
    }

    public void iniConfig() {
        FileBuilder f = this.getCfg();
        if (!f.exist()) {
            f.setValue("message.Prefix", "&0[&3WarpSystem&0]&f ");
            f.setValue("message.No_Permission", "&cDu hast keine Rechte für diese Aktion!");
            f.setValue("message.Warp_Set", "&fDer Warp Punkt &3{WARP}&f wurde &3gesetzt&f!");
            f.setValue("message.Warp_Delete", "&fDer Warp Punkt &3{WARP}&f wurde &3gelöscht&f!");
            f.setValue("message.Warp_Teleport", "&fDu wurdest zum Warp Punkt &3{WARP}&f teleportiert!");
            f.setValue("message.Warp_Does_Not_Exist", "&fDer Warp Punkt &3{WARP}&f existiert nicht!");
            f.setValue("message.No_Warp_Permission", "&cDu hast keine Rechte dich zum Warp Punkt &3{WARP}&c zu Teleportieren!");
            f.setValue("message.No_Warps_Set", "&cEs existieren keine Warps!");
            f.setValue("message.Available_Warps", "&fVerfügbare Warps: &3{WARPS}");
            f.setValue("message.Warp_Permission_Set", "&fDu hast die Permission &3({PERMISSION})&f für den Warp Punkt &3{WARP}&f gesetzt!");
            f.save();
        }
    }
}