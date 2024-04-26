package net.miky.creepercenamod.mixin;

import net.miky.creepercenamod.sound.ModSounds;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntity.class)
public abstract class CreeperMixin {


    @Redirect(method = "tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/CreeperEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"))
    public void tickOnPlaySound(CreeperEntity instance, SoundEvent soundEvent, float v, float p) {
        if (instance.shouldRenderOverlay()) {
            instance.playSound(ModSounds.CREEPER_CENA_FUSE, 4.0f, 1.0f);
        }
        else {
            instance.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
        }
    }

    @Inject(method = "explode()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/world/World$ExplosionSourceType;)Lnet/minecraft/world/explosion/Explosion;"))
    public void tickOnPlaySound(CallbackInfo ci) {
        CreeperEntity creeper = ( CreeperEntity ) ( Object ) this;
        if (creeper.shouldRenderOverlay()) {
            creeper.playSound(ModSounds.CREEPER_CENA_EXPLODE, 4.0f, 1.0f);
        }
        else {
            creeper.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0f, 0.5f);
        }
    }
}