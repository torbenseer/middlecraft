package net.middlecraft;

import net.fabricmc.api.ClientModInitializer;
import net.middlecraft.hobbits.entity.HobbitEntities;
import net.middlecraft.hobbits.entity.registries.HobbitEntityModelRegistry;

public class MiddlecraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HobbitEntityModelRegistry.registerModelLayers();
        HobbitEntityModelRegistry.registerRenderer();
    }
}
