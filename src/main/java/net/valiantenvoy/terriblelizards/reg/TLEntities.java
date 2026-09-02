package net.valiantenvoy.terriblelizards.reg;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.custom.NyctoEntity;
import net.valiantenvoy.terriblelizards.entity.custom.PteranodonEntity;

import java.util.function.Supplier;

public class TLEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TerribleLizards.MOD_ID);

    public static final Supplier<EntityType<NyctoEntity>> NYCTOSAURUS =
            ENTITY_TYPES.register("nyctosaurus", () -> EntityType.Builder.of(NyctoEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.35f).build("nyctosaurus"));

    public static final Supplier<EntityType<PteranodonEntity>> PTERANODON =
            ENTITY_TYPES.register("pteranodon", () -> EntityType.Builder.of(PteranodonEntity::new, MobCategory.CREATURE)
                    .sized(1.75f, 1.35f).build("pteranodon"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
