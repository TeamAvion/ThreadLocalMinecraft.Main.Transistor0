package org.teamavion.transistor.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Thor Johansson on 5/31/2017.
 */
public class ItemTransistor extends Item{
    public ItemTransistor() {
        this.setMaxStackSize(1);
        this.setRegistryName("ItemTransistor()");
        this.setUnlocalizedName("transistor()");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        return false;
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        return true;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 2;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if(!worldIn.isRemote && (playerIn.onGround || playerIn.capabilities.isFlying) && (playerIn.moveForward > 0F || playerIn.moveStrafing > 0F)){
            playerIn.moveRelative(playerIn.moveForward, playerIn.moveStrafing, -1f);
        }

        if (this.canCast())
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult(EnumActionResult.FAIL, itemstack);
        }
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            if(!worldIn.isRemote)
                this.cast(stack, worldIn, entityplayer);
        }
        return stack;
    }

    private void cast(ItemStack stack, World worldIn, EntityPlayer entityplayer) {
        EntityArrow entityarrow = new ItemArrow().createArrow(worldIn, new ItemStack(Items.ARROW), entityplayer);
        entityarrow.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, 1 * 3.0F, 1.0F);
        entityarrow.setIsCritical(true);
        worldIn.spawnEntity(entityarrow);
    }

    private boolean canCast() {
        return true;
    }

    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(!worldIn.isRemote && entityIn instanceof EntityPlayer)
            if(isSelected)
                entityIn.moveRelative(((EntityPlayer) entityIn).moveStrafing, ((EntityPlayer) entityIn).moveForward, -0.6f);

    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        return "transistor(ping())";
    }

    public String getHighlightTip( ItemStack item, String displayName )
    {
        return displayName;
    }
}
