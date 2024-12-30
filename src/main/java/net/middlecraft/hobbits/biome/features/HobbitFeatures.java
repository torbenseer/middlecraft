package net.middlecraft.hobbits.biome.features;

import net.middlecraft.Middlecraft;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class HobbitFeatures {
    public static final Feature<DefaultFeatureConfig> SMALL_POND = new SmallPondFeature(DefaultFeatureConfig.CODEC);

    public static void registerFeatures() {
        Middlecraft.LOGGER.info("Registering Hobbit Features");
        Registry.register(Registries.FEATURE, Identifier.of(Middlecraft.MOD_ID, "small_pond"), SMALL_POND);

    }
}
