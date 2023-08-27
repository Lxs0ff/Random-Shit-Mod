package com.lxs.randomshit.block;

import com.lxs.randomshit.RandomShit;
import com.lxs.randomshit.block.custom.WeakBlock;
import com.lxs.randomshit.item.ModItemGroup;
import com.lxs.randomshit.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RandomShit.MOD_ID);

    public static final RegistryObject<Block> WHYNOT_ORE = RegisterBlock("whynot_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> WEAK_BLOCK = RegisterBlock("weak_block",
            () -> new WeakBlock(AbstractBlock.Properties.create(Material.GLASS)));

    private static <T extends Block>RegistryObject<T> RegisterBlock(String Name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(Name,block);
        registerBlockItem(Name,toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String Name,RegistryObject<T> block){
        ModItems.ITEMS.register(Name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.RANDOM_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
