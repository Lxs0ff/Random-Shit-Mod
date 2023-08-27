package com.lxs.randomshit.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class TntPropeller extends Item {
    public TntPropeller(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
            if (world.isRemote) {
                player.getCooldownTracker().setCooldown(this,50);
                Vector3d look = player.getLookVec();
                double speed = 3.0;
                player.addVelocity(look.x * speed, look.y * speed, look.z * speed);
                player.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE,0.3f,1f);
            }
        return super.onItemRightClick(world, player, hand);
    }
}
