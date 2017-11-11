package com.miningmark48.stimulus.init;

import com.miningmark48.stimulus.creativetabs.CreativeTabStimulus;
import com.miningmark48.stimulus.item.ItemStimulator;
import com.miningmark48.stimulus.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item stimulator;

    public static void init(){
        stimulator = new ItemStimulator().setUnlocalizedName("stimulator").setRegistryName("stimulator").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
    }

}
