package com.lemby.silicon.init;

import com.gempire.systems.injection.Crux;
import com.gempire.systems.injection.GemConditions;
import com.gempire.util.CruxType;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;

public class SiliconCruxes {

    public static GemConditions SUGAR_CONDITIONS(){
        ArrayList<Crux> gemCruxes = new ArrayList<>();
        float gemTemperatureMin = 0f;
        float gemTemperatureMax = 2f;
        Item primer = Items.SUGAR;
        String essences = "white";
        gemCruxes.add(new Crux(Blocks.SUGAR_CANE.getDefaultState(), 9, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        gemCruxes.add(new Crux(Blocks.SAND.getDefaultState(), 1, CruxType.INORGANIC, gemTemperatureMin, gemTemperatureMax));
        return new GemConditions(gemCruxes, essences, primer, 1, gemTemperatureMin, gemTemperatureMax);
    }
}