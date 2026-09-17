package net.valiantenvoy.terriblelizards.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.custom.TyloEntity;

public class TyloModel extends ModModel<TyloEntity>  {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "tylosaurus"), "main");

    private final ModelPart root2;
    private final ModelPart swim_control;
    private final ModelPart body;
    private final ModelPart neck2;
    private final ModelPart head2;
    private final ModelPart jaw_upper;
    private final ModelPart jaw_lower1;
    private final ModelPart jaw_lower2;
    private final ModelPart tongue1;
    private final ModelPart tongue2;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart backbody;
    private final ModelPart tail1;
    private final ModelPart left_leg;
    private final ModelPart right_leg;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;

    public TyloModel(ModelPart root) {
        super(0.5F, 24);
        this.root2 = root.getChild("root2");
        this.swim_control = this.root2.getChild("swim_control");
        this.body = this.swim_control.getChild("body");
        this.neck2 = this.body.getChild("neck2");
        this.head2 = this.neck2.getChild("head2");
        this.jaw_upper = this.head2.getChild("jaw_upper");
        this.jaw_lower1 = this.head2.getChild("jaw_lower1");
        this.jaw_lower2 = this.jaw_lower1.getChild("jaw_lower2");
        this.tongue1 = this.jaw_lower1.getChild("tongue1");
        this.tongue2 = this.tongue1.getChild("tongue2");
        this.left_arm = this.body.getChild("left_arm");
        this.right_arm = this.body.getChild("right_arm");
        this.backbody = this.body.getChild("backbody");
        this.tail1 = this.backbody.getChild("tail1");
        this.left_leg = this.tail1.getChild("left_leg");
        this.right_leg = this.tail1.getChild("right_leg");
        this.tail2 = this.tail1.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.tail4 = this.tail3.getChild("tail4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root2 = partdefinition.addOrReplaceChild("root2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition swim_control = root2.addOrReplaceChild("swim_control", CubeListBuilder.create(), PartPose.offset(0.0F, -21.0F, 0.0F));

        PartDefinition body = swim_control.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -11.0F, -32.0F, 32.0F, 34.0F, 55.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition neck2 = body.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(174, 0).addBox(-12.5F, -7.0F, -11.0F, 25.0F, 27.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -33.0F));

        PartDefinition head2 = neck2.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -13.0F));

        PartDefinition jaw_upper = head2.addOrReplaceChild("jaw_upper", CubeListBuilder.create().texOffs(120, 89).addBox(-6.0F, -3.0F, -44.0F, 12.0F, 9.0F, 50.0F, new CubeDeformation(0.0F))
                .texOffs(78, 228).addBox(-2.0F, 6.0F, -17.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(78, 228).addBox(2.0F, 6.0F, -17.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(190, 205).addBox(-5.0F, 6.0F, -39.0F, 0.0F, 2.0F, 33.0F, new CubeDeformation(0.0F))
                .texOffs(112, 153).addBox(-2.0F, 6.0F, -18.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(190, 205).addBox(5.0F, 6.0F, -39.0F, 0.0F, 2.0F, 33.0F, new CubeDeformation(0.0F))
                .texOffs(236, 203).addBox(-5.0F, 6.0F, -40.0F, 10.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(128, 239).addBox(-6.0F, 5.75F, -7.0F, 12.0F, 11.0F, 13.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition jaw_lower1 = head2.addOrReplaceChild("jaw_lower1", CubeListBuilder.create().texOffs(220, 75).addBox(-3.5F, -1.0F, -23.0F, 7.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(174, 41).addBox(-9.0F, 0.0F, -23.0F, 18.0F, 11.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 6.0F));

        PartDefinition jaw_lower2 = jaw_lower1.addOrReplaceChild("jaw_lower2", CubeListBuilder.create().texOffs(112, 205).addBox(-6.0F, -6.0F, -17.0F, 12.0F, 7.0F, 27.0F, new CubeDeformation(0.0F))
                .texOffs(78, 239).addBox(-4.0F, -8.0F, -10.0F, 0.0F, 2.0F, 25.0F, new CubeDeformation(0.0F))
                .texOffs(94, 237).addBox(-4.0F, -8.0F, -13.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(178, 240).addBox(4.0F, -8.0F, -10.0F, 0.0F, 2.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -33.0F));

        PartDefinition tongue1 = jaw_lower1.addOrReplaceChild("tongue1", CubeListBuilder.create().texOffs(236, 184).addBox(-2.5F, 0.0F, -19.0F, 5.0F, 0.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -11.0F));

        PartDefinition tongue2 = tongue1.addOrReplaceChild("tongue2", CubeListBuilder.create().texOffs(174, 75).addBox(-4.5F, 0.0F, -14.0F, 9.0F, 0.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -19.0F));

        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(78, 209).addBox(-3.0F, -1.0F, -5.0F, 4.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 209).addBox(-3.0F, 8.0F, -5.0F, 4.0F, 23.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(15.5F, 11.0F, -25.0F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(78, 209).mirror().addBox(-1.0F, -1.0F, -5.0F, 4.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 209).mirror().addBox(-1.0F, 8.0F, -5.0F, 4.0F, 23.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-16.5F, 11.0F, -25.0F));

        PartDefinition backbody = body.addOrReplaceChild("backbody", CubeListBuilder.create().texOffs(0, 89).addBox(-12.0F, -11.0F, -7.0F, 24.0F, 28.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 27.0F));

        PartDefinition tail1 = backbody.addOrReplaceChild("tail1", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 15.0F));

        PartDefinition left_leg = tail1.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(242, 240).addBox(-3.0F, -1.0F, -3.5F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(236, 148).addBox(-3.0F, 4.0F, -3.5F, 4.0F, 19.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(11.5F, 2.0F, -2.5F));

        PartDefinition right_leg = tail1.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(242, 240).mirror().addBox(-1.0F, -1.0F, -3.5F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(236, 148).mirror().addBox(-1.0F, 4.0F, -3.5F, 4.0F, 19.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-11.5F, 2.0F, -2.5F));

        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(120, 148).addBox(-8.5F, -8.0F, 0.0F, 17.0F, 16.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

        PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 153).addBox(-4.5F, -5.0F, -4.0F, 10.0F, 10.0F, 46.0F, new CubeDeformation(0.0F))
                .texOffs(222, 240).addBox(-0.5F, -16.0F, 33.0F, 2.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(244, 89).addBox(-0.5F, -16.0F, 41.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 40.0F));

        PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 37.0F));

        PartDefinition cube_r1 = tail4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(94, 228).addBox(-0.5F, 27.0F, 13.0F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(44, 209).addBox(-0.5F, -3.0F, -2.0F, 2.0F, 35.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void setupAnim(TyloEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return root2;
    }
}