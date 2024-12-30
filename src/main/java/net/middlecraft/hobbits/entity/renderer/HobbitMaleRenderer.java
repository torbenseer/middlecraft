package net.middlecraft.hobbits.entity.renderer;

import net.middlecraft.Middlecraft;
import net.middlecraft.MiddlecraftClient;
import net.middlecraft.hobbits.entity.HobbitMaleEntity;
import net.middlecraft.hobbits.entity.models.HobbitMaleModel;
import net.middlecraft.hobbits.entity.registries.HobbitEntityModelRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HobbitMaleRenderer extends MobEntityRenderer<HobbitMaleEntity, LivingEntityRenderState, HobbitMaleModel> {
    public HobbitMaleRenderer(EntityRendererFactory.Context context) {
        super(context, new HobbitMaleModel(context.getPart(HobbitEntityModelRegistry.HOBBIT_MALE_LAYER)), 0.5f); // 0.5f ist der Schattenradius
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return Identifier.of(Middlecraft.MOD_ID, "textures/entity/hobbit_male.png");
    }

    @Override
    public void render(LivingEntityRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        // Begin Transformation
        matrices.push();

        float scale = 0.4F; // Passe diesen Wert an, falls nötig
        matrices.scale(scale, scale, scale);

        super.render(state, matrices, vertexConsumers, light);
        // Beende Transformation
        matrices.pop();
    }

}