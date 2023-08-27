package com.lxs.randomshit.item;

import com.lxs.randomshit.RandomShit;
import com.lxs.randomshit.item.custom.*;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RandomShit.MOD_ID);
    public static final RegistryObject<Item> WHYNOT = ITEMS.register("whynot",
            () -> new Item(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> DONUT = ITEMS.register("donut",
            () -> new Item(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC).food(new Food.Builder().setAlwaysEdible().hunger(6).effect(() -> new EffectInstance(Effects.SPEED, 200, 1), 1F).build())));

    public static final RegistryObject<Item> CONFIG_PORTAL = ITEMS.register("config_portal",
            () -> new ConfigPortal(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> TNT_PROP = ITEMS.register("tnt_prop",
            () -> new TntPropeller(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> PORT_END = ITEMS.register("portable_enderchest",
            () -> new portaEndChest(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> INV_VIEW = ITEMS.register("inv_view",
            () -> new InventoryViewer(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> AUTO_BRIDGE = ITEMS.register("auto_bridge",
            () -> new AutoBridge(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> PEW = ITEMS.register("pew",
            () -> new Pew(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> DISCORD_ITEM = ITEMS.register("discord_item",
            () -> new DiscordItem(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> BULLET = ITEMS.register("bullet_item",
            () -> new DiscordItem(new Item.Properties().group(ModItemGroup.RANDOM_GROUP).rarity(Rarity.EPIC)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
