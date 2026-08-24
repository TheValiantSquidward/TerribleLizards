package net.valiantenvoy.terriblelizards.reg;

import net.minecraft.world.food.FoodProperties;

public class TLFoodValues {

    public static final FoodProperties RAW_NYCTO = (new FoodProperties.Builder())
            .nutrition(1).saturationModifier(0.3F)
            .build();

    public static final FoodProperties COOKED_NYCTO = (new FoodProperties.Builder())
            .nutrition(2).saturationModifier(0.3F)
            .fast()
            .build();

}