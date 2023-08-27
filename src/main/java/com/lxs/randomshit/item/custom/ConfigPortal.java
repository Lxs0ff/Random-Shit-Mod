package com.lxs.randomshit.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class ConfigPortal extends Item {

    public ConfigPortal(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        if (!context.getPlayer().world.isRemote) {
            World world = context.getWorld();
            PlayerEntity player = context.getPlayer();
            BlockState block = world.getBlockState(context.getPos());
            if (world.isRemote) {
                if (player.isCrouching()) {
                    shiftRightClickItem(stack, context, player, world);
                } else {
                    rightClickItem(player, stack, world);
                }
            }
        }
        return super.onItemUseFirst(stack, context);
    }

    private void shiftRightClickItem(ItemStack stack,ItemUseContext context,PlayerEntity player,World world) {
        player.getCooldownTracker().setCooldown(this,20);
        CompoundNBT tags = stack.getOrCreateTag();
        Vector3d result = context.getHitVec();
        tags.putDouble("x",result.x);
        tags.putDouble("y",result.y);
        tags.putDouble("z",result.z);
        world.playSound(player, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), SoundEvents.ENTITY_ENDER_DRAGON_FLAP, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }

    private void rightClickItem(PlayerEntity player,ItemStack stack,World world) {
        player.getCooldownTracker().setCooldown(this,40);
        CompoundNBT tags = stack.getOrCreateTag();
        double xPos = tags.getDouble("x");
        double yPos = tags.getDouble("y");
        double zPos = tags.getDouble("z");
        player.setPosition(xPos,yPos,zPos);
        world.playSound(player, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
    }
}
