package net.middlecraft.mixin.client;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.middlecraft.hobbit.model.HobbitMaleModel;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModels;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;

@Mixin(EntityModels.class)
@Environment(EnvType.CLIENT)
public abstract class EntityModelsMixin {

    private static final Map<EntityModelLayer, TexturedModelData> CUSTOM_MODELS = new HashMap<>();

    static {
        // Hobbit-Modell registrieren
        CUSTOM_MODELS.put(EntityModelLayers.PLAYER, HobbitMaleModel.getTexturedModel());
    }

    @Inject(method = "getModels", at = @At("HEAD"), cancellable = true)
    private static void injectCustomModels(CallbackInfoReturnable<Map<EntityModelLayer, TexturedModelData>> cir) {
        Map<EntityModelLayer, TexturedModelData> defaultModels = new HashMap<>(EntityModels.getModels());
        defaultModels.putAll(CUSTOM_MODELS); // Füge deine Modelle hinzu
        cir.setReturnValue(defaultModels); // Rückgabe mit neuen Modellen
    }
}
