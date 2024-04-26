package net.miky.creepercenamod.sound;

import net.miky.creepercenamod.CreeperCenaMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent CREEPER_CENA_FUSE = registerSoundEvent("creeper_cena_fuse");
    public static SoundEvent CREEPER_CENA_EXPLODE = registerSoundEvent("creeper_cena_explosion");

    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(CreeperCenaMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));

    }

    public static void registerSounds() {
    }
}
