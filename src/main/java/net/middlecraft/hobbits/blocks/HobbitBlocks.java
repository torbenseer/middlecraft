package net.middlecraft.hobbits.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.middlecraft.MiddlecraftMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HobbitBlocks {
    public static final Block SMALL_STONES = new SmallStonesBlock(AbstractBlock.Settings.copy(Blocks.STONE).strength(0.5f).nonOpaque());

    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, Identifier.of(MiddlecraftMod.MOD_ID, "small_stones"), SMALL_STONES);
    }
}
