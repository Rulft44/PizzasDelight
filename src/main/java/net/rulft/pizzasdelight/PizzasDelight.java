package net.rulft.pizzasdelight;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rulft.pizzasdelight.block.ModBlocks;
import net.rulft.pizzasdelight.block.entity.ModBlockEntities;
import net.rulft.pizzasdelight.effect.PizzaEffects;
import net.rulft.pizzasdelight.event.LogBlockRegistry;
import net.rulft.pizzasdelight.item.ModItems;
import net.rulft.pizzasdelight.painting.ModPaintings;
import net.rulft.pizzasdelight.recipe.ModRecipes;
import net.rulft.pizzasdelight.screen.BrickOvenScreen;
import net.rulft.pizzasdelight.screen.ModMenuTypes;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PizzasDelight.MOD_ID)
public class PizzasDelight
{

    //smh my balls
    public static final String MOD_ID = "pizzasdelight";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public PizzasDelight()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        LogBlockRegistry.init();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        PizzaEffects.register(eventBus);

        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);

        ModRecipes.register(eventBus);

        ModPaintings.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in, smh smh
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event){
        MenuScreens.register(ModMenuTypes.BRICK_OVEN_MENU.get(), BrickOvenScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
