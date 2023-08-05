package io.github.nicks.listener;

import io.github.nicks.gun.Rifle;
import io.github.nicks.gun.effect.SmokeEffect;
import io.github.nicks.gun.effect.TrailEffect;
import io.github.nicks.gun.effect.GunEffect;
import io.github.nicks.gun.effect.MuzzleFlashEffect;
import org.bukkit.Particle;
import org.bukkit.event.Listener;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class GunListener implements Listener {

    private final GunEffect bulletTrailEffect = new TrailEffect(Particle.CRIT, 1, 0.05, 0.6, 100);
    private final Rifle pistol = new Rifle(new MuzzleFlashEffect(), new SmokeEffect(), bulletTrailEffect);

    @EventHandler
    public void onSneak(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.CROSSBOW && event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK ) {
            player.sendMessage("ㅎㅇ");
        }

        if (item != null && item.getType() == Material.IRON_INGOT) {
            pistol.shoot(player, player.getLocation().add(0, 1.5, 0));
        }
    }
}