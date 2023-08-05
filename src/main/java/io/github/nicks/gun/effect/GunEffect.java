package io.github.nicks.gun.effect;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public interface GunEffect {

    void apply(Location location, Vector direction);
}
