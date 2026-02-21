package de.cadentem.neo_cave_dweller.datagen;

import de.cadentem.neo_cave_dweller.CaveDweller;
import de.cadentem.neo_cave_dweller.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockModelProvider extends BlockStateProvider {

    public BlockModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CaveDweller.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile blownTorch = models()
                .withExistingParent("blown_torch", this.mcLoc("block/template_torch"))
                .texture("torch", this.modLoc("block/blown_torch"))
                .renderType(this.mcLoc("cutout"));
        getVariantBuilder(ModBlocks.BLOWN_TORCH.get())
                .partialState().setModels(new ConfiguredModel(blownTorch));
        ModelFile cinderTorch = models()
                .withExistingParent("cinder_torch", this.mcLoc("block/template_torch"))
                .texture("torch", this.modLoc("block/cinder_torch"))
                .renderType(this.mcLoc("cutout"));
        getVariantBuilder(ModBlocks.CINDERING_TORCH.get())
                .partialState().setModels(new ConfiguredModel(cinderTorch));
    }
}
