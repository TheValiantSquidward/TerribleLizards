package net.valiantenvoy.terriblelizards.reg;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.valiantenvoy.terriblelizards.TerribleLizards;

import java.util.function.Supplier;

public class TLItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TerribleLizards.MOD_ID);

    public static final DeferredItem<Item> RAW_NYCTOSAURUS = ITEMS.register("raw_nyctosaurus", () -> new Item(foodItem(TLFoodValues.RAW_NYCTO)));
    public static final DeferredItem<Item> COOKED_NYCTOSAURUS = ITEMS.register("cooked_nyctosaurus", () -> new Item(foodItem(TLFoodValues.COOKED_NYCTO)));



    public static final DeferredItem<Item> NYCTOSAURUS_CREST_SMALL = registerItem("nyctosaurus_crest_small", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NYCTOSAURUS_CREST_MEDIUM = registerItem("nyctosaurus_crest_medium", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NYCTOSAURUS_CREST_LARGE = registerItem("nyctosaurus_crest_large", () -> new Item(new Item.Properties()));

    private static <I extends Item> DeferredItem<I> registerItem(String name, Supplier<? extends I> supplier) {
        return ITEMS.register(name, supplier);
    }

    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }
}
