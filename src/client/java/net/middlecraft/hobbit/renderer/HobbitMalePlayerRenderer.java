package net.middlecraft.hobbit.renderer;

import net.middlecraft.MiddlecraftMod;
import net.middlecraft.MiddlecraftModClient;
import net.middlecraft.hobbit.model.HobbitMaleModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class HobbitMaleRenderer extends LivingEntityRenderer<PlayerEntity, PlayerEntityRenderState, HobbitMaleModel> {
    public HobbitMaleRenderer(EntityRendererFactory.Context context) {
        super(context, new HobbitMaleModel(context.getPart(MiddlecraftModClient.HOBBIT_LAYER)), 0.8f); // 0.5f ist der Schattenradius
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