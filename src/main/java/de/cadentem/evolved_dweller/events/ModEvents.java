package de.cadentem.evolved_dweller.events;

import de.cadentem.evolved_dweller.CaveDweller;
import de.cadentem.evolved_dweller.client.CaveDwellerEyesLayer;
import de.cadentem.evolved_dweller.config.ClientConfig;
import de.cadentem.evolved_dweller.config.ServerConfig;
import de.cadentem.evolved_dweller.entities.CaveDwellerEntity;
import de.cadentem.evolved_dweller.registry.ModEntityTypes;
import de.cadentem.evolved_dweller.util.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = CaveDweller.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(final EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.CAVE_DWELLER.get(), CaveDwellerEntity.getAttributeBuilder());
    }

    @SubscribeEvent
    public static void reloadConfiguration(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == ClientConfig.SPEC) {
            ClientConfig.SPEC.acceptConfig(event.getConfig().getConfigData());
            CaveDwellerEyesLayer.TEXTURE = new ResourceLocation(CaveDweller.MODID, "textures/entity/cave_dweller_eyes_texture" + Utils.getTextureAppend() + ".png");
            CaveDweller.LOG.info("Client configuration has been reloaded");
        }

        if (event.getConfig().getSpec() == ServerConfig.SPEC) {
            ServerConfig.SPEC.acceptConfig(event.getConfig().getConfigData());
            CaveDweller.RELOAD_ALL = true;
            CaveDweller.LOG.info("Server configuration has been reloaded");
        }
    }
}
