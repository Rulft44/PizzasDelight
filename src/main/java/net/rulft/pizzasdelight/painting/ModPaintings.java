package net.rulft.pizzasdelight.painting;

import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rulft.pizzasdelight.PizzasDelight;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTING_MOVTIES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, PizzasDelight.MOD_ID);


    public static final RegistryObject<Motive> FLAG =
            PAINTING_MOVTIES.register("flag", () -> new Motive(32, 16));
    public static final RegistryObject<Motive> PIZZA_PARTY =
            PAINTING_MOVTIES.register("pizza_party", () -> new Motive(16, 16));
    public static final RegistryObject<Motive> PISA =
            PAINTING_MOVTIES.register("pisa", () -> new Motive(16, 32));
    public static final RegistryObject<Motive> AL_SUGO =
            PAINTING_MOVTIES.register("al_sugo", () -> new Motive(32, 32));


    public static void register(IEventBus eventBus) {
        PAINTING_MOVTIES.register(eventBus);
    }
}