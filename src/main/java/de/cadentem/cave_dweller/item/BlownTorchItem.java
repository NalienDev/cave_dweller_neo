package de.cadentem.cave_dweller.item;

import de.cadentem.cave_dweller.CaveDweller;
import de.cadentem.cave_dweller.config.ServerConfig;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BlownTorchItem extends Item {

    public BlownTorchItem(Properties pProperties) {
        super(pProperties);

    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        CompoundTag nbt = pStack.getTag();

        if (nbt == null || nbt.get("ticks") == null) {
            CompoundTag newNbt = new CompoundTag();
            newNbt.putInt("ticks", ServerConfig.TORCH_RELIGHT_MIN.get());
            CaveDweller.LOG.debug("Created ticks tag");
            pStack.setTag(newNbt);
        } else {
            if (pEntity instanceof ServerPlayer player) {
                nbt.putInt("ticks", nbt.getInt("ticks") - 1);
                CaveDweller.LOG.debug("Ticks: {}", nbt.getInt("ticks"));

                if (nbt.getInt("ticks") <= 0) {
                    CaveDweller.LOG.debug("Recovering torch");
                    player.getInventory().setItem(pSlotId, new ItemStack(Items.TORCH, pStack.getCount()));
                }

            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
