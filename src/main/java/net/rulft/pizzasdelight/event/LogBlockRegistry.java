package net.rulft.pizzasdelight.event;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.rulft.pizzasdelight.PizzasDelight;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = PizzasDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LogBlockRegistry {
    public static void init() {
        MinecraftForge.EVENT_BUS.addListener(LogBlockRegistry::onServerStarting);
    }

    private static void onServerStarting(ServerStartingEvent event) {
        // Any server starting logic can be added here if needed
    }

    public static boolean isLogItem(Item item) {
        return item instanceof BlockItem && isLogBlock(((BlockItem) item).getBlock());
    }

    public static boolean isLogBlock(Block block) {
        return block.asItem().builtInRegistryHolder().is(ItemTags.LOGS);
    }

    public static Ingredient getLogItemsFromTags() {
        List<ItemStack> logItems = new ArrayList<>();
        for (Item item : ForgeRegistries.ITEMS) {
            if (isLogItem(item)) {
                logItems.add(new ItemStack(item));
            }
        }
        return Ingredient.of(logItems.toArray(new ItemStack[0]));
    }
}