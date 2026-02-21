package de.cadentem.neo_cave_dweller.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TransformingTorch extends TorchBlock {
    Block target;
    public TransformingTorch(Properties pProperties, ParticleOptions pFlameParticle, Block target) {
        super(pProperties, pFlameParticle);
        this.target = target;
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);
        this.transform(pState, pLevel, pPos);
    }

    private void transform(BlockState state, ServerLevel level, BlockPos pos) {
        level.setBlock(pos, target.defaultBlockState(), 1 | 2);
        level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS);
    }
}
