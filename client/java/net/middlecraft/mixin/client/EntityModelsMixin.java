package net.middlecraft.mixin.client;

import net.middlecraft.MiddlecraftMod;
import net.middlecraft.hobbit.model.HobbitMaleModel;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModels;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(EntityModels.class)
public class EntityModelsMixin {

    @Inject(method = "getModels", at = @At("RETURN"), cancellable = true)
    private static void replacePlayerModel(CallbackInfoReturnable<Map<EntityModelLayer, TexturedModelData>> cir) {

        Map<EntityModelLayer, TexturedModelData> originalModels = cir.getReturnValue();

        Map<EntityModelLayer, TexturedModelData> modifiedModels = new HashMap<>(originalModels);
        modifiedModels.put(EntityModelLayers.PLAYER, HobbitMaleModel.getTexturedModelData());
        cir.setReturnValue(modifiedModels);
    }
}
