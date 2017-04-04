package com.miningmark48.stimulus.init;

import com.miningmark48.stimulus.handler.ConfigurationHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {

    public static void init(){

        if (ConfigurationHandler.hasRecipe) {
            if (ConfigurationHandler.useExpensiveRecipe){
                GameRegistry.addRecipe(new ItemStack(ModItems.stimulator), " xy", " zx", "z  ", 'x', new ItemStack(Blocks.DIAMOND_BLOCK), 'y', new ItemStack(Items.NETHER_STAR), 'z', new ItemStack(Blocks.OBSIDIAN));
            }else{
                GameRegistry.addRecipe(new ItemStack(ModItems.stimulator), " xy", " zx", "z  ", 'x', new ItemStack(Items.EMERALD), 'y', new ItemStack(Blocks.DIAMOND_BLOCK), 'z', new ItemStack(Blocks.OBSIDIAN));
            }
        }
    }

}
