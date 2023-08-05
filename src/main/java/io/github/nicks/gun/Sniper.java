package io.github.nicks.gun;

import io.github.nicks.gun.effect.GunEffect;
import io.github.nicks.magazine.Magazine;
import io.github.nicks.magazine.impl.RifleMagazine;

import java.util.ArrayList;
import java.util.List;

public class Sniper extends Gun {

    public Sniper(GunEffect... effects) {
        super("Rifle", 20, 30, new RifleMagazine(), new ArrayList<>(List.of(effects)));
    }
}
