package io.github.nicks.magazine;

public class AbstractMagazine implements Magazine {

    protected int maxAmmo;
    protected int currentAmmo;

    public AbstractMagazine(int maxAmmo) {
        this.maxAmmo = maxAmmo;
        this.currentAmmo = maxAmmo;
    }

    @Override
    public int getCurrentAmmo() {
        return currentAmmo;
    }

    @Override
    public void decrementAmmo() {
        if (currentAmmo > 0) {
            currentAmmo--;
        }
    }

    @Override
    public void reload() {
        currentAmmo = maxAmmo;
    }
}
