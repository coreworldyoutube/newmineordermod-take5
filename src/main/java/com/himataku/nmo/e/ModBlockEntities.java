package com.himataku.nmo.e;

import com.himataku.nmo.BlockNmo;
import com.himataku.nmo.Crusher;
import com.himataku.nmo.Main;
import com.himataku.nmo.screen.CrusherMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    //IDK ENGLISH AND HOW TO MAKE IT? I TRY TO MAKE MYSELF WAAAAAAA.
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.MOD_ID);


    public static final Supplier<BlockEntityType<CrusherBlockEntity>> CRUSHER_BE =
            BLOCK_ENTITIES.register("crusher_be", () -> BlockEntityType.Builder.of(
                    CrusherBlockEntity::new, BlockNmo.CRUSHER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
