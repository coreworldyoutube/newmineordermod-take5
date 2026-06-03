package com.himataku.nmo;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MOD_ID);

    public static final Supplier<CreativeModeTab> BERYLLIUM_ITEMS_TAB = CREATIVE_MODE_TAB.register("nmo_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemNmo.RAW_BERYLLIUM.get()))
                    .title(Component.translatable("creativetab.nmo.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ItemNmo.BERYLLIUM_INGOT);
                        output.accept(ItemNmo.BERYLLIUM_NUGGET);
                        output.accept(ItemNmo.RAW_BERYLLIUM);

                    }).build());

    public static final Supplier<CreativeModeTab> BERYLLIUM_BLOCK_TAB = CREATIVE_MODE_TAB.register("nmo_build_sab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockNmo.BERYLLIUM_DEEPSLATE_ORE))
                    //.withTabsBefore(ResourceLocation.fromNamespaceAndPath(Main.MOD_ID, "nmo_build_sab"))
                    .title(Component.translatable("creativetab.nmo.build"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BlockNmo.BERYLLIUM_DEEPSLATE_ORE);
                        output.accept(BlockNmo.BERYLLIUM_ORE);
                        output.accept(BlockNmo.CRUSHER);


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
