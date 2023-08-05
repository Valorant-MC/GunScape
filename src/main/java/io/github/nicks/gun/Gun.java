package io.github.nicks.gun;

import io.github.nicks.gun.effect.GunEffect;
import io.github.nicks.magazine.Magazine;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.*;

public abstract class Gun {

    protected String name;
    protected double damage;
    protected int maxAmmo;
    protected Magazine magazine;
    protected List<GunEffect> effects;

    public Gun(String name, double damage, int maxAmmo, Magazine magazine) {
        this(name, damage, maxAmmo, magazine, new ArrayList<>());
    }

    public Gun(String name, double damage, int maxAmmo, Magazine magazine, List<GunEffect> effects) {
        this.name = name;
        this.damage = damage;
        this.maxAmmo = maxAmmo;
        this.magazine = magazine;
        this.effects = effects;
    }

    public void addEffect(GunEffect effect) {
        effects.add(effect);
    }

    public void shoot(Player player, Location location) {

        player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 0.6F, 3.5F);

        if (magazine.getCurrentAmmo() > 0) {
            magazine.decrementAmmo();

            for (GunEffect effect : effects) {
                effect.apply(location, player.getEyeLocation().getDirection());
            }

            Entity target = getTargetEntity(player, 100);
            if (target instanceof LivingEntity) {
                LivingEntity livingTarget = (LivingEntity) target;
                livingTarget.damage(damage);
            }
        } else {
            magazine.reload();
        }
    }


    private Entity getTargetEntity(Player player, double range) {
        List<Entity> nearbyEntities = player.getNearbyEntities(range, range, range);
        Vector rayStart = player.getEyeLocation().toVector();
        Vector rayDirection = player.getEyeLocation().getDirection();

        for (Entity entity : nearbyEntities) {
            if (!(entity instanceof LivingEntity) || entity.equals(player)) {
                continue;
            }

            BoundingBox entityBox = entity.getBoundingBox().expand(0.2);

            if (isRayIntersectingBoundingBox(rayStart, rayDirection, entityBox)) {
                return entity;
            }
        }
        return null;
    }

    private boolean isRayIntersectingBoundingBox(Vector rayStart, Vector rayDirection, BoundingBox box) {
        Vector invDir = new Vector(1.0 / rayDirection.getX(), 1.0 / rayDirection.getY(), 1.0 / rayDirection.getZ());

        double tmin = (box.getMinX() - rayStart.getX()) * invDir.getX();
        double tmax = (box.getMaxX() - rayStart.getX()) * invDir.getX();

        if (tmin > tmax) {
            double temp = tmin;
            tmin = tmax;
            tmax = temp;
        }

        double tymin = (box.getMinY() - rayStart.getY()) * invDir.getY();
        double tymax = (box.getMaxY() - rayStart.getY()) * invDir.getY();

        if (tymin > tymax) {
            double temp = tymin;
            tymin = tymax;
            tymax = temp;
        }

        if ((tmin > tymax) || (tymin > tmax))
            return false;

        if (tymin > tmin)
            tmin = tymin;

        if (tymax < tmax)
            tmax = tymax;

        double tzmin = (box.getMinZ() - rayStart.getZ()) * invDir.getZ();
        double tzmax = (box.getMaxZ() - rayStart.getZ()) * invDir.getZ();

        if (tzmin > tzmax) {
            double temp = tzmin;
            tzmin = tzmax;
            tzmax = temp;
        }

        return !((tmin > tzmax) || (tzmin > tmax));
    }
}
