package net.middlecraft.hobbit.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;

public class HobbitMaleModel extends EntityModel<LivingEntityRenderState> {
    private final ModelPart hat;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart legs;
    private final ModelPart foot_right;
    private final ModelPart foot_left;
    public HobbitMaleModel(ModelPart root) {
        super(root);
        this.hat = root.getChild("hat");
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.legs = root.getChild("legs");
        this.foot_right = root.getChild("foot_right");
        this.foot_left = root.getChild("foot_left");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create().uv(60, 94).cuboid(-9.0F, -18.0F, -10.0F, 18.0F, 18.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 1.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -16.0F, -9.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 1.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 32).cuboid(-8.0F, -20.0F, -9.0F, 16.0F, 20.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 5.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(0, 60).cuboid(-16.0F, -20.0F, -9.0F, 8.0F, 20.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 5.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(48, 32).cuboid(8.0F, -20.0F, -9.0F, 8.0F, 20.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.0F, 5.0F));

        ModelPartData legs = modelPartData.addChild("legs", ModelPartBuilder.create().uv(32, 60).cuboid(-12.0F, -10.0F, -4.0F, 8.0F, 20.0F, 8.0F, new Dilation(0.0F))
                .uv(64, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 20.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 12.0F, 0.0F));

        ModelPartData foot_right = modelPartData.addChild("foot_right", ModelPartBuilder.create().uv(80, 38).cuboid(-4.5F, -0.25F, -9.75F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(80, 48).cuboid(-0.5F, -0.25F, -9.75F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(64, 60).cuboid(-4.5F, -0.25F, -6.75F, 8.0F, 2.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(4.5F, 22.25F, -2.25F));

        ModelPartData ball_right_top_r1 = foot_right.addChild("ball_right_top_r1", ModelPartBuilder.create().uv(80, 28).cuboid(0.0F, -1.0F, -9.0F, 8.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -2.25F, 4.25F, 0.3054F, 0.0F, 0.0F));

        ModelPartData toe_right_4_r1 = foot_right.addChild("toe_right_4_r1", ModelPartBuilder.create().uv(80, 53).cuboid(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, 0.75F, -8.25F, -0.0436F, 0.0F, 0.0F));

        ModelPartData toe_right_2_r1 = foot_right.addChild("toe_right_2_r1", ModelPartBuilder.create().uv(80, 43).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, 1.75F, -8.75F, 0.0436F, -0.0436F, 0.0F));

        ModelPartData foot_left = modelPartData.addChild("foot_left", ModelPartBuilder.create().uv(64, 75).cuboid(-4.5F, -0.25F, -6.75F, 8.0F, 2.0F, 13.0F, new Dilation(0.0F))
                .uv(20, 88).cuboid(-0.5F, -0.25F, -9.75F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 88).cuboid(-4.5F, -0.25F, -9.75F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.5F, 22.25F, -2.25F));

        ModelPartData toe_left_3_r1 = foot_left.addChild("toe_left_3_r1", ModelPartBuilder.create().uv(10, 88).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.5F, 1.75F, -8.75F, 0.0436F, -0.0436F, 0.0F));

        ModelPartData toe_left_1_r1 = foot_left.addChild("toe_left_1_r1", ModelPartBuilder.create().uv(30, 88).cuboid(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, 0.75F, -8.25F, -0.0436F, 0.0F, 0.0F));

        ModelPartData ball_right_bottom_r1 = foot_left.addChild("ball_right_bottom_r1", ModelPartBuilder.create().uv(80, 33).cuboid(0.0F, -1.0F, -9.0F, 8.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -2.25F, 4.25F, 0.3054F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        hat.render(matrices, vertexConsumer, light, overlay);
        head.render(matrices, vertexConsumer, light, overlay);
        body.render(matrices, vertexConsumer, light, overlay);
        left_arm.render(matrices, vertexConsumer, light, overlay);
        right_arm.render(matrices, vertexConsumer, light, overlay);
        legs.render(matrices, vertexConsumer, light, overlay);
        foot_right.render(matrices, vertexConsumer, light, overlay);
        foot_left.render(matrices, vertexConsumer, light, overlay);
    }
}