package com.himataku.nmo;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemNmo {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MOD_ID);

    public static final DeferredItem<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BERYLLIUM = ITEMS.register("raw_beryllium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BERYLLIUM_NUGGET = ITEMS.register("beryllium_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BERYLLIUM_DUST = ITEMS.register("beryllium_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COPPER_DUST = ITEMS.register("copper_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALLOW_BERYLLIUM_COPPER = ITEMS.register("allow_beryllium_copper",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BERYLLIUM_COPPER_DUST = ITEMS.register("beryllium_copper_dust",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
