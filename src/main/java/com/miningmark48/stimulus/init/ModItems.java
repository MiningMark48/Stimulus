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

    public static void register(){
        GameRegistry.register(stimulator);
    }

    public static void registerRenders(){
        registerRender(stimulator);
    }

    public static void registerRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

    public static void registerRender(Item item, int meta, String name){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + name, "inventory"));
    }

}
