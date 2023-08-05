package io.github.nicks.gun;

import io.github.nicks.gun.effect.GunEffect;
import io.github.nicks.magazine.impl.PistolMagazine;

import java.util.ArrayList;
import java.util.List;

public class Pistol extends Gun {

    public Pistol(GunEffect... effects) {
        super("Pistol", 5, 10, new PistolMagazine(), new ArrayList<>(List.of(effects)));
    }
}
