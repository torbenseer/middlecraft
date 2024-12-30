package net.middlecraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.middlecraft.hobbit.model.HobbitMaleModel;
import net.middlecraft.hobbit.renderer.HobbitMaleRenderer;
import net.middlecraft.hobbits.entity.HobbitEntities;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class MiddlecraftModClient implements ClientModInitializer {
	public static final EntityModelLayer HOBBIT_MALE_LAYER = new EntityModelLayer(Identifier.of(MiddlecraftMod.MOD_ID, "hobbit_male"), "main");

	@Override
	public void onInitializeClient() {
		// Registriere Renderer für den Spieler
		EntityModelLayerRegistry.registerModelLayer(HOBBIT_MALE_LAYER, HobbitMaleModel::getTexturedModelData);
		EntityRendererRegistry.register(HobbitEntities.HOBBIT_MALE_ENTITY, HobbitMaleRenderer::new);
		//EntityRendererRegistry.register(EntityType.PLAYER, HobbitMalePlayerRenderer::new);

	}
}