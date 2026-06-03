package com.himataku.nmo;

import com.himataku.nmo.hyperion.Crusher;
import com.himataku.nmo.hyperion.Mixer;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class BlockNmo {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Main.MOD_ID);

    public static final DeferredBlock<Block> BERYLLIUM_ORE = registerBlock("beryllium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BERYLLIUM_DEEPSLATE_ORE = registerBlock("beryllium_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> CRUSHER = registerBlock("crusher",
            () -> new Crusher(BlockBehaviour.Properties.of()));

    public static final DeferredBlock<Block> MIXER = registerBlock("mixer",
            () -> new Mixer(BlockBehaviour.Properties.of()));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ItemNmo.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
