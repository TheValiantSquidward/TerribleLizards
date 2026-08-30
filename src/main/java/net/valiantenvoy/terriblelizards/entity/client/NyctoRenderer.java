package net.valiantenvoy.terriblelizards.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.custom.NyctoEntity;

public class NyctoRenderer extends MobRenderer<NyctoEntity, NyctoModel> {

    public NyctoRenderer(EntityRendererProvider.Context context) {
        super(context, new NyctoModel(context.bakeLayer(NyctoModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(NyctoEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "textures/entity/nyctosaurus_medium.png");
    }
}