// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.middlecraft.hobbits.entity.models;

import net.middlecraft.hobbits.entity.SmallStoneProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class SmallStoneProjectileModel extends EntityModel<EntityRenderState> {
	private final ModelPart bb_main;
	public SmallStoneProjectileModel(ModelPart root) {
        super(root);
        this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 11).cuboid(1.0F, -4.0F, -2.0F, 1.0F, 4.0F, 7.0F, new Dilation(0.0F))
				.uv(12, 23).cuboid(-2.0F, -4.0F, 4.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.0F, -4.0F, -3.0F, 4.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube7_r1 = bb_main.addChild("cube7_r1", ModelPartBuilder.create().uv(20, 23).cuboid(2.6255F, 0.2088F, -2.3814F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.2088F, 1.3849F, 0.0F, 0.5236F, 0.0F));

		ModelPartData cube3_r1 = bb_main.addChild("cube3_r1", ModelPartBuilder.create().uv(16, 17).cuboid(-1.424F, -1.7912F, -2.4555F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.2088F, 1.3849F, 0.0F, -0.1309F, 0.0F));

		ModelPartData cube6_r1 = bb_main.addChild("cube6_r1", ModelPartBuilder.create().uv(22, 7).cuboid(-1.4647F, 0.2088F, 2.147F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.2088F, 1.3849F, 0.0F, -0.1745F, 0.0F));

		ModelPartData cube5_r1 = bb_main.addChild("cube5_r1", ModelPartBuilder.create().uv(22, 0).cuboid(2.5F, 0.3922F, -1.8176F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.2088F, 1.3849F, 0.1309F, 0.0F, 0.0F));

		ModelPartData cube4_r1 = bb_main.addChild("cube4_r1", ModelPartBuilder.create().uv(0, 22).cuboid(-3.5F, 0.2302F, -3.1038F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.2088F, 1.3849F, -0.0873F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer,light, overlay);
	}
}