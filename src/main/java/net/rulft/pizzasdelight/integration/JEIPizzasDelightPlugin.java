package net.rulft.pizzasdelight.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.rulft.pizzasdelight.PizzasDelight;
import net.rulft.pizzasdelight.recipe.BrickOvenRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIPizzasDelightPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(PizzasDelight.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                BrickOvenRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<BrickOvenRecipe> recipes = rm.getAllRecipesFor(BrickOvenRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(BrickOvenRecipeCategory.UID, BrickOvenRecipe.class), recipes);
    }
}
