package com.miningmark48.stimulus.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.stimulus.handler.ConfigurationHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStimulatorTierSix extends ItemStimulatorBase{

    public ItemStimulatorTierSix() {
        super(ConfigurationHandler.tickAmount * 6);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        if (KeyChecker.isHoldingShift()) {
            tooltip.add(TextFormatting.GOLD + ModTranslate.toLocal("tooltip.item.stimulator_6.line1"));
        }
    }

}
