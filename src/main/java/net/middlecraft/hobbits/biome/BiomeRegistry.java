package net.middlecraft.hobbits.biome;

import net.middlecraft.Middlecraft;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;


public class BiomeRegistry {
    // Registriere den Schlüssel für das Shire-Biome
    public static final Identifier SHIRE_BIOME_ID = Identifier.of(Middlecraft.MOD_ID, "shire_biome");
    public static final RegistryKey<Biome> SHIRE_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, SHIRE_BIOME_ID);
    public static void registerBiomes() {
    }
}
