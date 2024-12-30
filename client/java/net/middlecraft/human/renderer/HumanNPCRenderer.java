package net.middlecraft.human.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.util.Identifier;
import net.middlecraft.hobbits.entity.PlayerNPCEntity;

public class HumanNPCRenderer extends LivingEntityRenderer<PlayerNPCEntity, PlayerEntityRenderState, PlayerEntityModel> {
    public HumanNPCRenderer(EntityRendererFactory.Context context) {
        super(context, new PlayerEntityModel(context.getPart(EntityModelLayers.PLAYER),false), 0.5f);
    }

    @Override
    public PlayerEntityRenderState createRenderState() {
        return null;
    }

    @Override
    public Identifier getTexture(PlayerEntityRenderState state) {
        return null;
    }
}