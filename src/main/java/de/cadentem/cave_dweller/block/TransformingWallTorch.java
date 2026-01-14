package de.cadentem.cave_dweller.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class TransformingWallTorch extends WallTorchBlock {
    private final Block target;
    public TransformingWallTorch(Properties pProperties, ParticleOptions pFlameParticle, Block target) {
        super(pProperties, pFlameParticle);
        this.target = target;
    }

    @Override
    public void randomTick(@NotNull BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        super.randomTick(pState, pLevel, pPos, pRandom);
        this.transform(pState, pLevel, pPos);
    }

    private void transform(BlockState state, ServerLevel level, BlockPos pos) {
        BlockState newState = target.getStateDefinition().any().setValue(WallTorchBlock.FACING, state.getValue(WallTorchBlock.FACING));
        level.setBlock(pos, newState, 1 | 2);
        level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS);
    }
}
