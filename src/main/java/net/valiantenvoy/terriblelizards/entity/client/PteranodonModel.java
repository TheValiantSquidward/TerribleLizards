package net.valiantenvoy.terriblelizards.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.valiantenvoy.terriblelizards.TerribleLizards;
import net.valiantenvoy.terriblelizards.entity.custom.PteranodonEntity;

public class PteranodonModel extends ModModel<PteranodonEntity>  {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TerribleLizards.MOD_ID, "pteranodon"), "main");
    private final ModelPart Pteranodon;
    private final ModelPart upperbody;
    private final ModelPart mainbody;
    private final ModelPart torso;
    private final ModelPart tailclosed;
    private final ModelPart tailopen;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart wing_control;
    private final ModelPart rightarm;
    private final ModelPart rightwing;
    private final ModelPart rightwingback;
    private final ModelPart rightforearm;
    private final ModelPart righthand;
    private final ModelPart rightfrontmembrane_open;
    private final ModelPart rightwingmiddle_open;
    private final ModelPart rightwingtip_control;
    private final ModelPart rightwingtip_open;
    private final ModelPart rightwingtip_folded;
    private final ModelPart righttopmembrane_open;
    private final ModelPart leftarm;
    private final ModelPart leftwing;
    private final ModelPart leftwingback;
    private final ModelPart leftforearm;
    private final ModelPart lefthand;
    private final ModelPart leftfrontmembrane_open;
    private final ModelPart leftwingmiddle_open;
    private final ModelPart leftwingtip_control;
    private final ModelPart leftwingtip_open;
    private final ModelPart leftwingtip_folded;
    private final ModelPart lefttopmembrane_open;
    private final ModelPart leg_control;
    private final ModelPart rightleg;
    private final ModelPart rightlegwing_folded;
    private final ModelPart rightlegflapless;
    private final ModelPart rightfoot;
    private final ModelPart leftleg;
    private final ModelPart leftlegwing_folded;
    private final ModelPart leftlegflapless;
    private final ModelPart leftfoot;

    public PteranodonModel(ModelPart root) {
        super(0.5F, 24);
        this.Pteranodon = root.getChild("Pteranodon");
        this.upperbody = this.Pteranodon.getChild("upperbody");
        this.mainbody = this.upperbody.getChild("mainbody");
        this.torso = this.mainbody.getChild("torso");
        this.tailclosed = this.mainbody.getChild("tailclosed");
        this.tailopen = this.mainbody.getChild("tailopen");
        this.neck = this.mainbody.getChild("neck");
        this.head = this.neck.getChild("head");
        this.jaw = this.head.getChild("jaw");
        this.wing_control = this.upperbody.getChild("wing_control");
        this.rightarm = this.wing_control.getChild("rightarm");
        this.rightwing = this.rightarm.getChild("rightwing");
        this.rightwingback = this.rightwing.getChild("rightwingback");
        this.rightforearm = this.rightwing.getChild("rightforearm");
        this.righthand = this.rightforearm.getChild("righthand");
        this.rightfrontmembrane_open = this.rightforearm.getChild("rightfrontmembrane_open");
        this.rightwingmiddle_open = this.rightforearm.getChild("rightwingmiddle_open");
        this.rightwingtip_control = this.rightforearm.getChild("rightwingtip_control");
        this.rightwingtip_open = this.rightwingtip_control.getChild("rightwingtip_open");
        this.rightwingtip_folded = this.rightwingtip_control.getChild("rightwingtip_folded");
        this.righttopmembrane_open = this.rightwing.getChild("righttopmembrane_open");
        this.leftarm = this.wing_control.getChild("leftarm");
        this.leftwing = this.leftarm.getChild("leftwing");
        this.leftwingback = this.leftwing.getChild("leftwingback");
        this.leftforearm = this.leftwing.getChild("leftforearm");
        this.lefthand = this.leftforearm.getChild("lefthand");
        this.leftfrontmembrane_open = this.leftforearm.getChild("leftfrontmembrane_open");
        this.leftwingmiddle_open = this.leftforearm.getChild("leftwingmiddle_open");
        this.leftwingtip_control = this.leftforearm.getChild("leftwingtip_control");
        this.leftwingtip_open = this.leftwingtip_control.getChild("leftwingtip_open");
        this.leftwingtip_folded = this.leftwingtip_control.getChild("leftwingtip_folded");
        this.lefttopmembrane_open = this.leftwing.getChild("lefttopmembrane_open");
        this.leg_control = this.Pteranodon.getChild("leg_control");
        this.rightleg = this.leg_control.getChild("rightleg");
        this.rightlegwing_folded = this.rightleg.getChild("rightlegwing_folded");
        this.rightlegflapless = this.rightleg.getChild("rightlegflapless");
        this.rightfoot = this.rightlegflapless.getChild("rightfoot");
        this.leftleg = this.leg_control.getChild("leftleg");
        this.leftlegwing_folded = this.leftleg.getChild("leftlegwing_folded");
        this.leftlegflapless = this.leftleg.getChild("leftlegflapless");
        this.leftfoot = this.leftlegflapless.getChild("leftfoot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Pteranodon = partdefinition.addOrReplaceChild("Pteranodon", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 3.0F));

        PartDefinition upperbody = Pteranodon.addOrReplaceChild("upperbody", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 1.0F));

        PartDefinition mainbody = upperbody.addOrReplaceChild("mainbody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition torso = mainbody.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(46, 16).addBox(-3.0F, -3.0F, -4.0F, 7.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -7.0F, 0.0F));

        PartDefinition tailclosed = mainbody.addOrReplaceChild("tailclosed", CubeListBuilder.create().texOffs(22, 76).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 3.0F, 0.0F));

        PartDefinition tailopen = mainbody.addOrReplaceChild("tailopen", CubeListBuilder.create().texOffs(78, 0).addBox(-3.5F, 0.0F, -1.0F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.025F))
                .texOffs(78, 0).addBox(-3.5F, 0.0F, -1.1F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 3.0F, 1.0F));

        PartDefinition neck = mainbody.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(20, 62).addBox(-1.5F, -8.0F, -4.0F, 3.0F, 7.0F, 7.0F, new CubeDeformation(-0.025F)), PartPose.offset(0.0F, -6.0F, -1.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 68).addBox(-1.0F, -2.0F, -4.0F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -9.0F, 1.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(46, 0).addBox(-0.5F, -4.0F, -19.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(74, 71).addBox(-0.5F, -5.0F, -5.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -4.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(40, 62).addBox(-1.0F, 1.5F, 7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(66, 48).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 76).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(66, 60).addBox(-1.5F, 0.0F, -4.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 1.0F, -2.0F));

        PartDefinition cube_r3 = jaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(48, 35).addBox(-0.5F, -2.0F, -19.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 65).addBox(-0.5F, -2.0F, -8.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -2.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition wing_control = upperbody.addOrReplaceChild("wing_control", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, -3.0F));

        PartDefinition rightarm = wing_control.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(78, 6).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.025F)), PartPose.offset(-4.5F, -2.0F, 2.5F));

        PartDefinition rightwing = rightarm.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(56, 71).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -0.5F));

        PartDefinition rightwingback = rightwing.addOrReplaceChild("rightwingback", CubeListBuilder.create().texOffs(0, 37).addBox(0.0F, -1.75F, -5.0F, 0.0F, 18.0F, 10.0F, new CubeDeformation(0.025F))
                .texOffs(24, 79).addBox(0.1F, -1.75F, -5.0F, 0.0F, 18.0F, 10.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 3.0F, -3.0F));

        PartDefinition rightforearm = rightwing.addOrReplaceChild("rightforearm", CubeListBuilder.create().texOffs(72, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 14.0F, 3.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 0.0F, -8.0F));

        PartDefinition righthand = rightforearm.addOrReplaceChild("righthand", CubeListBuilder.create().texOffs(20, 51).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition rightfrontmembrane_open = rightforearm.addOrReplaceChild("rightfrontmembrane_open", CubeListBuilder.create().texOffs(20, 37).addBox(0.0F, 0.0F, -2.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.025F))
                .texOffs(20, 37).addBox(0.1F, 0.0F, -2.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightwingmiddle_open = rightforearm.addOrReplaceChild("rightwingmiddle_open", CubeListBuilder.create().texOffs(44, 88).addBox(0.1F, -7.0F, -1.75F, 0.0F, 14.0F, 12.0F, new CubeDeformation(0.05F))
                .texOffs(24, 36).addBox(-0.1F, -7.0F, -1.75F, 0.0F, 14.0F, 12.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 7.0F, 2.0F));

        PartDefinition rightwingtip_control = rightforearm.addOrReplaceChild("rightwingtip_control", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 1.0F));

        PartDefinition rightwingtip_open = rightwingtip_control.addOrReplaceChild("rightwingtip_open", CubeListBuilder.create().texOffs(0, 77).addBox(0.1F, 0.0F, -0.75F, 0.0F, 25.0F, 12.0F, new CubeDeformation(0.025F))
                .texOffs(0, 0).addBox(0.0F, 0.0F, -0.75F, 0.0F, 25.0F, 12.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightwingtip_folded = rightwingtip_control.addOrReplaceChild("rightwingtip_folded", CubeListBuilder.create().texOffs(96, 8).addBox(0.1F, 0.0F, -0.75F, 0.0F, 25.0F, 11.0F, new CubeDeformation(0.025F))
                .texOffs(24, 0).addBox(0.0F, 0.0F, -0.75F, 0.0F, 25.0F, 11.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition righttopmembrane_open = rightwing.addOrReplaceChild("righttopmembrane_open", CubeListBuilder.create().texOffs(74, 33).addBox(0.1F, -5.0F, -7.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition cube_r4 = righttopmembrane_open.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(74, 33).addBox(5.0F, 11.0F, 4.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.025F)), PartPose.offsetAndRotation(-5.0F, -16.0F, -11.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition leftarm = wing_control.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(78, 6).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(4.5F, -2.0F, 2.5F));

        PartDefinition leftwing = leftarm.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(56, 71).mirror().addBox(-1.0F, 0.0F, -8.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, -0.5F));

        PartDefinition leftwingback = leftwing.addOrReplaceChild("leftwingback", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(0.0F, -1.75F, -5.0F, 0.0F, 18.0F, 10.0F, new CubeDeformation(0.05F)).mirror(false)
                .texOffs(24, 79).mirror().addBox(-0.1F, -1.75F, -5.0F, 0.0F, 18.0F, 10.0F, new CubeDeformation(0.05F)).mirror(false), PartPose.offset(0.0F, 3.0F, -3.0F));

        PartDefinition leftforearm = leftwing.addOrReplaceChild("leftforearm", CubeListBuilder.create().texOffs(72, 16).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 14.0F, 3.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(0.0F, 0.0F, -8.0F));

        PartDefinition lefthand = leftforearm.addOrReplaceChild("lefthand", CubeListBuilder.create().texOffs(20, 51).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition leftfrontmembrane_open = leftforearm.addOrReplaceChild("leftfrontmembrane_open", CubeListBuilder.create().texOffs(20, 37).mirror().addBox(-0.1F, 0.0F, -2.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.025F)).mirror(false)
                .texOffs(20, 37).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftwingmiddle_open = leftforearm.addOrReplaceChild("leftwingmiddle_open", CubeListBuilder.create().texOffs(24, 36).mirror().addBox(0.1F, -7.0F, -1.75F, 0.0F, 14.0F, 12.0F, new CubeDeformation(0.025F)).mirror(false)
                .texOffs(44, 88).mirror().addBox(-0.1F, -7.0F, -1.75F, 0.0F, 14.0F, 12.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(0.0F, 7.0F, 2.0F));

        PartDefinition leftwingtip_control = leftforearm.addOrReplaceChild("leftwingtip_control", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 1.0F));

        PartDefinition leftwingtip_open = leftwingtip_control.addOrReplaceChild("leftwingtip_open", CubeListBuilder.create().texOffs(0, 77).mirror().addBox(-0.1F, 0.0F, -0.75F, 0.0F, 25.0F, 12.0F, new CubeDeformation(0.025F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -0.75F, 0.0F, 25.0F, 12.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftwingtip_folded = leftwingtip_control.addOrReplaceChild("leftwingtip_folded", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-0.1F, 0.0F, -0.75F, 0.0F, 25.0F, 11.0F, new CubeDeformation(0.025F)).mirror(false)
                .texOffs(24, 0).mirror().addBox(0.0F, 0.0F, -0.75F, 0.0F, 25.0F, 11.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition lefttopmembrane_open = leftwing.addOrReplaceChild("lefttopmembrane_open", CubeListBuilder.create().texOffs(74, 33).mirror().addBox(-0.1F, -5.0F, -7.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.025F)).mirror(false)
                .texOffs(74, 33).mirror().addBox(0.0F, -5.0F, -7.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition leg_control = Pteranodon.addOrReplaceChild("leg_control", CubeListBuilder.create(), PartPose.offset(0.0F, 8.5F, 1.0F));

        PartDefinition rightleg = leg_control.addOrReplaceChild("rightleg", CubeListBuilder.create(), PartPose.offset(-3.25F, 0.0F, 0.0F));

        PartDefinition rightlegwing_folded = rightleg.addOrReplaceChild("rightlegwing_folded", CubeListBuilder.create().texOffs(48, 48).addBox(0.0F, -11.0F, -9.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.025F))
                .texOffs(48, 48).addBox(0.1F, -11.0F, -9.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.025F)), PartPose.offset(-0.5F, 6.0F, 0.0F));

        PartDefinition rightlegflapless = rightleg.addOrReplaceChild("rightlegflapless", CubeListBuilder.create().texOffs(14, 76).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition rightfoot = rightlegflapless.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(20, 56).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.025F)), PartPose.offset(0.0F, 10.0F, -1.0F));

        PartDefinition leftleg = leg_control.addOrReplaceChild("leftleg", CubeListBuilder.create(), PartPose.offset(3.25F, 0.0F, 0.0F));

        PartDefinition leftlegwing_folded = leftleg.addOrReplaceChild("leftlegwing_folded", CubeListBuilder.create().texOffs(48, 48).mirror().addBox(0.1F, -11.0F, -9.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.025F)).mirror(false)
                .texOffs(48, 48).mirror().addBox(-0.1F, -11.0F, -9.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(0.5F, 6.0F, 0.0F));

        PartDefinition leftlegflapless = leftleg.addOrReplaceChild("leftlegflapless", CubeListBuilder.create().texOffs(14, 76).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftfoot = leftlegflapless.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(20, 56).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.025F)).mirror(false), PartPose.offset(0.0F, 10.0F, -1.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    
    @Override
    public void setupAnim(PteranodonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        float partialTicks = ageInTicks - entity.tickCount;

        this.animateSmooth(entity.idleAnimationState, PteranodonAnimations.idle, ageInTicks, partialTicks);
        this.animateSmooth(entity.flyAnimationState, PteranodonAnimations.soar, ageInTicks, partialTicks, 1.25F);
        this.animateSmooth(entity.flapAnimationState, PteranodonAnimations.flap, ageInTicks, partialTicks);

        float rollAmount = entity.getFlightRoll(partialTicks) / (180F / (float) Math.PI);
        float flightPitchAmount = entity.getFlightPitch(partialTicks) / (180F / (float) Math.PI);

        if (entity.isFlying()) {
            this.Pteranodon.xRot += flightPitchAmount;
            this.Pteranodon.zRot += rollAmount;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Pteranodon.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Pteranodon;
    }

}