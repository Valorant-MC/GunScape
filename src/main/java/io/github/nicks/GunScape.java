package io.github.nicks;

import io.github.nicks.listener.GunListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class GunScape extends JavaPlugin {

    @Getter
    private static GunScape instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new GunListener(), this);
    }
}
