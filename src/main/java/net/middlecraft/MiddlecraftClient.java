package net.middlecraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.middlecraft.hobbits.block.HobbitBlocks;
import net.middlecraft.hobbits.entity.registries.HobbitEntityModelRegistry;
import net.minecraft.client.render.RenderLayer;

public class MiddlecraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HobbitEntityModelRegistry.registerRenderer();
        HobbitEntityModelRegistry.registerModelLayers();

        BlockRenderLayerMap.INSTANCE.putBlock(HobbitBlocks.SMALL_STONES, RenderLayer.getCutout());
    }
}
