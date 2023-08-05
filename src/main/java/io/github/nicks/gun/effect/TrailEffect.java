package io.github.nicks.gun.effect;

import lombok.AllArgsConstructor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

@AllArgsConstructor
public class TrailEffect implements GunEffect {

    private final Particle particle;
    private final int count;
    private final double speed;
    private final double distanceBetween;
    private final double range;

    @Override
    public void apply(Location location, Vector direction) {
        for(double i = 0; i < range; i += distanceBetween) {
            location.add(direction.clone().multiply(distanceBetween));
            location.getWorld().spawnParticle(particle, location, count, 0, 0, 0, speed, null, true);
        }
    }
}