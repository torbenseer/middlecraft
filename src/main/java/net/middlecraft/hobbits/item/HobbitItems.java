package net.middlecraft.hobbits.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.middlecraft.Middlecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.base.Function;

public class HobbitItems {
    public static final Item SMALL_STONE_PROJECTILE = registerItem("small_stone_projectile", SmallStoneProjectileItem::new, new Item.Settings().maxCount(8));

    public static Item registerItem(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Middlecraft.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }
    private static void addCombatItems(FabricItemGroupEntries entries) {
        entries.add(SMALL_STONE_PROJECTILE);
    }

    public static void registerModItems() {
        Middlecraft.LOGGER.info("Registering Mod Items for " + Middlecraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(HobbitItems::addCombatItems);
    }
}

