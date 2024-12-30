package net.middlecraft.hobbits.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.middlecraft.MiddlecraftMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class HobbitBlocks {
    public static final Block SMALL_STONES_BLOCK = registerBlock("small_stones_block", new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(1f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MiddlecraftMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MiddlecraftMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        MiddlecraftMod.LOGGER.info("Registering Mod Blocks");
    }
}
