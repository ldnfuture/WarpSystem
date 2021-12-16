package at.ldnfuture.warpsystem.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author LDN_Future
 * @version 1.0.0
 * created at 13.12.2021
 */
public class PlayerWarpEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Warp warp;
    private Player p;

    public PlayerWarpEvent(Player p, Warp warp) {
        this.warp = warp;
        this.p = p;
    }

    public Location getFrom() {
        return this.p.getLocation();
    }

    public Location getTo() {
        return this.warp.getLocation();
    }

    public Player getPlayer() {
        return this.p;
    }

    public Warp getWarp() {
        return this.warp;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
