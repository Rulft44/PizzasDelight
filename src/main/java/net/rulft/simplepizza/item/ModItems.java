package net.rulft.simplepizza.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rulft.simplepizza.SimplePizza;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SimplePizza.MOD_ID);

    public static final RegistryObject<Item> MARGHERITA_RAW = ITEMS.register("margherita_raw",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(1)));
    public static final RegistryObject<Item> MARGHERITA = ITEMS.register("margherita",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(1)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
