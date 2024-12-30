package net.middlecraft.hobbits.biome.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.Random;

public class SmallPondFeature extends Feature<DefaultFeatureConfig> {

    public SmallPondFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        WorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = (Random) context.getRandom();

        // Find a valid starting position for the pond
        BlockPos.Mutable mutable = origin.mutableCopy();
        while (world.isAir(mutable) && mutable.getY() > world.getBottomY() + 2) {
            mutable.move(Direction.DOWN);
        }

        // Generate the pond
        if (!world.getBlockState(mutable).isOf(Blocks.GRASS_BLOCK)) {
            return false;
        }

        int radius = 2 + random.nextInt(3); // Randomize pond size (radius 2-4)
        generatePond(world, mutable.down(), radius, random);

        return true;
    }

    private void generatePond(WorldAccess world, BlockPos center, int radius, Random random) {
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                BlockPos pos = center.add(dx, 0, dz);
                double distance = Math.sqrt(dx * dx + dz * dz);

                // Create the pond shape
                if (distance <= radius) {
                    world.setBlockState(pos, Blocks.WATER.getDefaultState(), 3);

                    // Add decorative elements
                    if (random.nextFloat() < 0.3f && distance <= radius - 1) {
                        if (world.isAir(pos.up())) {
                            world.setBlockState(pos.up(), Blocks.LILY_PAD.getDefaultState(), 3);
                        }
                    }
                }

                // Add grass or sugarcane around the edge
                if (distance > radius - 0.5 && distance <= radius + 0.5) {
                    BlockPos edgePos = pos.up();
                    if (world.isAir(edgePos)) {
                        if (random.nextFloat() < 0.5f) {
                            world.setBlockState(edgePos, Blocks.GRASS_BLOCK.getDefaultState(), 3);
                        } else if (random.nextFloat() < 0.1f) {
                            world.setBlockState(edgePos, Blocks.SUGAR_CANE.getDefaultState(), 3);
                        }
                    }
                }
            }
        }
    }
}
