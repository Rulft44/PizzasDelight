package net.rulft.simplepizza.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.rulft.simplepizza.item.ModItems;

public class ModCreativeModeTab {
    public static final CreativeModeTab PIZZA_TAB = new CreativeModeTab("pizzatab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MARGHERITA.get());
        }
    };
}