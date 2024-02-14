package net.rulft.pizzasdelight.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rulft.pizzasdelight.PizzasDelight;
import net.rulft.pizzasdelight.effect.ModEffects;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PizzasDelight.MOD_ID);

    public static final RegistryObject<Item> MOZZARELLA = ITEMS.register("mozzarella",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB)));

    public static final RegistryObject<Item> MARGHERITA_RAW = ITEMS.register("margherita_raw",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(1)));
    public static final RegistryObject<Item> MARGHERITA = ITEMS.register("margherita",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(1)));

    public static final RegistryObject<Item> MARGHERITA_SLICE = ITEMS.register("margherita_slice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).fast().build())));



    public static final RegistryObject<Item> DIAVOLA_RAW = ITEMS.register("diavola_raw",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(1)));
    public static final RegistryObject<Item> DIAVOLA = ITEMS.register("diavola",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(1)));

    public static final RegistryObject<Item> DIAVOLA_SLICE = ITEMS.register("diavola_slice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).fast().alwaysEat().effect(() -> new MobEffectInstance(ModEffects.SPICY.get(), 320, 0), 1F).build())));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
