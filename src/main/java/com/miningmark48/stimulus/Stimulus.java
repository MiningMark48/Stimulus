package com.miningmark48.stimulus;

import com.miningmark48.stimulus.handler.ConfigurationHandler;
import com.miningmark48.stimulus.init.ModItems;
import com.miningmark48.stimulus.init.ModRegistry;
import com.miningmark48.stimulus.init.Recipes;
import com.miningmark48.stimulus.proxy.CommonProxy;
import com.miningmark48.stimulus.reference.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        guiFactory = Reference.GUI_FACTORY_CLASS,
        dependencies = Reference.MOD_DEPENDENCIES
)
public class Stimulus {

    @Mod.Instance(Reference.MOD_ID)
    public static Stimulus instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        MinecraftForge.EVENT_BUS.register(new ModRegistry());

        ModItems.init();
        ModRegistry.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenders();
        proxy.init();
        Recipes.init();
    }
}
