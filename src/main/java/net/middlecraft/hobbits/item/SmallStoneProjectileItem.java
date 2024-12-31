package net.middlecraft.hobbits.item;

import net.middlecraft.Middlecraft;
import net.middlecraft.hobbits.block.HobbitBlocks;
import net.middlecraft.hobbits.block.SmallStonesBlock;
import net.middlecraft.hobbits.entity.SmallStoneProjectileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SmallStoneProjectileItem extends Item implements ProjectileItem {


    public SmallStoneProjectileItem(Item.Settings settings) {
        super(settings);
    }

    public PersistentProjectileEntity createStoneProjectile(World world, ItemStack stack, PlayerEntity shooter, @Nullable ItemStack shotFrom) {
        return new SmallStoneProjectileEntity(world, shooter, stack.copyWithCount(1));
    }


    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        SmallStoneProjectileEntity projectile = new SmallStoneProjectileEntity(world, shooter, stack.copyWithCount(1));
        projectile.setDamage(3.0F); // Setze den Schaden
        projectile.setSound(SoundEvents.BLOCK_STONE_HIT);
        return projectile;
    }
    // Methode für andere Mechaniken wie Werfen
    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        SmallStoneProjectileEntity entity = new SmallStoneProjectileEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1));
        entity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return entity;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        // Prüfen, ob der Spieler auf einen Block zielt
        if (user.raycast(5.0, 0.0F, false).getType() == HitResult.Type.BLOCK) {
            // Wenn der Spieler auf einen Block zielt, keine Wurfaktion ausführen
            return ActionResult.PASS;
        }

        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            SmallStoneProjectileEntity projectile = (SmallStoneProjectileEntity) this.createStoneProjectile(world, itemStack, user, null);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.0F, 1.0F);
            world.spawnEntity(projectile);
            itemStack.decrementUnlessCreative(1, user);
        }
        return ActionResult.SUCCESS;
    }


    private boolean isValidBlockToPlaceOn(BlockState state) {
        if (state.isAir() || state.isReplaceable()) {
            return false;
        }

        if (state.isOf(HobbitBlocks.SMALL_STONES)) {
            return true;
        }

        return state.isSolidBlock(null, null);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState targetState = world.getBlockState(pos);
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();

        if (world.isClient || player == null) return ActionResult.PASS;

        // Prüfen, ob der Block valide ist
        if (!isValidBlockToPlaceOn(targetState)) return ActionResult.FAIL;

        // Position des Small Stones Block
        BlockPos placePos = targetState.isOf(HobbitBlocks.SMALL_STONES) ? pos : pos.up();

        // Maximaler Shift-Click
        boolean isShiftClick = player.isSneaking();
        int maxPlacement = isShiftClick ? Math.min(stack.getCount(), 3) : 1;

        BlockState currentState = world.getBlockState(placePos);

        Middlecraft.LOGGER.info(targetState.getBlock().toString());

        if (targetState.isOf(HobbitBlocks.SMALL_STONES)) {
            int currentStoneCount = targetState.get(SmallStonesBlock.STONE_COUNT);
            int newStoneCount = Math.min(currentStoneCount + maxPlacement, 3);
            Middlecraft.LOGGER.info("Click auf ein Small Stones Block");
            // Aktualisiere den Block, falls möglich
            if (newStoneCount != currentStoneCount) {
                Middlecraft.LOGGER.info("New stone count: {}", newStoneCount);
                world.setBlockState(placePos, currentState.with(SmallStonesBlock.STONE_COUNT, newStoneCount), Block.NOTIFY_ALL);
                stack.decrement(newStoneCount - currentStoneCount);
                return ActionResult.SUCCESS;
            }
        } else {
            // Neuer Block wird platziert
            world.setBlockState(placePos, HobbitBlocks.SMALL_STONES.getDefaultState().with(SmallStonesBlock.STONE_COUNT, maxPlacement), Block.NOTIFY_ALL);
            stack.decrement(maxPlacement);
            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL; // Rückgabe, wenn keine Aktion durchgeführt wurde
    }

}
