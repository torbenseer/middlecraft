package net.middlecraft;

import net.fabricmc.api.ModInitializer;

import net.middlecraft.hobbits.biome.features.HobbitFeatures;
import net.middlecraft.hobbits.blocks.HobbitBlocks;
import net.middlecraft.hobbits.entity.HobbitEntities;
import net.middlecraft.hobbits.item.HobbitItemGroups;
import net.middlecraft.hobbits.item.HobbitItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiddlecraftMod implements ModInitializer {
	public static final String MOD_ID = "middlecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		HobbitItemGroups.registerItemGroup();
		HobbitItems.registerItems();

		MiddlecraftWorld.registerWorldEvents();
		HobbitEntities.registerEntities();
		HobbitFeatures.registerFeatures();

		//HobbitBlocks.registerBlocks();
	}
}