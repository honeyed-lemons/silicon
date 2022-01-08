package com.lemby.silicon.init;

import com.gempire.systems.injection.Crux;
import com.gempire.systems.injection.GemConditions;
import com.gempire.util.CruxType;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;

public class SiliconCruxes {

    public static GemConditions SUGAR_CONDITIONS() {
        ArrayList<Crux> gemCruxes = new ArrayList<>();
        float gemTemperatureMin = 0f;
        float gemTemperatureMax = 2f;
        Item primer = Items.SUGAR;
        String essences = "white";
        gemCruxes.add(new Crux(Blocks.SUGAR_CANE.getDefaultState(), 9, CruxType.ORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.SAND.getDefaultState(), 2, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.STONE.getDefaultState(), 2, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.GRANITE.getDefaultState(), 2, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.DIORITE.getDefaultState(), 2, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        return new GemConditions(gemCruxes, essences, primer, 1, gemTemperatureMin, gemTemperatureMax);
    }
    public static final GemConditions AZURITE_CONDITIONS(){
        ArrayList<Crux> gemCruxes = new ArrayList<>();
        float gemTemperatureMin = 0.5f;
        float gemTemperatureMax = 0.8f;
        Item primer = Items.WATER_BUCKET;
        String essences = "blue";
        gemCruxes.add(new Crux(Blocks.STONE.getDefaultState(), 2, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.GRANITE.getDefaultState(), 2, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.DIORITE.getDefaultState(), 2, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.PRISMARINE.getDefaultState(), 3, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.LAPIS_ORE.getDefaultState(), 3, CruxType.MINERAL, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.DARK_PRISMARINE.getDefaultState(), 3, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.LAPIS_BLOCK.getDefaultState(), 4, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        return new GemConditions(gemCruxes, essences, primer, 2, gemTemperatureMin, gemTemperatureMax);
    }
}
