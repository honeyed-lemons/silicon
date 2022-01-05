package com.lemby.silicon.itemgroup;

import com.lemby.silicon.init.SiliconItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class SiliconGemGroup extends ItemGroup {

    private Supplier<ItemStack> displayStack;

    public static final SiliconGemGroup SILICON_GEM_GROUP = new SiliconGemGroup("silicongemgroup", () -> new ItemStack(SiliconItems.SUGAR_GEM.get()));

    private SiliconGemGroup(String label, Supplier<ItemStack> displayStack) {
        super(label);
        this.displayStack = displayStack;
    }
    @SuppressWarnings("NullableProblems")
    @Override
    public ItemStack createIcon() { return displayStack.get(); }
    }
