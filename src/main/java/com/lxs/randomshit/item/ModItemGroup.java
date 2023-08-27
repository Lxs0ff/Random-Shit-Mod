package com.lxs.randomshit.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup RANDOM_GROUP = new ItemGroup("randomShitTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.WHYNOT.get());
        }
    };
}
