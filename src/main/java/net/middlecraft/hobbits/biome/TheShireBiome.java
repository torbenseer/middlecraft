package net.middlecraft.hobbits.biome;/*
package net.middlecraft.hobbits.biome;


import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.middlecraft.hobbits.biome.vegetation.ShireTreeFeature;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.GenerationSettings;

public class TheShireBiome {

    public static Biome createShireBiome() {
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();

        // Vegetation: Hobbit Trees, Flowers
        ShireTreeFeature.addFeatures(generationSettings);

        // Structures: Hobbit Village and Pathways
        PathwayFeature.addPathways(generationSettings);
        HobbitVillageStructure.addVillageStructures(generationSettings);

        BiomeEffects effects = new BiomeEffects.Builder()
                .skyColor(0x7fc5e6) // Angenehmes Blau für den Himmel
                .fogColor(0x90b9a5) // Weicher Nebel
                .waterColor(0x3f76e4)
                .waterFogColor(0x50533)
                .grassColorModifier(BiomeEffects.GrassColorModifier.NONE)
                .music(new MusicSound(SoundEvents.MUSIC_OVERWORLD_SHIRE, 6000, 24000, true))
                .moodSound(BiomeMoodSound.CAVE)
                .build();

        return new Biome.Builder()
                .precipitation(true)
                .temperature(0.7F)
                .downfall(0.8F)
                .effects(effects)
                .generationSettings(generationSettings)
                .category(Biome.Category.PLAINS)
                .build();
    }

    public static void register() {
        RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, Identifier.of("middlecraft", "the_shire"));
        Registry.register(BuiltinRegistries.BIOME, key.getValue(), createShireBiome());

        BiomeModifications.addProperties(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), modifications -> {
            modifications.replace(key.getValue());
        });
    }
}
*/