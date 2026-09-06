package net.valiantenvoy.terriblelizards.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum NyctoVariant {
    SMALL(0),
    MEDIUM(1),
    BIG(2);


    private static final NyctoVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(NyctoVariant::getId)).toArray(NyctoVariant[]::new);
    private final int id;

    NyctoVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static NyctoVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}