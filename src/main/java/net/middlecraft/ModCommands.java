package net.middlecraft;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.middlecraft.hobbits.entity.HobbitEntities;
import net.middlecraft.hobbits.entity.SmallStoneProjectileEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.function.Supplier;

import static net.minecraft.server.command.CommandManager.literal;

public class ModCommands {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("spawnstone")
                    .executes(context -> {
                        ServerPlayerEntity player = context.getSource().getPlayer();
                        if (player != null) {
                            spawnSmallStoneProjectile(player);
                        }
                        return 1;
                    })
            );
        });
    }

    private static void spawnSmallStoneProjectile(ServerPlayerEntity player) {
        SmallStoneProjectileEntity projectile = new SmallStoneProjectileEntity(
                HobbitEntities.SMALL_STONE_PROJECTILE,
                player.getWorld()
        );

        // Setze die Position des Projektils auf die des Spielers
        projectile.setPosition(player.getX(), player.getEyeY(), player.getZ());

        // Setze die Richtung basierend auf der Blickrichtung des Spielers
        projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 1.5F, 1.0F);

        // Spawne das Projektil in der Welt
        player.getWorld().spawnEntity(projectile);
    }
}
