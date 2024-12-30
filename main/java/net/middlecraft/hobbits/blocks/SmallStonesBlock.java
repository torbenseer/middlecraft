/*
package net.middlecraft.hobbits.blocks;

import net.middlecraft.hobbits.item.HobbitItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SmallStonesBlock extends Block {
    public SmallStonesBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient) {
            // Anzahl der Projectiles abhängig von der Variante
           // int projectiles = state.get(SmallStonesProperties.VARIANT) + 1; // Beispiel: Variante 0 gibt 1 Projektil, usw.
            for (int i = 0; i < 1; i++) {
                // Item in Spieler-Inventar legen
                player.giveItemStack(new ItemStack(HobbitItems.SMALL_STONE_PROJECTILE));
            }
            // Block entfernen, wenn gewünscht
            world.breakBlock(pos, false);
        }
        return state;
    }
}
*/
