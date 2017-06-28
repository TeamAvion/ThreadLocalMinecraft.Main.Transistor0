package org.teamavion.transistor.common.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.teamavion.transistor.util.AutoRegister;

import java.lang.reflect.Field;

public final class ModItems {

    @AutoRegister
    public static final Item transistor = new ItemTransistor();

    private static final Item defaultItem = new Item();

    public static void register() {
        Item defaultItem = new Item();
        try {
            for (Field field : ModItems.class.getDeclaredFields()) {
                if (field.isAnnotationPresent(AutoRegister.class)) {
                    Object value = field.get(defaultItem);
                    if (value instanceof Item) {
                        GameRegistry.register((Item) value);
                    }
                }
            }
        } catch (IllegalAccessException ignored) {}
    }

    public static void registerRenders() {
        try {
            for (Field field : ModItems.class.getDeclaredFields()) {
                if (field.isAnnotationPresent(AutoRegister.class)) {
                    Object value = field.get(defaultItem);
                    if (value instanceof Item) {
                        AutoRegister autoRegister = field.getAnnotation(AutoRegister.class);
                        for (int meta : autoRegister.metaValues()) {
                            registerRender((Item) value, meta);
                        }
                    }
                }
            }
        } catch (IllegalAccessException ignored) {}
    }

    private static void registerRender(Item item, int meta) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
