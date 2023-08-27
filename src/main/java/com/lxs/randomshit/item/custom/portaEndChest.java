package com.lxs.randomshit.item.custom;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class portaEndChest extends Item {
    private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.enderchest");
    public portaEndChest(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        if (!player.world.isRemote) {
            EnderChestInventory enderchestinventory = player.getInventoryEnderChest();
            player.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1, 1);
            player.openContainer(new SimpleNamedContainerProvider((id, inventory, playerIn) -> {
                return ChestContainer.createGeneric9X3(id, inventory, enderchestinventory);
            }, CONTAINER_NAME));
        }
        return super.onItemRightClick(world, player, hand);

    }
}
