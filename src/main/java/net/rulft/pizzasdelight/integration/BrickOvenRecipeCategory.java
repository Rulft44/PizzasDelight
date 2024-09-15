package net.rulft.pizzasdelight.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import net.rulft.pizzasdelight.PizzasDelight;
import net.rulft.pizzasdelight.block.ModBlocks;
import net.rulft.pizzasdelight.event.LogBlockRegistry;
import net.rulft.pizzasdelight.recipe.BrickOvenRecipe;

import javax.annotation.Nonnull;
import java.util.Set;

public class BrickOvenRecipeCategory implements IRecipeCategory<BrickOvenRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(PizzasDelight.MOD_ID, "brick_ovening");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(PizzasDelight.MOD_ID, "textures/gui/jei/brick_oven_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public BrickOvenRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 25, 14, 117, 57);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.BRICK_OVEN.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends BrickOvenRecipe> getRecipeClass() {
        return BrickOvenRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Brick Oven");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull BrickOvenRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        Ingredient logIngredient = LogBlockRegistry.getLogItemsFromTags();

        // Input slot for logs based on materials
        builder.addSlot(RecipeIngredientRole.INPUT, 9, 21).addIngredients(logIngredient);

        builder.addSlot(RecipeIngredientRole.INPUT, 43, 21).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 88, 21).addItemStack(recipe.getResultItem());
    }
}
