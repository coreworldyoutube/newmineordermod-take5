package com.himataku.nmo;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemNmo {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MOD_ID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
