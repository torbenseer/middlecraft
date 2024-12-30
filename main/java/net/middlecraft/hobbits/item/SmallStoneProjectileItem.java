package net.middlecraft.hobbits.item;

import net.middlecraft.hobbits.entity.SmallStoneProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SmallStoneProjectileItem extends Item {
    public SmallStoneProjectileItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            // Projektil-Logik (werfen, Schaden verursachen)
            SmallStoneProjectileEntity stone = new SmallStoneProjectileEntity(world, user);
            stone.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(stone);
            user.getStackInHand(hand).decrement(1);
        }
        return ActionResult.SUCCESS;
    }
}
