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

public record CrusherRecipes(Ingredient inputItem, ItemStack output) implements Recipe<CrusherRecipeinputer> {
    // inputItem & output ==> Read From JSON File!
    // CrusherRecipeinputer --> INVENTORY of the Block Entity

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(CrusherRecipeinputer crusherRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(crusherRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(CrusherRecipeinputer crusherRecipeInput, HolderLookup.Provider provider) {
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
        return ModRecipes.CRUSHER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CRUSHER_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<CrusherRecipes> {
        public static final MapCodec<CrusherRecipes> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(CrusherRecipes::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CrusherRecipes::output)
        ).apply(inst, CrusherRecipes::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, CrusherRecipes> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, CrusherRecipes::inputItem,
                        ItemStack.STREAM_CODEC, CrusherRecipes::output,
                        CrusherRecipes::new);

        @Override
        public MapCodec<CrusherRecipes> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CrusherRecipes> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
