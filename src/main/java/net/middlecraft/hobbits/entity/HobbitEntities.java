package net.middlecraft;

import net.middlecraft.hobbits.entity.HobbitMaleEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModEntities {

    private static final Identifier HOBBIT_MALE_ENTITY_ID = Identifier.of(MiddlecraftMod.MOD_ID, "hobbit_male");
    private static final RegistryKey<EntityType<?>> HOBBIT_MALE_ENTITY_KEY = RegistryKey.of(Registries.ENTITY_TYPE.getKey(), HOBBIT_MALE_ENTITY_ID);

    public static final EntityType<HobbitMaleEntity> HOBBIT_MALE_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            HOBBIT_MALE_ENTITY_ID,
            EntityType.Builder.create(HobbitMaleEntity::new,SpawnGroup.CREATURE)
                    .dimensions(0.6F, 0.8F) // Hobbit-Größe
                    .build(HOBBIT_MALE_ENTITY_KEY)
    );
}
