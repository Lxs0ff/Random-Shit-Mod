package com.lxs.randomshit.item.custom;

import com.lxs.randomshit.gui.DiscordItemGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class DiscordItem extends Item{
    public DiscordItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        if (!player.world.isRemote) {
            player.playSound(SoundEvents.ENTITY_EVOKER_PREPARE_WOLOLO, 1f, 7f);
            Minecraft mc = Minecraft.getInstance();
            mc.displayGuiScreen(new DiscordItemGUI());
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            mc.displayGuiScreen(null);
                            player.setHealth(0);
                        }
                    },
                    2000
            );
        }
        return super.onItemRightClick(world, player, hand);
    }
}
