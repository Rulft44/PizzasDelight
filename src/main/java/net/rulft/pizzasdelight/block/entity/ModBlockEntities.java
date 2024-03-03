package net.rulft.pizzasdelight.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rulft.pizzasdelight.PizzasDelight;
import net.rulft.pizzasdelight.block.ModBlocks;
import net.rulft.pizzasdelight.block.entity.custom.BrickOvenBlockEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PizzasDelight.MOD_ID);

    public static final RegistryObject<BlockEntityType<BrickOvenBlockEntity>> BRICK_OVEN_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("brick_oven_block_entity", () ->
                    BlockEntityType.Builder.of(BrickOvenBlockEntity::new,
                            ModBlocks.BRICK_OVEN.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
