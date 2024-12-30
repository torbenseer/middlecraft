package net.middlecraft;

import net.fabricmc.api.ModInitializer;

import net.middlecraft.hobbits.entity.HobbitEntities;
import net.middlecraft.hobbits.item.HobbitItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Middlecraft implements ModInitializer {
	public static final String MOD_ID = "middlecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		HobbitEntities.registerEntities();
		HobbitItems.registerModItems();
		ModCommands.registerCommands();

		LOGGER.info("Hello Fabric world!");
	}
}