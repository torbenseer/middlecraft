package net.middlecraft;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.middlecraft.hobbits.entity.HobbitMaleEntity;
import net.middlecraft.hobbits.entity.HobbitEntities;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class MiddlecraftWorld {

    public static void spawnHobbitNpc(ServerWorld world) {
        BlockPos spawnPos = world.getSpawnPos(); // Hol dir die Spawn-Position der Welt
        HobbitMaleEntity hobbit = new HobbitMaleEntity(HobbitEntities.HOBBIT_MALE_ENTITY, world);
        hobbit.refreshPositionAndAngles(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0.0F, 0.0F);
        world.spawnEntity(hobbit);
        MiddlecraftMod.LOGGER.info("Spawned Hobbit Male Entity");
    }

    public static void registerWorldEvents() {
        ServerWorldEvents.LOAD.register((server, world) -> {
            spawnHobbitNpc(world);
        });
    }
}