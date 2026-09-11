package net.valiantenvoy.terriblelizards;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.valiantenvoy.terriblelizards.entity.client.NyctoRenderer;
import net.valiantenvoy.terriblelizards.entity.client.PteranodonRenderer;
import net.valiantenvoy.terriblelizards.entity.client.SinopteryxRenderer;
import net.valiantenvoy.terriblelizards.reg.TLEntities;
import net.valiantenvoy.terriblelizards.reg.TLItems;
import net.valiantenvoy.terriblelizards.sound.ModSounds;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import java.util.Locale;


@Mod(TerribleLizards.MOD_ID)
public class TerribleLizards {

    public static final String MOD_ID = "terriblelizards";
    public static final Logger LOGGER = LogUtils.getLogger();

        public TerribleLizards(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        TLItems.ITEMS.register(modEventBus);
        ModSounds.SOUND_EVENTS.register(modEventBus);
        TLEntities.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path.toLowerCase(Locale.ROOT));
    }

    private void commonSetup(FMLCommonSetupEvent event) {

        }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @OnlyIn(Dist.CLIENT)
    @EventBusSubscriber(modid = TerribleLizards.MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(TLEntities.NYCTOSAURUS.get(), NyctoRenderer::new);
            EntityRenderers.register(TLEntities.SINOPTERYX.get(), SinopteryxRenderer::new);
            EntityRenderers.register(TLEntities.PTERANODON.get(), PteranodonRenderer::new);
        }
    }
}
