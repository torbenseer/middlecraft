package net.middlecraft.hobbits.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.middlecraft.Middlecraft;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.base.Function;

public class HobbitBlocks {
    public static final Block SMALL_STONES = register("small_stones_block", SmallStonesBlock::new, Block.Settings.create().nonOpaque().sounds(BlockSoundGroup.STONE).strength(1.0f), false);

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings, boolean registerBlockItem) {
        final Identifier identifier = Identifier.of(Middlecraft.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        if(registerBlockItem) Items.register(block);
        return block;
    }

    private static void addBuildingBlocks(FabricItemGroupEntries entries) {
       
    }

    public static void registerModBlocks() {
        Middlecraft.LOGGER.info("Registering Mod Blocks for " + Middlecraft.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(HobbitBlocks::addBuildingBlocks);
    }
}
