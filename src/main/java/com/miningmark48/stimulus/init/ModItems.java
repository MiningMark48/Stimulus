package com.miningmark48.stimulus.init;

import com.miningmark48.stimulus.creativetabs.CreativeTabStimulus;
import com.miningmark48.stimulus.item.*;
import net.minecraft.item.Item;

public class ModItems {

    public static Item stimulator_1;
    public static Item stimulator_2;
    public static Item stimulator_3;
    public static Item stimulator_4;
    public static Item stimulator_5;
    public static Item stimulator_6;
    public static Item stimulator_charge;

    public static void init(){
        stimulator_1 = new ItemStimulatorTierOne().setUnlocalizedName("stimulator_1").setRegistryName("stimulator_1").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
        stimulator_2 = new ItemStimulatorTierTwo().setUnlocalizedName("stimulator_2").setRegistryName("stimulator_2").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
        stimulator_3 = new ItemStimulatorTierThree().setUnlocalizedName("stimulator_3").setRegistryName("stimulator_3").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
        stimulator_4 = new ItemStimulatorTierFour().setUnlocalizedName("stimulator_4").setRegistryName("stimulator_4").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
        stimulator_5 = new ItemStimulatorTierFive().setUnlocalizedName("stimulator_5").setRegistryName("stimulator_5").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
        stimulator_6 = new ItemStimulatorTierSix().setUnlocalizedName("stimulator").setRegistryName("stimulator").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
        stimulator_charge = new ItemStimulatorCharge().setUnlocalizedName("stimulator_charge").setRegistryName("stimulator_charge").setCreativeTab(CreativeTabStimulus.Stimulus_TAB);
    }

}
