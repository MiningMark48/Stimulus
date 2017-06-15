package com.miningmark48.stimulus.item;

import com.miningmark48.stimulus.handler.ConfigurationHandler;
import com.miningmark48.stimulus.utility.KeyCheck;
import com.miningmark48.stimulus.utility.Translate;
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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class ItemStimulator extends Item{

    private Random random = new Random();

    public ItemStimulator(){
        setMaxStackSize(1);
        setMaxDamage(ConfigurationHandler.durability);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World playerIn, List<String> tooltip, ITooltipFlag advanced) {
        if (KeyCheck.isHoldingShift()) {
            tooltip.add(Translate.toLocal("tooltip.item.stimulator.line1"));
        }else{
            tooltip.add(Translate.toLocal("tooltip.item.hold") + " " + TextFormatting.AQUA + TextFormatting.ITALIC + Translate.toLocal("tooltip.item.shift"));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

        ItemStack stack = player.getHeldItem(hand);

        if(!world.isRemote){
            IBlockState state = world.getBlockState(pos);
            Block block = state.getBlock();
            TileEntity te = world.getTileEntity(pos);

            for (int i = 0; i < (ConfigurationHandler.tickAmount) / (te == null ? 5 : 1); i++) {
                if (te == null) {
                    block.updateTick(world, pos, state, this.random);
                } else if ((te instanceof ITickable)) {
                    ((ITickable)te).update();
                }
            }
            if( te instanceof ITickable){
                ((ITickable)te).update();
            }

            stack.damageItem(1, player);

        }

        return EnumActionResult.SUCCESS;
    }

}
