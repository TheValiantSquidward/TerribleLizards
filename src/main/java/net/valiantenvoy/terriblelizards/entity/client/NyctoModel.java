package net.valiantenvoy.terriblelizards.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.custom.NyctoEntity;

public class NyctoModel<T extends NyctoEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "nyctosaurus"), "main");

    private final ModelPart nyctosaurus;
    private final ModelPart nyctosaurusplatformcontrol2;
    private final ModelPart nyctosaurusplatformcontrol;
    private final ModelPart body;
    private final ModelPart torso;
    private final ModelPart head;
    private final ModelPart tailmembrane;
    private final ModelPart rightlimbs;
    private final ModelPart rightwing1;
    private final ModelPart rightarmmembrane;
    private final ModelPart rightmembrane1;
    private final ModelPart rightcovermembrane;
    private final ModelPart rightwing2;
    private final ModelPart rightmembrane2;
    private final ModelPart rightwing3;
    private final ModelPart rightmembrane3;
    private final ModelPart rightleg;
    private final ModelPart leftlimbs;
    private final ModelPart leftwing1;
    private final ModelPart leftmembrane1;
    private final ModelPart leftcovermembrane;
    private final ModelPart leftwing2;
    private final ModelPart leftmembrane2;
    private final ModelPart leftwing3;
    private final ModelPart leftmembrane3;
    private final ModelPart leftarmmembrane;
    private final ModelPart leftleg;

    public NyctoModel(ModelPart root) {
        this.nyctosaurus = root.getChild("nyctosaurus");
        this.nyctosaurusplatformcontrol2 = this.nyctosaurus.getChild("nyctosaurusplatformcontrol2");
        this.nyctosaurusplatformcontrol = this.nyctosaurusplatformcontrol2.getChild("nyctosaurusplatformcontrol");
        this.body = this.nyctosaurusplatformcontrol.getChild("body");
        this.torso = this.body.getChild("torso");
        this.head = this.body.getChild("head");
        this.tailmembrane = this.nyctosaurusplatformcontrol.getChild("tailmembrane");
        this.rightlimbs = this.nyctosaurusplatformcontrol.getChild("rightlimbs");
        this.rightwing1 = this.rightlimbs.getChild("rightwing1");
        this.rightarmmembrane = this.rightwing1.getChild("rightarmmembrane");
        this.rightmembrane1 = this.rightwing1.getChild("rightmembrane1");
        this.rightcovermembrane = this.rightwing1.getChild("rightcovermembrane");
        this.rightwing2 = this.rightwing1.getChild("rightwing2");
        this.rightmembrane2 = this.rightwing2.getChild("rightmembrane2");
        this.rightwing3 = this.rightwing2.getChild("rightwing3");
        this.rightmembrane3 = this.rightwing3.getChild("rightmembrane3");
        this.rightleg = this.rightlimbs.getChild("rightleg");
        this.leftlimbs = this.nyctosaurusplatformcontrol.getChild("leftlimbs");
        this.leftwing1 = this.leftlimbs.getChild("leftwing1");
        this.leftmembrane1 = this.leftwing1.getChild("leftmembrane1");
        this.leftcovermembrane = this.leftwing1.getChild("leftcovermembrane");
        this.leftwing2 = this.leftwing1.getChild("leftwing2");
        this.leftmembrane2 = this.leftwing2.getChild("leftmembrane2");
        this.leftwing3 = this.leftwing2.getChild("leftwing3");
        this.leftmembrane3 = this.leftwing3.getChild("leftmembrane3");
        this.leftarmmembrane = this.leftwing1.getChild("leftarmmembrane");
        this.leftleg = this.leftlimbs.getChild("leftleg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition nyctosaurus = partdefinition.addOrReplaceChild("nyctosaurus", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 1.0F));

        PartDefinition nyctosaurusplatformcontrol2 = nyctosaurus.addOrReplaceChild("nyctosaurusplatformcontrol2", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 4.0F));

        PartDefinition nyctosaurusplatformcontrol = nyctosaurusplatformcontrol2.addOrReplaceChild("nyctosaurusplatformcontrol", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -1.0F));

        PartDefinition body = nyctosaurusplatformcontrol.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -4.684F, -5.8794F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(18, 22).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-0.5F, -2.0F, -5.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(30, 7).addBox(-0.5F, -1.0F, -9.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, -10).addBox(0.0F, -22.0F, -2.0F, 0.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition tailmembrane = nyctosaurusplatformcontrol.addOrReplaceChild("tailmembrane", CubeListBuilder.create().texOffs(24, 19).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.684F, -1.8794F));

        PartDefinition rightlimbs = nyctosaurusplatformcontrol.addOrReplaceChild("rightlimbs", CubeListBuilder.create(), PartPose.offset(-1.0F, -4.684F, -5.8794F));

        PartDefinition rightwing1 = rightlimbs.addOrReplaceChild("rightwing1", CubeListBuilder.create().texOffs(28, 35).mirror().addBox(0.0F, 2.0F, -1.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false)
                .texOffs(26, 35).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightarmmembrane = rightwing1.addOrReplaceChild("rightarmmembrane", CubeListBuilder.create().texOffs(8, 28).mirror().addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, 0.0F));

        PartDefinition rightmembrane1 = rightwing1.addOrReplaceChild("rightmembrane1", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(1.0F, -2.0F, -1.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 2.0F, 0.0F));

        PartDefinition rightcovermembrane = rightwing1.addOrReplaceChild("rightcovermembrane", CubeListBuilder.create().texOffs(30, 12).mirror().addBox(1.0F, -4.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(-1.0F, 3.0F, 1.0F));

        PartDefinition rightwing2 = rightwing1.addOrReplaceChild("rightwing2", CubeListBuilder.create().texOffs(32, 22).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offset(0.0F, 5.0F, -1.0F));

        PartDefinition rightmembrane2 = rightwing2.addOrReplaceChild("rightmembrane2", CubeListBuilder.create().texOffs(18, 29).mirror().addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition rightwing3 = rightwing2.addOrReplaceChild("rightwing3", CubeListBuilder.create().texOffs(34, 19).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition rightmembrane3 = rightwing3.addOrReplaceChild("rightmembrane3", CubeListBuilder.create().texOffs(24, 7).mirror().addBox(0.0F, -1.0F, 0.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, 0.0F));

        PartDefinition rightleg = rightlimbs.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(26, 29).mirror().addBox(1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offset(-1.0F, 0.0F, 3.0F));

        PartDefinition leftlimbs = nyctosaurusplatformcontrol.addOrReplaceChild("leftlimbs", CubeListBuilder.create(), PartPose.offset(1.0F, -4.684F, -5.8794F));

        PartDefinition leftwing1 = leftlimbs.addOrReplaceChild("leftwing1", CubeListBuilder.create().texOffs(28, 35).addBox(0.0F, 2.0F, -1.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.05F))
                .texOffs(26, 35).addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftmembrane1 = leftwing1.addOrReplaceChild("leftmembrane1", CubeListBuilder.create().texOffs(0, 22).addBox(1.0F, -2.0F, -1.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 2.0F, 0.0F));

        PartDefinition leftcovermembrane = leftwing1.addOrReplaceChild("leftcovermembrane", CubeListBuilder.create().texOffs(30, 12).addBox(1.0F, -4.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.025F)), PartPose.offset(-1.0F, 3.0F, 1.0F));

        PartDefinition leftwing2 = leftwing1.addOrReplaceChild("leftwing2", CubeListBuilder.create().texOffs(32, 22).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 5.0F, -1.0F));

        PartDefinition leftmembrane2 = leftwing2.addOrReplaceChild("leftmembrane2", CubeListBuilder.create().texOffs(18, 29).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition leftwing3 = leftwing2.addOrReplaceChild("leftwing3", CubeListBuilder.create().texOffs(34, 19).addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition leftmembrane3 = leftwing3.addOrReplaceChild("leftmembrane3", CubeListBuilder.create().texOffs(24, 7).addBox(0.0F, -1.0F, 0.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

        PartDefinition leftarmmembrane = leftwing1.addOrReplaceChild("leftarmmembrane", CubeListBuilder.create().texOffs(8, 28).addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

        PartDefinition leftleg = leftlimbs.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(26, 29).addBox(1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.05F)), PartPose.offset(-1.0F, 0.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(NyctoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float partialTicks = ageInTicks - entity.tickCount;

       // this.animateSmooth(entity.idleAnimationState, NyctoAnimations.GROUD_IDLE, ageInTicks, partialTicks);
       // this.animateSmooth(entity.flyAnimationState, NyctoAnimations.FLY, ageInTicks, partialTicks, 1.25F);
       // this.animateSmooth(entity.flyFastAnimationState, NyctoAnimations.FLYFAST, ageInTicks, partialTicks);

        float rollAmount = entity.getFlightRoll(partialTicks) / (180F / (float) Math.PI);
        float flightPitchAmount = entity.getFlightPitch(partialTicks) / (180F / (float) Math.PI);

        if (entity.isFlying()) {
            this.nyctosaurus.xRot += flightPitchAmount;
            this.nyctosaurus.zRot += rollAmount;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        nyctosaurus.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return nyctosaurus;
    }

}