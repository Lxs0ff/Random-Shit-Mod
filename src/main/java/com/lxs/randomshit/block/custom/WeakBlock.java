package com.lxs.randomshit.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WeakBlock extends Block {
    public WeakBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityWalk(World world, BlockPos blockPos, Entity entity) {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        world.destroyBlock(blockPos,true);
                    }
                },
                2000
        );
        super.onEntityWalk(world, blockPos, entity);
    }
}