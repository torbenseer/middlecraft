package net.middlecraft.hobbits.entity.registries;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.middlecraft.Middlecraft;
import net.middlecraft.hobbits.entity.HobbitEntities;
import net.middlecraft.hobbits.entity.models.HobbitMaleModel;
import net.middlecraft.hobbits.entity.models.SmallStoneProjectileModel;
import net.middlecraft.hobbits.entity.renderer.HobbitMaleRenderer;
import net.middlecraft.hobbits.entity.renderer.SmallStoneProjectileRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class HobbitEntityModelRegistry {
    public static final EntityModelLayer HOBBIT_MALE_LAYER = createModelLayer("hobbit_male");
    public static final EntityModelLayer SMALL_STONE_PROJECTILE_LAYER = createModelLayer("small_stone_projectile");


    private static EntityModelLayer createModelLayer(String name) {
        return new EntityModelLayer(Identifier.of(Middlecraft.MOD_ID, name), "main");
    }

    public static void registerModelLayers() {
        Middlecraft.LOGGER.info("Registering HobbitModelLayers");
        EntityModelLayerRegistry.registerModelLayer(HOBBIT_MALE_LAYER, HobbitMaleModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SMALL_STONE_PROJECTILE_LAYER, SmallStoneProjectileModel::getTexturedModelData);
    }

    public static void registerRenderer(){
        Middlecraft.LOGGER.info("Registering HobbitEntityRenderer");
        EntityRendererRegistry.register(HobbitEntities.HOBBIT_MALE, HobbitMaleRenderer::new);
        EntityRendererRegistry.register(HobbitEntities.SMALL_STONE_PROJECTILE, SmallStoneProjectileRenderer::new);
    }
}