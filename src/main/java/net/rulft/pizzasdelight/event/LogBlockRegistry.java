package net.rulft.pizzasdelight.event;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rulft.pizzasdelight.PizzasDelight;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = PizzasDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LogBlockRegistry {
    private static final Set<Material> logMaterials = new HashSet<>();

    public static void init() {
        MinecraftForge.EVENT_BUS.addListener(LogBlockRegistry::onServerStarting);
    }

    private static void onServerStarting(ServerStartingEvent event) {
        // Clear and rebuild the list of log materials
        logMaterials.clear();
        // Add more materials if needed
        logMaterials.add(Material.WOOD);
        logMaterials.add(Material.NETHER_WOOD);
    }

    public static boolean isLogItem(Item item) {
        return item instanceof BlockItem && isLogBlock(((BlockItem) item).getBlock());
    }

    public static boolean isLogBlock(Block block) {
        return logMaterials.contains(block.defaultBlockState().getMaterial());
    }
}
