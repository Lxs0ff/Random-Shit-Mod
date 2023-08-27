package com.lxs.randomshit.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BulletItem extends ArrowItem {
    public BulletItem(Properties properties) {
        super(properties);
    }

    public AbstractArrowEntity createArrow(World world, ItemStack ammoStack, LivingEntity shooter) {
        //return new BulletItem(EntityInit.EXPLOSIVE_ARROW.get(), shooter, world);
    }
}
