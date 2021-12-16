package at.ldnfuture.warpsystem.util;

import org.bukkit.ChatColor;

/**
 * @author LDN_Future
 * @version 1.0.0
 * created at 13.12.2021
 */
public class ConfigHandler {
    private FileBuilder f;

    public ConfigHandler(FileBuilder f) {
        this.f = f;
    }

    public FileBuilder getFileBuilder() {
        return this.f;
    }

    public String translateChatColors(String ValuePath) {
        return ChatColor.translateAlternateColorCodes('&', this.f.getString(ValuePath));
    }

    public String getPrefix(String ValuePath) {
        return this.translateChatColors(ValuePath);
    }
}
