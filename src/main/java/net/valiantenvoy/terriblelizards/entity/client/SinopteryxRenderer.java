package net.valiantenvoy.terriblelizards.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.custom.SinopteryxEntity;

public class SinopteryxRenderer extends MobRenderer<SinopteryxEntity, SinopteryxModel> {

    public SinopteryxRenderer(EntityRendererProvider.Context context) {
        super(context, new SinopteryxModel(context.bakeLayer(SinopteryxModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(SinopteryxEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "textures/entity/sinopteryx.png");
    }
}