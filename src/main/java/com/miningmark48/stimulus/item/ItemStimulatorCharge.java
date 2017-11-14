package com.miningmark48.stimulus.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModLogger;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.stimulus.handler.ConfigurationHandler;
import com.miningmark48.stimulus.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStimulatorCharge extends Item {

    private ItemStack consumeItem;
    private int multiplier = ConfigurationHandler.multiplier;

    public ItemStimulatorCharge(){
        setMaxStackSize(1);
        consumeItem = new ItemStack(ModItems.stimulation_dust);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            tooltip.add(TextFormatting.DARK_GREEN + ModTranslate.toLocal("tooltip.item.stimulator_charge.line1.charge") + TextFormatting.GOLD + (stack.hasTagCompound() ? stack.getTagCompound().getInteger("charge") : 0));
            tooltip.add(TextFormatting.AQUA + ModTranslate.toLocal("tooltip.item.stimulator_charge.line2.p1") + TextFormatting.DARK_AQUA + consumeItem.getDisplayName() + TextFormatting.AQUA + ModTranslate.toLocal("tooltip.item.stimulator_charge.line2.p2"));
            tooltip.add(TextFormatting.AQUA + ModTranslate.toLocal("tooltip.item.stimulator_charge.line3"));
        }else{
            tooltip.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (worldIn.isRemote) {
            if (player.inventory.hasItemStack(consumeItem)) {
                int charge = stack.getTagCompound().getInteger("charge");
                int chargeCount;
                if (player.isSneaking()) {
                    chargeCount = player.inventory.getStackInSlot(player.inventory.getSlotFor(consumeItem)).getCount() * multiplier;
                    stack.getTagCompound().setInteger("charge", charge + chargeCount);
                    player.inventory.getStackInSlot(player.inventory.getSlotFor(consumeItem)).setCount(0);
                } else {
                    chargeCount = multiplier;
                    stack.getTagCompound().setInteger("charge", charge + chargeCount);
                    player.inventory.getStackInSlot(player.inventory.getSlotFor(consumeItem)).shrink(1);
                }
                player.sendMessage(new TextComponentString(TextFormatting.RED + "" + chargeCount + ModTranslate.toLocal("chat.item.stimulator_charge.added")));
            } else {
                player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + ModTranslate.toLocal("chat.item.stimulator_charge.missingItem.p1") + consumeItem.getDisplayName() + ModTranslate.toLocal("chat.item.stimulator_charge.missingItem.p2")));
            }
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

}
