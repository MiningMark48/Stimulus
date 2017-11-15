package com.miningmark48.stimulus.handler;

import com.miningmark48.stimulus.reference.Reference;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static int tickAmount;
    public static int dustDropAmount;
    public static float dustDropChance;

    public static int multiplier;

    public static void init(File configFile){

        //Create the configuration object from the given configuration file
        if (configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)){
            loadConfiguration();
        }

    }

    private static void loadConfiguration(){

        tickAmount = configuration.getInt("Tick Amount Base", Configuration.CATEGORY_GENERAL, 5, 1, Integer.MAX_VALUE, "Amount of times the block is ticked.");

        multiplier = configuration.getInt("Multiplier", Configuration.CATEGORY_GENERAL, 2, 1, Integer.MAX_VALUE, "Multiplier for the amount of charge applied per item.");

        dustDropAmount = configuration.getInt("Stimulation Dust Drop Amount", Configuration.CATEGORY_GENERAL, 6, 1, Integer.MAX_VALUE, "Max amount of Stimulation Dust than can be dropped from Redstone Ore.");
        dustDropChance = configuration.getFloat("Stimulation Dust Drop Chance", Configuration.CATEGORY_GENERAL, 0.5f, 0.0f, 1.0f, "Chance for Stimulation Dust to drop from Redstone Ore.");

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
