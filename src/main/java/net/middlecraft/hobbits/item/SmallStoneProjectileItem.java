package net.middlecraft.hobbits.item;

import net.middlecraft.hobbits.entity.SmallStoneProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SmallStoneProjectileItem extends ArrowItem {

    public SmallStoneProjectileItem(Item.Settings settings) {
        super(settings);
    }

    public PersistentProjectileEntity createStoneProjectile(World world, ItemStack stack, PlayerEntity shooter, @Nullable ItemStack shotFrom) {
        return new SmallStoneProjectileEntity(world, shooter, stack.copyWithCount(1));
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        SmallStoneProjectileEntity projectile = new SmallStoneProjectileEntity(world, shooter, stack.copyWithCount(1));
        projectile.setDamage(3.0F); // Setze den Schaden
        projectile.setSound(SoundEvents.ENTITY_ARROW_HIT);
        return projectile;
    }
    // Methode für andere Mechaniken wie Werfen
    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        SmallStoneProjectileEntity entity = new SmallStoneProjectileEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1));
        entity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return entity;
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            SmallStoneProjectileEntity projectile = (SmallStoneProjectileEntity) this.createStoneProjectile(world,itemStack,user, null);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(projectile);
            itemStack.decrementUnlessCreative(1, user);
        }
        return ActionResult.SUCCESS;
    }
}
