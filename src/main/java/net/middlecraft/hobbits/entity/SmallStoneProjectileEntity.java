package net.middlecraft.hobbits.entity;

import net.middlecraft.hobbits.item.HobbitItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class SmallStoneProjectileEntity extends PersistentProjectileEntity {
    private static final float DAMAGE = 3.0F; // Schaden in Herzen (1 Herz = 2.0)

    public SmallStoneProjectileEntity(World world, LivingEntity shooter, ItemStack stack) {
        super(HobbitEntities.SMALL_STONE_PROJECTILE, shooter, world, stack, null);
    }

    public SmallStoneProjectileEntity(World world, double x, double y, double z, ItemStack stack) {
        super(HobbitEntities.SMALL_STONE_PROJECTILE, x, y, z, world, stack, null);
    }

    public SmallStoneProjectileEntity(EntityType<SmallStoneProjectileEntity> smallStoneProjectile, World world) {
        super(smallStoneProjectile, world);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if (!this.getWorld().isClient() && hitResult.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHitResult = (EntityHitResult) hitResult;

            if (entityHitResult.getEntity() instanceof LivingEntity target) {
                this.damage((ServerWorld) this.getWorld(), this.getDamageSources().thrown(this, this.getOwner()), DAMAGE);
            }
            this.discard(); // Entferne das Projektil nach einem Treffer
        }
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(HobbitItems.SMALL_STONE_PROJECTILE); // Verweis auf das registrierte Item
    }

    @Override
    protected double getGravity() {
        return 0.03; // Schwerkraft des Projektils
    }
}


