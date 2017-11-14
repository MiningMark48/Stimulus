package com.miningmark48.stimulus.item;

import com.miningmark48.mininglib.base.item.ModBaseItem;
import com.miningmark48.mininglib.utility.ModTranslate;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStimulationDust extends ModBaseItem {

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.YELLOW + ModTranslate.toLocal("tooltip.item.stimulation_dust.line1"));
    }
}
