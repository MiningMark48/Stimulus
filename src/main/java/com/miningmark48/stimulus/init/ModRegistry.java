package com.miningmark48.stimulus.init;

import com.miningmark48.stimulus.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.LinkedList;
import java.util.List;

public class ModRegistry {

    private static List<Item> itemsToRegister = new LinkedList<>();

    public static void init() {
        registerItems();
    }

    private static void registerItems() {
        registerItem(ModItems.stimulator_1);
        registerItem(ModItems.stimulator);
        registerItem(ModItems.stimulator_charge);
    }

    public static void registerRenderItems() {
        registerItemRender(ModItems.stimulator_1);
        registerItemRender(ModItems.stimulator);
        registerItemRender(ModItems.stimulator_charge);
    }

    //Registry
    @SubscribeEvent
    public void onItemRegistry(RegistryEvent.Register<Item> event){
        itemsToRegister.forEach(event.getRegistry()::register);
    }

    private static void registerItem(Item item){
        itemsToRegister.add(item);
    }

    public static void registerItemRender(Item item){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
