package com.himataku.nmo;


import com.himataku.nmo.e.ModBlockEntities;
import com.himataku.nmo.recipe.ModRecipes;
import com.himataku.nmo.screen.CrusherScreen;
import com.himataku.nmo.screen.MixerScreen;
import com.himataku.nmo.screen.ModMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@Mod("nmo")
public class Main {
    public static final String MOD_ID = "nmo";

    public Main(IEventBus modEventBus) {
        BlockNmo.register(modEventBus);
        ItemNmo.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
    }
    @EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.CRUSHER_MENU.get(), CrusherScreen::new);
            event.register(ModMenuTypes.MIXER_MENU.get(), MixerScreen::new);
        }
    }
}