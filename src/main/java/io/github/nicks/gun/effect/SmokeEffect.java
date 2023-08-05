package io.github.nicks.gun.effect;

import lombok.AllArgsConstructor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

@AllArgsConstructor
public class SmokeEffect implements GunEffect {

    private int count;
    private double offsetX, offsetY, offsetZ, speed;

    public SmokeEffect() {
        this(10, 0.2, 0.2, 0.2, 0.1);
    }

    public void apply(Location location, Vector direction) {
        location.getWorld().spawnParticle(Particle.SMOKE_LARGE, location, count, offsetX, offsetY, offsetZ, speed);
    }
}
