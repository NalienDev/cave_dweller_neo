package de.cadentem.cave_dweller.registry;

import de.cadentem.cave_dweller.CaveDweller;
import de.cadentem.cave_dweller.block.TransformingTorch;
import de.cadentem.cave_dweller.block.TransformingWallTorch;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, CaveDweller.MODID);

    private static BlockBehaviour.Properties torchProps(int light) {
        return BlockBehaviour.Properties.of()
                .noCollission()
                .instabreak()
                .lightLevel((p) -> light)
                .sound(SoundType.WOOD)
                .pushReaction(PushReaction.DESTROY)
                .lootFrom(() -> Blocks.TORCH);
    }

    public static final RegistryObject<Block> CINDERING_TORCH = BLOCKS.register(
            "cinder_torch", () -> new TransformingTorch(torchProps(6).randomTicks(), ParticleTypes.SMALL_FLAME, Blocks.TORCH)
    );
    public static final RegistryObject<Block> CINDERING_TORCH_WALL = BLOCKS.register(
            "cinder_torch_wall", () -> new TransformingWallTorch(torchProps(6).randomTicks(), ParticleTypes.SMALL_FLAME, Blocks.WALL_TORCH)
    );

    public static final RegistryObject<Block> BLOWN_TORCH = BLOCKS
            .register("blown_torch", () ->
                    new TransformingTorch(torchProps(0).randomTicks(), ParticleTypes.ASH, CINDERING_TORCH.get())
            );

    public static final RegistryObject<Block> BLOWN_TORCH_WALL = BLOCKS
            .register("blown_torch_wall", () ->
                    new TransformingWallTorch(torchProps(0).randomTicks(), ParticleTypes.ASH, CINDERING_TORCH_WALL.get())
            );

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
