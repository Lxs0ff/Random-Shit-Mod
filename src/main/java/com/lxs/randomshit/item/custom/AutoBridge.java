package com.lxs.randomshit.item.custom;

import com.lxs.randomshit.block.ModBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AutoBridge extends Item {
    public AutoBridge(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        if (!player.world.isRemote) {
            BlockPos pos = new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ());
            world.setBlockState(pos, ModBlocks.WEAK_BLOCK.get().getDefaultState());
        }
        return super.onItemRightClick(world, player, hand);
    }
}
