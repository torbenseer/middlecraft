package net.middlecraft.hobbits.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.middlecraft.Middlecraft;
import net.middlecraft.hobbits.entity.SmallStoneProjectileEntity;
import net.middlecraft.hobbits.entity.models.SmallStoneProjectileModel;
import net.middlecraft.hobbits.entity.registries.HobbitEntityModelRegistry;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SmallStoneProjectileRenderer extends ProjectileEntityRenderer<SmallStoneProjectileEntity, ProjectileEntityRenderState> {
    private static final Identifier TEXTURE = Identifier.of(Middlecraft.MOD_ID, "textures/entity/small_stone_projectile.png");
    private final SmallStoneProjectileModel model;

    public SmallStoneProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new SmallStoneProjectileModel(context.getPart(HobbitEntityModelRegistry.SMALL_STONE_PROJECTILE_LAYER));
    }

    @Override
    protected Identifier getTexture(ProjectileEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public ProjectileEntityRenderState createRenderState() {
        return new ProjectileEntityRenderState();
    }


    @Override
    public void render(ProjectileEntityRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        // Passe die Position und Skalierung an
        matrices.translate(0.0, 0.25, 0.0);
        matrices.scale(0.5F, 0.5F, 0.5F);

        // Rendere das Modell
        this.model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();

        super.render(state, matrices, vertexConsumers, light);
    }
}
