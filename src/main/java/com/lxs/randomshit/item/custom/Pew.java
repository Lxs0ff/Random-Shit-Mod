package com.lxs.randomshit.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Pew extends Item {
    public Pew(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand) {
        if (!playerEntity.world.isRemote) {
            //playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F

            //world.addEntity(bullet);
        }
        return super.onItemRightClick(world, playerEntity, hand);
    }
}
