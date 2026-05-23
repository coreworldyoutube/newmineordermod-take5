package com.himataku.nmo;


import com.himataku.nmo.e.ModBlockEntities;
import com.himataku.nmo.screen.ModMenuTypes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod("nmo")
public class Main {
    public static final String MOD_ID = "nmo";

    public Main(IEventBus modEventBus) {
        BlockNmo.register(modEventBus);
        ItemNmo.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

    }
}