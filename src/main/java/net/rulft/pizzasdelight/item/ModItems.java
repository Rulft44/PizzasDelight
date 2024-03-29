package net.rulft.pizzasdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rulft.pizzasdelight.PizzasDelight;
import net.rulft.pizzasdelight.effect.PizzaEffects;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.FoodValues.MEDIUM_DURATION;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PizzasDelight.MOD_ID);

    // ---------------------------------------------------- Misc
    public static final RegistryObject<Item> OLIVE = ITEMS.register("olive",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).food(new FoodProperties.Builder().fast().nutrition(1).build())));
    public static final RegistryObject<Item> OLIVE_OIL = ITEMS.register("olive_oil",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(16)));
    public static final RegistryObject<Item> SALAMI = ITEMS.register("salami",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB)));
    public static final RegistryObject<Item> SALAMI_SLICE = ITEMS.register("salami_slice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).food((new FoodProperties.Builder()).nutrition(1).meat().fast().build())));
    // ---------------------------------------------------- Cheese
    public static final RegistryObject<Item> MOZZARELLA = ITEMS.register("mozzarella",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).food(new FoodProperties.Builder().nutrition(2).build())));
    public static final RegistryObject<Item> SCAMORZA = ITEMS.register("scamorza",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).food(new FoodProperties.Builder().nutrition(2).build())));
    //TODO public static final RegistryObject<Item> GORGONZOLA = ITEMS.register("gorgonzola",
    //        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).food(new FoodProperties.Builder().build())));
    public static final RegistryObject<Item> PARMIGIANO = ITEMS.register("parmigiano",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB)));
    public static final RegistryObject<Item> PARMIGIANO_DUST = ITEMS.register("parmigiano_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB)));
    // ---------------------------------------------------- Pastas
    public static final RegistryObject<Item> PASTA_AL_SUGO = ITEMS.register("pasta_al_sugo",
            () -> new ConsumableItem(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(16).craftRemainder(Items.BOWL).food(new FoodProperties.Builder().nutrition(12).saturationMod(0.8f)
                    .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F).build())));
    // ---------------------------------------------------- Pizzas
    public static final RegistryObject<Item> MARGHERITA_RAW = ITEMS.register("margherita_raw",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(8)));
    public static final RegistryObject<Item> MARGHERITA = ITEMS.register("margherita",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(8)));

    public static final RegistryObject<Item> MARGHERITA_SLICE = ITEMS.register("margherita_slice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).fast().build())));

    public static final RegistryObject<Item> DIAVOLA_RAW = ITEMS.register("diavola_raw",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(8)));
    public static final RegistryObject<Item> DIAVOLA = ITEMS.register("diavola",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).stacksTo(8)));

    public static final RegistryObject<Item> DIAVOLA_SLICE = ITEMS.register("diavola_slice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PIZZA_TAB).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).fast().alwaysEat().effect(() -> new MobEffectInstance(PizzaEffects.SPICY.get(), 320, 0), 1F).build())));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
