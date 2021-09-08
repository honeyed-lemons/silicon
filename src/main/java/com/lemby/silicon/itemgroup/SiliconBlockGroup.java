package com.lemby.silicon.itemgroup;

import com.lemby.silicon.init.SiliconItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class SiliconBlockGroup extends ItemGroup {

    private Supplier<ItemStack> displayStack;

    public static final SiliconBlockGroup SILICON_BLOCK_GROUP = new SiliconBlockGroup("siliconblockgroup", () -> new ItemStack(SiliconItems.GEM_INSIGNIA.get()));

    private SiliconBlockGroup(String label, Supplier<ItemStack> displayStack) {
        super(label);
        this.displayStack = displayStack;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public ItemStack createIcon() { return displayStack.get(); }
    }
