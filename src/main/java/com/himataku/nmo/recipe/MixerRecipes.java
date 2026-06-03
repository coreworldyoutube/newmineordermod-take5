package com.himataku.nmo.recipe;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record MixerRecipes(Ingredient inputItem1,Ingredient inputItem2, ItemStack output) implements Recipe<MixerRecipeinputer> {
    // inputItem & output ==> Read From JSON File!
    // MixerRecipeinputer --> INVENTORY of the Block Entity



    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem1);
        list.add(inputItem2);
        return list;
    }
//crush
@Override
public boolean matches(MixerRecipeinputer input, Level level) {
    if (level.isClientSide()) return false;

    return (inputItem1.test(input.input1()) && inputItem2.test(input.input2())) ||
            (inputItem1.test(input.input2()) && inputItem2.test(input.input1()));
}

    @Override
    public ItemStack assemble(MixerRecipeinputer mixerRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.MIXER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.MIXER_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<MixerRecipes> {
        public static final MapCodec<MixerRecipes> CODEC =
                RecordCodecBuilder.mapCodec(inst -> inst.group(
                        Ingredient.CODEC_NONEMPTY.fieldOf("ingredient1").forGetter(MixerRecipes::inputItem1),
                        Ingredient.CODEC_NONEMPTY.fieldOf("ingredient2").forGetter(MixerRecipes::inputItem2),
                        ItemStack.CODEC.fieldOf("result").forGetter(MixerRecipes::output)
                ).apply(inst, MixerRecipes::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, MixerRecipes> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, MixerRecipes::inputItem1,
                        Ingredient.CONTENTS_STREAM_CODEC, MixerRecipes::inputItem2,
                        ItemStack.STREAM_CODEC, MixerRecipes::output,
                        MixerRecipes::new
                );

        @Override
        public MapCodec<MixerRecipes> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, MixerRecipes> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
