package at.ldnfuture.warpsystem.util;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 * @author LDN_Future
 * @version 1.0.0
 * created at 13.12.2021
 */
public class Warp {
    private FileBuilder f;
    private String name;

    public Warp() {
        this.f = new FileBuilder("plugins//Warps//", "warps.yml");
    }

    public Warp(String name) {
        this();
        this.name = name;
    }

    public List<Warp> getWarps() {
        List<Warp> temp = new ArrayList<Warp>();
        this.f.getKeys(false).stream().forEach((name) -> {
            temp.add(new Warp(name));
        });
        return temp;
    }

    public String getName() {
        return this.name;
    }

    public boolean exist() {
        return this.f.getString(this.name) != null;
    }

    public Warp delete() {
        this.f.setValue(this.name, (Object)null);
        this.f.save();
        return this;
    }

    public boolean hasPermission() {
        return this.f.getString(this.name + ".permission") != null;
    }

    public String getPermission() {
        return this.f.getString(this.name + ".permission");
    }

    public Warp setPermission(String permission) {
        this.f.setValue(this.name + ".permission", permission);
        this.f.save();
        return this;
    }

    public Warp setLocation(Location loc) {
        this.f.setValue(this.name + ".world", loc.getWorld().getName());
        this.f.setValue(this.name + ".x", loc.getX());
        this.f.setValue(this.name + ".y", loc.getY());
        this.f.setValue(this.name + ".z", loc.getZ());
        this.f.setValue(this.name + ".yaw", loc.getYaw());
        this.f.setValue(this.name + ".pitch", loc.getPitch());
        this.f.save();
        return this;
    }

    public Location getLocation() {
        World world = Bukkit.getWorld(this.f.getString(this.name + ".world"));
        double x = this.f.getDouble(this.name + ".x");
        double y = this.f.getDouble(this.name + ".y");
        double z = this.f.getDouble(this.name + ".z");
        double yaw = this.f.getDouble(this.name + ".yaw");
        double pitch = this.f.getDouble(this.name + ".pitch");
        return new Location(world, x, y, z, (float)yaw, (float)pitch);
    }
}
