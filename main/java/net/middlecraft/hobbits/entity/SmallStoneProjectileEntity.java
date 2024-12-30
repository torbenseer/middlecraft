package net.middlecraft.hobbits.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class SmallStoneProjectileEntity extends ThrownItemEntity {
    public SmallStoneProjectileEntity(World world, PlayerEntity user) {
        super(EntityType.SNOWBALL, world);
    }

    public void setProperties(PlayerEntity user, float pitch, float yaw, float v, float v1, float v2) {

    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }
}
