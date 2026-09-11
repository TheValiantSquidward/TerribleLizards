package net.valiantenvoy.terriblelizards.sound;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.valiantenvoy.terriblelizards.TerribleLizards;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TerribleLizards.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> NYCTO_CLACK = registerSoundEvent("nycto_clack");
    public static final DeferredHolder<SoundEvent, SoundEvent> NYCTO_HISS = registerSoundEvent("nycto_hiss");


    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(final String soundName) {
        return SOUND_EVENTS.register(soundName, () -> SoundEvent.createVariableRangeEvent(TerribleLizards.location(soundName)));
    }
}