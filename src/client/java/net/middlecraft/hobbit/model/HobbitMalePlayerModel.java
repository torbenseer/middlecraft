package net.middlecraft.hobbit.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class HobbitMaleModel extends PlayerEntityModel {
    public final ModelPart hat;
    public final ModelPart head;
    public final ModelPart body;
    public final ModelPart leftArm;
    public final ModelPart rightArm;
    public final ModelPart leftLeg;
    public final ModelPart rightLeg;
    public final ModelPart leftSleeve;
    public final ModelPart rightSleeve;
    public final ModelPart leftPants;
    public final ModelPart rightPants;
    public final ModelPart jacket;

    public HobbitMaleModel(ModelPart root) {
        super(root, false); // Verwende kein Slim-Modell
        this.hat = root.getChild("hat");
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.leftArm = root.getChild("left_arm");
        this.rightArm = root.getChild("right_arm");
        this.leftLeg = root.getChild("left_leg");
        this.rightLeg = root.getChild("right_leg");
        this.leftSleeve = this.leftArm.getChild("left_sleeve");
        this.rightSleeve = this.rightArm.getChild("right_sleeve");
        this.leftPants = this.leftLeg.getChild("left_pants");
        this.rightPants = this.rightLeg.getChild("right_pants");
        this.jacket = this.body.getChild("jacket");
    }

    public static TexturedModelData getTexturedModel() {
        ModelData modelData = BipedEntityModel.getModelData(new Dilation(0.0F), 0.0F);
        ModelPartData root = modelData.getRoot();

        // Kopf
        root.addChild("head", ModelPartBuilder.create().uv(0, 0)
                        .cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        // Hut
        root.addChild("hat", ModelPartBuilder.create().uv(32, 0)
                        .cuboid(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F, new Dilation(0.5F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        // Körper
        root.addChild("body", ModelPartBuilder.create().uv(16, 16)
                        .cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        // Arme
        root.addChild("left_arm", ModelPartBuilder.create().uv(40, 16)
                        .cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(5.0F, 2.0F, 0.0F));

        root.addChild("right_arm", ModelPartBuilder.create().uv(40, 16)
                        .mirrored()
                        .cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(-5.0F, 2.0F, 0.0F));

        // Beine
        root.addChild("left_leg", ModelPartBuilder.create().uv(0, 16)
                        .cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(1.9F, 12.0F, 0.0F));

        root.addChild("right_leg", ModelPartBuilder.create().uv(0, 16)
                        .mirrored()
                        .cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)),
                ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        // Zusätzliche Teile (z. B. Jacke, Ärmel)
        root.getChild("body").addChild("jacket", ModelPartBuilder.create().uv(16, 32)
                        .cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)),
                ModelTransform.NONE);

        root.getChild("left_arm").addChild("left_sleeve", ModelPartBuilder.create().uv(48, 48)
                        .cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)),
                ModelTransform.NONE);

        root.getChild("right_arm").addChild("right_sleeve", ModelPartBuilder.create().uv(40, 32)
                        .cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)),
                ModelTransform.NONE);

        root.getChild("left_leg").addChild("left_pants", ModelPartBuilder.create().uv(0, 48)
                        .cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)),
                ModelTransform.NONE);

        root.getChild("right_leg").addChild("right_pants", ModelPartBuilder.create().uv(0, 32)
                        .cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)),
                ModelTransform.NONE);

        return TexturedModelData.of(modelData, 64, 64);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        head.render(matrices, vertices, light, overlay);
        body.render(matrices, vertices, light, overlay);
        leftArm.render(matrices, vertices, light, overlay);
        rightArm.render(matrices, vertices, light, overlay);
        leftLeg.render(matrices, vertices, light, overlay);
        rightLeg.render(matrices, vertices, light, overlay);
    }
}
