package com.miningmark48.stimulus.item;

import com.miningmark48.mininglib.utility.KeyChecker;
import com.miningmark48.mininglib.utility.ModTranslate;
import com.miningmark48.stimulus.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public abstract class ItemStimulatorBase extends Item {

    private int tickAmount;

    private Random random = new Random();

    public ItemStimulatorBase(int tickAmount){
        setMaxStackSize(1);
        this.tickAmount = tickAmount;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced) {
        if (KeyChecker.isHoldingShift()) {
            tooltip.add(TextFormatting.DARK_GREEN + ModTranslate.toLocal("tooltip.item.stimulator.line1"));
            tooltip.add(TextFormatting.YELLOW + new ItemStack(ModItems.stimulator_charge).getDisplayName() + ModTranslate.toLocal("tooltip.item.stimulator.line2"));
        }else{
            tooltip.add(ModTranslate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + ModTranslate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

        if(!world.isRemote){
            IBlockState state = world.getBlockState(pos);
            Block block = state.getBlock();
            TileEntity te = world.getTileEntity(pos);

            if (player.inventory.hasItemStack(new ItemStack(ModItems.stimulator_charge)) || player.isCreative()) {
                ItemStack stack1 = ItemStack.EMPTY;
                for (int i = 0; i <= player.inventory.getSizeInventory(); i++){
                    if (player.inventory.getStackInSlot(i).getItem() instanceof ItemStimulatorCharge) {
                        stack1 = player.inventory.getStackInSlot(i);
                    }
                }

                if ((stack1 != null && !stack1.isEmpty() || player.isCreative())) {

                    int stimCharge = (stack1.hasTagCompound() ? stack1.getTagCompound().getInteger("charge") : 0);

                    if (stimCharge >= 1 || player.isCreative()) {
                        for (int i = 0; i < (tickAmount) / (te == null ? 5 : 1); i++) {
                            if (te == null) {
                                block.updateTick(world, pos, state, this.random);
                            } else if ((te instanceof ITickable)) {
                                ((ITickable) te).update();
                            }
                        }
                        if (te instanceof ITickable) {
                            ((ITickable) te).update();
                        }

                        if (!player.isCreative()) stack1.getTagCompound().setInteger("charge", stimCharge - 1);

                    }
                }
            }
        }

        return EnumActionResult.SUCCESS;
    }

}
