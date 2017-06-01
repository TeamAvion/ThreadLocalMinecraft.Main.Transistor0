package org.teamavion.transistor;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.teamavion.transistor.items.ItemTransistor;

@Mod(modid = "transistor()", version = "0.1a")
public class TransistorMain {
    public static Item transistor = new ItemTransistor();
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.register(transistor);
    }
}
