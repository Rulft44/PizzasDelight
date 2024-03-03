package net.rulft.pizzasdelight.event;


import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rulft.pizzasdelight.PizzasDelight;
import net.rulft.pizzasdelight.recipe.BrickOvenRecipe;

@Mod.EventBusSubscriber(modid = PizzasDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, BrickOvenRecipe.Type.ID, BrickOvenRecipe.Type.INSTANCE);
    }
}
