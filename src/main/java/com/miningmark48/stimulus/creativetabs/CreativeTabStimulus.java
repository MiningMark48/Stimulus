package com.miningmark48.stimulus.creativetabs;

import com.miningmark48.stimulus.init.ModItems;
import com.miningmark48.stimulus.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabStimulus {

    public static final CreativeTabs Stimulus_TAB = new CreativeTabs(Reference.MOD_ID) {

        @Override
        public Item getTabIconItem() {
            return ModItems.stimulator;
        }

    };

}
