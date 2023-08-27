package com.lxs.randomshit.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.util.math.RayTraceResult;

public class InventoryViewer extends Item {
    public InventoryViewer(Properties properties) {
        super(properties);
    }
    private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("Player Inventory");

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand) {
        if (!playerEntity.world.isRemote) {
            PlayerEntity clickPlayer = world.getClosestPlayer(playerEntity, 7);
            PlayerInventory playerInventory = clickPlayer.inventory;
            playerEntity.openContainer(new SimpleNamedContainerProvider((id, inventory, playerIn) -> {
                return ChestContainer.createGeneric9X3(id, inventory, playerInventory);
            }, CONTAINER_NAME));
            clickPlayer.playSound(SoundEvents.BLOCK_CHEST_OPEN, 1, 1);
            playerEntity.playSound(SoundEvents.BLOCK_CHEST_OPEN, 1, 1);
        }
        return super.onItemRightClick(world, playerEntity, hand);
    }
}
