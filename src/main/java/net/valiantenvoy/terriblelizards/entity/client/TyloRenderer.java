package net.valiantenvoy.terriblelizards.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.custom.PteranodonEntity;
import net.valiantenvoy.terriblelizards.entity.custom.TyloEntity;

public class TyloRenderer extends MobRenderer<TyloEntity, TyloModel> {

    public TyloRenderer(EntityRendererProvider.Context context) {
        super(context, new TyloModel(context.bakeLayer(TyloModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(TyloEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "textures/entity/tylosaurus.png");
    }
}