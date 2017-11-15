package com.miningmark48.stimulus.handler;

import com.miningmark48.stimulus.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class EventBlockBroken {

    @SubscribeEvent
    public void onBreak(BlockEvent.HarvestDropsEvent e) {
        Block block = e.getState().getBlock();
        Random rand = new Random();
        if (block == Blocks.REDSTONE_ORE || block == Blocks.LIT_REDSTONE_ORE) {
            e.setDropChance(ConfigurationHandler.dustDropChance);
            e.getDrops().add(new ItemStack(ModItems.stimulation_dust, rand.nextInt(ConfigurationHandler.dustDropAmount) + 1));
        }

    }

}
