package net.middlecraft.hobbits.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.middlecraft.MiddlecraftMod;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class HobbitEntities {

    private static final Identifier HOBBIT_MALE_ENTITY_ID = Identifier.of(MiddlecraftMod.MOD_ID, "hobbit_male");
    private static final Identifier STONE_PROJECTILE_ENTITY_ID = Identifier.of(MiddlecraftMod.MOD_ID, "stone_projectile");

    private static final RegistryKey<EntityType<?>> HOBBIT_MALE_ENTITY_KEY = RegistryKey.of(Registries.ENTITY_TYPE.getKey(), HOBBIT_MALE_ENTITY_ID);
    private static final RegistryKey<EntityType<?>> STONE_PROJECTILE_ENTITY_LEY = RegistryKey.of(Registries.ENTITY_TYPE.getKey(), STONE_PROJECTILE_ENTITY_ID);

    public static final EntityType<SmallStoneProjectileEntity> SMALL_STONE_PROJECTILE_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            STONE_PROJECTILE_ENTITY_ID,
            EntityType.Builder.<SmallStoneProjectileEntity>create(SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f) // Größe des Projektils
                    .build(STONE_PROJECTILE_ENTITY_LEY)
    );

    public static final EntityType<HobbitMaleEntity> HOBBIT_MALE_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            HOBBIT_MALE_ENTITY_ID,
            EntityType.Builder.create(HobbitMaleEntity::new,SpawnGroup.CREATURE)
                    .dimensions(0.6F, 0.8F) // Hobbit-Größe
                    .build(HOBBIT_MALE_ENTITY_KEY)
    );

    public static void registerEntities() {
        MiddlecraftMod.LOGGER.info("Registering Hobbit Entities");
        FabricDefaultAttributeRegistry.register(HobbitEntities.HOBBIT_MALE_ENTITY, HobbitMaleEntity.createHobbitAttributes());
    }
}
