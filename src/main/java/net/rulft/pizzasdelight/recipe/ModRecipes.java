package net.rulft.pizzasdelight.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rulft.pizzasdelight.PizzasDelight;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PizzasDelight.MOD_ID);

    public static final RegistryObject<RecipeSerializer<BrickOvenRecipe>> BRICK_OVENING_SERIALIZER =
            SERIALIZERS.register("brick_ovening", () -> BrickOvenRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}