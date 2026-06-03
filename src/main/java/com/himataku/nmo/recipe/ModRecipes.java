package com.himataku.nmo.recipe;

import com.himataku.nmo.Main;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Main.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, Main.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CrusherRecipes>> CRUSHER_SERIALIZER =
            SERIALIZERS.register("crusher", CrusherRecipes.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<CrusherRecipes>> CRUSHER_TYPE =
            TYPES.register("crusher", () -> new RecipeType<CrusherRecipes>() {
                @Override
                public String toString() {
                    return "crusher";
                }
            });
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MixerRecipes>> MIXER_SERIALIZER =
            SERIALIZERS.register("mixer", MixerRecipes.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<MixerRecipes>> MIXER_TYPE =
            TYPES.register("mixer", () -> new RecipeType<MixerRecipes>() {
                @Override
                public String toString() {
                    return "mixer";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}