package com.lxs.randomshit.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class Pew extends Item {
    public Pew(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand) {
        if (!playerEntity.world.isRemote) {
            playerEntity.setHealth(1f);
            playerEntity.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE,0.5f,1f);
            playerEntity.sendMessage(ITextComponent.getTextComponentOrEmpty("Not a good idea to point a gun at yourself dude"),playerEntity.getUniqueID());
        }
        return super.onItemRightClick(world, playerEntity, hand);
    }
}
