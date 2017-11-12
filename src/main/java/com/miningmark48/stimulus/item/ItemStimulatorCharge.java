package com.miningmark48.stimulus.item;

import com.miningmark48.stimulus.utility.KeyCheck;
import com.miningmark48.stimulus.utility.Translate;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStimulatorCharge extends Item {

    private ItemStack consumeItem = new ItemStack(Items.REDSTONE);

    public ItemStimulatorCharge(){
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced) {
        if (KeyCheck.isHoldingShift()) {
            tooltip.add(TextFormatting.DARK_GREEN + Translate.toLocal("tooltip.item.stimulator_charge.line1.charge") + TextFormatting.GOLD + (stack.hasTagCompound() ? stack.getTagCompound().getInteger("charge") : 0));
            tooltip.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.stimulator_charge.line2.p1") + consumeItem.getDisplayName() + Translate.toLocal("tooltip.item.stimulator_charge.line2.p2"));
            tooltip.add(TextFormatting.AQUA + Translate.toLocal("tooltip.item.stimulator_charge.line3"));
        }else{
            tooltip.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        int multiplier = 2;

        if (player.inventory.hasItemStack(consumeItem)) {
            int charge = stack.getTagCompound().getInteger("charge");
            if (player.isSneaking()) {
                stack.getTagCompound().setInteger("charge", charge + (player.inventory.getStackInSlot(player.inventory.getSlotFor(consumeItem)).getCount() * multiplier));
                player.inventory.getStackInSlot(player.inventory.getSlotFor(consumeItem)).setCount(0);
            } else {
                stack.getTagCompound().setInteger("charge", charge + (multiplier));
                player.inventory.getStackInSlot(player.inventory.getSlotFor(consumeItem)).shrink(1);
            }

        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

}
