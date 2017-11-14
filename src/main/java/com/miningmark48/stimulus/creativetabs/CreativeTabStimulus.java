package com.miningmark48.stimulus.creativetabs;

import com.miningmark48.stimulus.init.ModItems;
import com.miningmark48.stimulus.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabStimulus {

    public static final CreativeTabs Stimulus_TAB = new CreativeTabs(Reference.MOD_ID) {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.stimulator_6);
        }

    };

}
