package com.himataku.nmo;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


public class BlockNmo {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Main.MOD_ID);

    public static final DeferredBlock<Block> CRUSHER =
            BLOCKS.register("crusher",
                    () -> new Crusher(BlockBehaviour.Properties.of()));
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
