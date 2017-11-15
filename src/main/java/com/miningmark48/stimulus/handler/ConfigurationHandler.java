package com.miningmark48.stimulus.handler;

import com.miningmark48.mininglib.utility.ModTranslate;
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

        tickAmount = configuration.getInt(ModTranslate.toLocal("config.tickAmount.title"), Configuration.CATEGORY_GENERAL, 5, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.tickAmount.desc"));

        multiplier = configuration.getInt(ModTranslate.toLocal("config.multiplier.title"), Configuration.CATEGORY_GENERAL, 2, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.multiplier.desc"));

        dustDropAmount = configuration.getInt(ModTranslate.toLocal("config.dustDropAmount.title"), Configuration.CATEGORY_GENERAL, 6, 1, Integer.MAX_VALUE, ModTranslate.toLocal("config.dustDropAmount.desc"));
        dustDropChance = configuration.getFloat(ModTranslate.toLocal("config.dustDropChance.title"), Configuration.CATEGORY_GENERAL, 0.5f, 0.0f, 1.0f, ModTranslate.toLocal("config.dustDropChance.desc"));

        if (configuration.hasChanged()){
            configuration.save();
        }

    }

}
