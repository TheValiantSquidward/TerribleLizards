package net.valiantenvoy.terriblelizards.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.custom.PteranodonEntity;

public class PteranodonRenderer extends MobRenderer<PteranodonEntity, PteranodonModel> {

    public PteranodonRenderer(EntityRendererProvider.Context context) {
        super(context, new PteranodonModel(context.bakeLayer(PteranodonModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(PteranodonEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "textures/entity/pteranodon_male.png");
    }
}