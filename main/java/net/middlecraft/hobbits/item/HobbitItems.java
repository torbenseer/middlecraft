package net.middlecraft.hobbits.item;

import net.middlecraft.MiddlecraftMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HobbitItems {
    public static Item SMALL_STONE_PROJECTILE_ITEM;

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MiddlecraftMod.MOD_ID, name), item);
    }

    public static void registerItems() {
        MiddlecraftMod.LOGGER.info("Registering Hobbit Items");

        // Initialize and register items here
        MiddlecraftMod.LOGGER.info("Registering Hobbit Items");
        try {
            SMALL_STONE_PROJECTILE_ITEM = new Item(new Item.Settings().maxDamage(10).maxCount(8));
            Registry.register(Registries.ITEM, Identifier.of(MiddlecraftMod.MOD_ID, "stone_projectile_item"), SMALL_STONE_PROJECTILE_ITEM);
            MiddlecraftMod.LOGGER.info("Registered SMALL_STONE_PROJECTILE_ITEM successfully.");
        } catch (Exception e) {
            MiddlecraftMod.LOGGER.error("Error while registering Hobbit Items", e);
        }
    }
}
