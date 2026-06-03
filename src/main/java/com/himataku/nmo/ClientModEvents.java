package com.himataku.nmo;

import com.himataku.nmo.screen.CrusherScreen;
import com.himataku.nmo.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.bus.api.SubscribeEvent;

public class ClientModEvents {
    public static void registerScreens(RegisterMenuScreensEvent event) {
        System.out.println("REGISTERING CRUSHER SCREEN");

        event.register(
                ModMenuTypes.CRUSHER_MENU.get(),
                CrusherScreen::new
        );
    }

}