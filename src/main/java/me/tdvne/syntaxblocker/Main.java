package me.tdvne.syntaxblocker;

import me.tdvne.syntaxblocker.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    private static Main instance;
    Main plugin = this;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        Bukkit.getServer().getConsoleSender().sendMessage("§a[SyntaxBlocker] Registering Listeners...");
        getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getConsoleSender().sendMessage("§aSyntaxBlocker has successfully registered listeners & loaded.");
    }

    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§aSyntaxBlocker has successfully unloaded & disabled.");
    }

    // Listener & Tasks
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent Syntax) {
        if (Syntax.getMessage().split(" ")[0].contains(":")) {
            Syntax.setCancelled(true);
            Syntax.getPlayer().sendMessage(ChatColor.RED + "This syntax is not accepted.");
        }

        if (Syntax.getMessage().trim().equalsIgnoreCase("/syntaxblocker")) {
            Syntax.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            Syntax.getPlayer().sendMessage(CC.translate("&4&lSyntax Blocker"));
            Syntax.getPlayer().sendMessage(CC.translate(" &c&l┃ &fAuthor: &ctdvne"));
            Syntax.getPlayer().sendMessage(CC.translate(" &c&l┃ &fDiscord: &ctdvne#0001"));
            Syntax.getPlayer().sendMessage(CC.translate(" &c&l┃ &fVersion: &cv" + plugin.getDescription().getVersion()));
            Syntax.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            Syntax.setCancelled(true);
        }
    }
}

