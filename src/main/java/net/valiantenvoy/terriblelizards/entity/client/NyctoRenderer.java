package net.valiantenvoy.terriblelizards.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.custom.NyctoEntity;
import net.valiantenvoy.terriblelizards.entity.custom.NyctoVariant;

import java.util.Map;

public class NyctoRenderer extends MobRenderer<NyctoEntity, NyctoModel> {

    private static final Map<NyctoVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(NyctoVariant.class), map -> {
                map.put(NyctoVariant.SMALL,
                        ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "textures/entity/nyctosaurus_small.png"));
                map.put(NyctoVariant.MEDIUM,
                        ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "textures/entity/nyctosaurus_medium.png"));
                map.put(NyctoVariant.BIG,
                        ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "textures/entity/nyctosaurus_large.png"));
            });

    public NyctoRenderer(EntityRendererProvider.Context context) {
        super(context, new NyctoModel(context.bakeLayer(NyctoModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(NyctoEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }
}