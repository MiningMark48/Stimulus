package com.miningmark48.stimulus.handler;

import com.miningmark48.stimulus.reference.Reference;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean hasRecipe;
    public static boolean useExpensiveRecipe;
    public static int tickAmount;

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

        hasRecipe = configuration.getBoolean("Has recipe?", Configuration.CATEGORY_GENERAL, true, "Does the Stimulator have a recipe?");
        useExpensiveRecipe = configuration.getBoolean("Use Expensive Recipe", Configuration.CATEGORY_GENERAL, false, "Use the more expensive recipe.");
        tickAmount = configuration.getInt("Tick Amount Base", Configuration.CATEGORY_GENERAL, 5, 1, Integer.MAX_VALUE, "Amount of times the block is ticked.");

        multiplier = configuration.getInt("Multiplier", Configuration.CATEGORY_GENERAL, 2, 1, Integer.MAX_VALUE, "Multiplier for the amount of charge applied per item.");

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
