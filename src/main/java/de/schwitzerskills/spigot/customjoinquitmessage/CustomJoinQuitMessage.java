package de.schwitzerskills.spigot.customjoinquitmessage;

import de.schwitzerskills.spigot.customjoinquitmessage.listeners.JoinListener;
import de.schwitzerskills.spigot.customjoinquitmessage.listeners.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class CustomJoinQuitMessage extends JavaPlugin {

    public static File file = new File("plugins/CustomJoinQuitMessage/", "messages.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aPlugin wurde aktiviert §7by §bSchwitzerSkills");
        createConfigFile();
        registerListeners(Bukkit.getPluginManager());
    }

    public void registerListeners(PluginManager pm){
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
    }

    public void createConfigFile(){
        try {
            if (!file.exists()) {
                cfg.set("JoinMessage", "&a%player% &7hat den Server betreten&8.");
                cfg.set("QuitMessage", "&c%player% &7hat den Server verlassen&8.");
                cfg.save(file);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
    }
}
