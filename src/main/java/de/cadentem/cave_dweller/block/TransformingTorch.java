package de.cadentem.cave_dweller.block;

import de.cadentem.cave_dweller.CaveDweller;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TransformingTorch extends TorchBlock {
    Block target;
    public TransformingTorch(Properties pProperties, ParticleOptions pFlameParticle, Block target) {
        super(pProperties, pFlameParticle);
        this.target = target;
    }

    @Override
    public void randomTick(@NotNull BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        super.randomTick(pState, pLevel, pPos, pRandom);
        CaveDweller.LOG.info("Randomly ticked");
        this.transform(pState, pLevel, pPos);
    }

    private void transform(BlockState state, ServerLevel level, BlockPos pos) {
        level.setBlock(pos, target.defaultBlockState(), 1 | 2);
    }
}
