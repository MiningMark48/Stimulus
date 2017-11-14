package com.miningmark48.stimulus.handler;

import com.miningmark48.mininglib.utility.ModLogger;
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
            e.setDropChance(0.5f);
            e.getDrops().add(new ItemStack(ModItems.stimulation_dust, rand.nextInt(6) + 1));
            ModLogger.info(e.getDropChance());
        }

    }

}
