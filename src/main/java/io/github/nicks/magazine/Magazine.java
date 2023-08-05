package io.github.nicks.magazine;

public interface Magazine {

    int getCurrentAmmo();
    void decrementAmmo();
    void reload();
}