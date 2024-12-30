package net.middlecraft.hobbit.renderer;

import net.middlecraft.MiddlecraftMod;
import net.middlecraft.MiddlecraftModClient;
import net.middlecraft.hobbits.entity.HobbitMaleEntity;
import net.middlecraft.hobbit.model.HobbitMaleModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.util.Identifier;

public class HobbitMalePlayerRenderer extends MobEntityRenderer<HobbitMaleEntity, PlayerEntityRenderState, HobbitMaleModel> {
    public HobbitMalePlayerRenderer(EntityRendererFactory.Context context) {
        super(context, new HobbitMaleModel(context.getPart(MiddlecraftModClient.HOBBIT_MALE_LAYER)), 0.8f); // 0.5f ist der Schattenradius
    }

    @Override
    public PlayerEntityRenderState createRenderState() {
        return null;
    }

    @Override
    public Identifier getTexture(PlayerEntityRenderState state) {
        return Identifier.of(MiddlecraftMod.MOD_ID, "textures/entity/hobbit_male.png");
    }
}