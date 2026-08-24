package net.valiantenvoy;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.client.NyctoModel;
import net.valiantenvoy.terriblelizards.entity.custom.NyctoEntity;
import net.valiantenvoy.terriblelizards.reg.TLEntities;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = TerribleLizards.MOD_ID, value = Dist.CLIENT)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(NyctoModel.LAYER_LOCATION, NyctoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(TLEntities.NYCTOSAURUS.get(), NyctoEntity.createAttributes().build());
    }
}