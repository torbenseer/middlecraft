package net.middlecraft.hobbits.entity;

import net.middlecraft.Middlecraft;
import net.middlecraft.hobbits.block.SmallStonesBlock;
import net.middlecraft.hobbits.item.HobbitItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.middlecraft.hobbits.block.HobbitBlocks;
import net.minecraft.world.World;

public class SmallStoneProjectileEntity extends PersistentProjectileEntity {
    private static final float DAMAGE = 3.0F; // Schaden in Herzen (1 Herz = 2.0)

    public SmallStoneProjectileEntity(World world, LivingEntity shooter, ItemStack stack) {
        super(HobbitEntities.SMALL_STONE_PROJECTILE, shooter, world, stack, null);
        this.setSound(SoundEvents.BLOCK_STONE_HIT);
    }

    public SmallStoneProjectileEntity(World world, double x, double y, double z, ItemStack stack) {
        super(HobbitEntities.SMALL_STONE_PROJECTILE, x, y, z, world, stack, null);
        this.setSound(SoundEvents.BLOCK_STONE_HIT);
    }

    public SmallStoneProjectileEntity(EntityType<SmallStoneProjectileEntity> smallStoneProjectile, World world) {
        super(smallStoneProjectile, world);
        this.setSound(SoundEvents.BLOCK_STONE_HIT);
    }



    @Override
    public boolean shouldRender(double distance) {
        return true; // Keine Standard-Pfeilgrafik verwenden
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isInGround()) { // Überprüfen, ob das Projektil am Boden liegt
            this.inGroundTime++; // Zeit am Boden erhöhen

            if (this.inGroundTime >= 200) { // Nach 200 Ticks auslösen
                BlockPos hitPos = this.getBlockPos(); // Position des Projektils
                BlockState hitBlockState = this.getWorld().getBlockState(hitPos.down()); // Block unter dem Projektil prüfen

                if (isValidTargetBlock(hitBlockState)) { // Validen Block prüfen
                    Middlecraft.LOGGER.info("Valide Blöcke");
                    SmallStonesBlock.convertNearbyStones(this.getWorld(), hitPos.down(), 3); // Steine im Umkreis konvertieren
                }
                this.discard(); // Entferne das Projektil nach der Umwandlung
            }
        } else {
            this.inGroundTime = 0; // Zeit zurücksetzen, wenn das Projektil sich bewegt
        }
    }
    private boolean isValidTargetBlock(BlockState blockState) {
        // Prüfen, ob der Block solide ist (keine Luft, kein Flüssigkeitsblock, kein spezieller Block)
        return blockState.isSolidBlock(this.getWorld(), this.getBlockPos().down())
                && !blockState.isIn(BlockTags.LEAVES) // Schließt Blätter aus
                && !blockState.isIn(BlockTags.REPLACEABLE) // Schließt ersetzbare Pflanzen wie Gras aus
                && !blockState.isAir(); // Schließt Luft aus
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


