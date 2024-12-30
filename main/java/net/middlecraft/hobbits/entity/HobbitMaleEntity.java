package net.middlecraft.hobbits.entity;

import net.middlecraft.MiddlecraftMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

public class HobbitMaleEntity extends PathAwareEntity {


    public HobbitMaleEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);    // Initialisiere Ausrüstung oder Slots, falls nötig
    }

    public static DefaultAttributeContainer.Builder createHobbitAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 15.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.ARMOR, 2.0);
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    public void tick() {
        super.tick(); // Rufe die Basismethode auf
        if (!this.getWorld().isClient) {
        }
    }

    @Override
    public void baseTick() {
        if (this.getMainHandStack() == null) {
            this.equipStack(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
        }
        super.baseTick();
    }
    @Override
    public Arm getMainArm() {
        return null;
    }
}
