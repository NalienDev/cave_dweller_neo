 package de.cadentem.evolved_dweller.client;

 import de.cadentem.evolved_dweller.CaveDweller;
 import de.cadentem.evolved_dweller.entities.CaveDwellerEntity;
 import de.cadentem.evolved_dweller.util.Utils;
 import net.minecraft.resources.ResourceLocation;
 import software.bernie.geckolib.model.GeoModel;

 public class CaveDwellerModel extends GeoModel<CaveDwellerEntity> {
    @Override
    public ResourceLocation getModelResource(final CaveDwellerEntity ignored) {
        return new ResourceLocation(CaveDweller.MODID, "geo/cave_dweller.geo" + Utils.getTextureAppend() + ".json");
    }

    @Override
    public ResourceLocation getTextureResource(final CaveDwellerEntity ignored) {
        return new ResourceLocation(CaveDweller.MODID, "textures/entity/cave_dweller_texture" + Utils.getTextureAppend() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(final CaveDwellerEntity ignored) {
        return new ResourceLocation(CaveDweller.MODID, "animations/cave_dweller.animation.json");
    }
}