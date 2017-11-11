package com.miningmark48.stimulus.init;

import com.miningmark48.stimulus.handler.ConfigurationHandler;

public class Recipes {

    public static void init(){

        if (ConfigurationHandler.hasRecipe) {
            if (ConfigurationHandler.useExpensiveRecipe){
                //GameRegistry.addRecipe(new ItemStack(ModItems.stimulator), " xy", " zx", "z  ", 'x', new ItemStack(Blocks.DIAMOND_BLOCK), 'y', new ItemStack(Items.NETHER_STAR), 'z', new ItemStack(Blocks.OBSIDIAN));
            }else{
                //GameRegistry.addRecipe(new ItemStack(ModItems.stimulator), " xy", " zx", "z  ", 'x', new ItemStack(Items.EMERALD), 'y', new ItemStack(Blocks.DIAMOND_BLOCK), 'z', new ItemStack(Blocks.OBSIDIAN));
            }
        }
    }

}
