package net.middlecraft.hobbits.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.middlecraft.MiddlecraftMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HobbitItemGroups {
    public static final ItemGroup HOBBIT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MiddlecraftMod.MOD_ID,"hobbit"),
            FabricItemGroup.builder().displayName(Text.of("itemgroup.hobbit"))
                    .icon(() -> new ItemStack(HobbitItems.SMALL_STONE_PROJECTILE_ITEM)).entries(((displayContext, entries) -> {
                        entries.add(HobbitItems.SMALL_STONE_PROJECTILE_ITEM);
                    })).build());

    public static void registerItemGroup() {
        MiddlecraftMod.LOGGER.info("Registering Hobbit ItemGroups");
    }
}
