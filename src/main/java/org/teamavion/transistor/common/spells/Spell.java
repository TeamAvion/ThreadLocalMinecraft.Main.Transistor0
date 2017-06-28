package org.teamavion.transistor.common.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.INBTSerializable;

public abstract class Spell implements INBTSerializable<NBTTagCompound> {

    private String name;
    private String description;
    private int memoryCost;
    private int chargingTime;
    private int cooldownTime;

    public abstract boolean passiveCast(ItemStack stack, World worldIn, EntityPlayer player);
    public abstract boolean activeCast(ItemStack stack, World worldIn, EntityPlayer player);

    @Override
    public NBTTagCompound serializeNBT() {
        return null;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {

    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setMemoryCost(int memoryCost) {
        this.memoryCost = memoryCost;
    }
    public int getMemoryCost() {
        return memoryCost;
    }

    public void setChargingTime(int chargingTime) {
        this.chargingTime = chargingTime;
    }
    public int getChargingTime() {
        return chargingTime;
    }

    public void setCooldownTime(int cooldownTime) {
        this.cooldownTime = cooldownTime;
    }
    public int getCooldownTime() {
        return cooldownTime;
    }

}
