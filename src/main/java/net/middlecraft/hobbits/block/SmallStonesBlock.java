package net.middlecraft.hobbits.block;

import net.middlecraft.hobbits.entity.SmallStoneProjectileEntity;
import net.middlecraft.hobbits.item.HobbitItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.List;

public class SmallStonesBlock extends Block {
    public static final IntProperty STONE_COUNT = IntProperty.of("stone_count", 1, 3);

    public SmallStonesBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STONE_COUNT); // Registriere die Property
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(STONE_COUNT, 1); // Standardwert: 1 Stein
    }

    @Override
    public void onBroken(WorldAccess worldAccess, BlockPos pos, BlockState state) {
        if (!worldAccess.isClient()) {
            World world = (World) worldAccess;
            int stoneCount = state.get(STONE_COUNT);
            for (int i = 0; i < stoneCount; i++) {
                dropStack(world, pos, new ItemStack(HobbitItems.SMALL_STONE_PROJECTILE));
            }
        }
        super.onBroken(worldAccess, pos, state);
    }


    public static void convertNearbyStones(World world, BlockPos center, int range) {
        // Suche nach allen SmallStoneProjectileEntities im Umkreis
        List<SmallStoneProjectileEntity> nearbyEntities = world.getEntitiesByClass(
                SmallStoneProjectileEntity.class,
                new Box(
                        new Vec3d(center.getX() - range, center.getY() - range, center.getZ() - range),
                        new Vec3d(center.getX() + range + 1, center.getY() + range + 1, center.getZ() + range + 1)
                ),
                entity -> true
        );

        // Verarbeite die Entities
        int processed = 0;
        for (SmallStoneProjectileEntity entity : nearbyEntities) {
            if (processed >= 3) break; // Maximal 3 Steine verarbeiten

            BlockPos pos = entity.getBlockPos();
            BlockState state = world.getBlockState(pos);

            if (state.isOf(HobbitBlocks.SMALL_STONES)) {
                int stoneCount = state.get(SmallStonesBlock.STONE_COUNT);
                if (stoneCount < 3) {
                    world.setBlockState(pos, state.with(SmallStonesBlock.STONE_COUNT, stoneCount + 1), Block.NOTIFY_ALL);
                } else {
                    continue; // Block ist voll
                }
            } else {
                // Erstelle neuen SmallStonesBlock
                world.setBlockState(pos, HobbitBlocks.SMALL_STONES.getDefaultState().with(SmallStonesBlock.STONE_COUNT, 1), Block.NOTIFY_ALL);
            }

            // Entferne die Entity
            entity.discard();
            processed++;
        }
    }



    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 1.0 / 16.0, 1.0);
    }
}

