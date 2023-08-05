package io.github.nicks.gun.effect;

import lombok.AllArgsConstructor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

@AllArgsConstructor
public class MuzzleFlashEffect implements GunEffect {

    private int count;
    private double offsetX, offsetY, offsetZ, speed;

    public MuzzleFlashEffect() {
        this(3, 0.2, 0.2, 0.2, 0.1);
    }

    @Override
    public void apply(Location location, Vector direction) {
        location.getWorld().spawnParticle(Particle.FLAME, location, count, offsetX, offsetY, offsetZ, speed);
    }
}
