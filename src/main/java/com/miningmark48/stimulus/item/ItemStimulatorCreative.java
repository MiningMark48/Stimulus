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

public class ItemStimulatorCreative extends ItemStimulatorBase{

    public ItemStimulatorCreative() {
        super(ConfigurationHandler.tickAmount * 1024, true);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        if (KeyChecker.isHoldingShift()) {
            tooltip.add(TextFormatting.LIGHT_PURPLE + ModTranslate.toLocal("tooltip.item.stimulator_creative.line1"));
        }
    }

}
