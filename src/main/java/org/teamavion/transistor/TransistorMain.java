package org.teamavion.transistor;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.teamavion.transistor.common.CommonProxy;
import org.teamavion.transistor.common.items.ModItems;

@Mod(modid = TransistorMain.MODID, name = "Transistor()", version = "0.1a")
public class TransistorMain {
    public static final String MODID = "transistor";

    @Mod.Instance
    public static TransistorMain instance;

    @SidedProxy(clientSide = "org.teamavion.transistor.client.ClientProxy", serverSide = "org.teamavion.transistor.server.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.register();

        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

}
