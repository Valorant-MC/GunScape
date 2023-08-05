package io.github.nicks.gun;

import io.github.nicks.gun.effect.GunEffect;
import io.github.nicks.magazine.impl.RifleMagazine;

import java.util.ArrayList;
import java.util.List;

public class Rifle extends Gun {

    public Rifle(GunEffect... effects) {
        super("Rifle", 6, 30, new RifleMagazine(), new ArrayList<>(List.of(effects)));
    }
}
