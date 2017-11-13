package com.miningmark48.stimulus.init;

import com.miningmark48.stimulus.creativetabs.CreativeTabStimulus;
import com.miningmark48.stimulus.item.ItemStimulator;
import com.miningmark48.stimulus.item.ItemStimulatorCharge;
import com.miningmark48.stimulus.item.ItemStimulatorTierOne;
import com.miningmark48.stimulus.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

    public static Item stimulator_1;
    public static Item stimulator;
    public static Item stimulator_charge;

    public static void init(){
        stimulator_1 = new ItemStimulatorTierOne().setUnlocalizedName("stimulator_1").setRegistryName("stimulator_1").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
        stimulator = new ItemStimulator().setUnlocalizedName("stimulator").setRegistryName("stimulator").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
        stimulator_charge = new ItemStimulatorCharge().setUnlocalizedName("stimulator_charge").setRegistryName("stimulator_charge").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
    }

}
