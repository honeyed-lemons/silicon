package com.lemby.silicon.itemgroup;

import com.lemby.silicon.init.SiliconItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class SiliconItemGroup extends ItemGroup {

    private Supplier<ItemStack> displayStack;

    public static final SiliconItemGroup SILICON_ITEM_GROUP = new SiliconItemGroup("siliconitemgroup", () -> new ItemStack(SiliconItems.GEM_INSIGNIA.get()));

    private SiliconItemGroup(String label, Supplier<ItemStack> displayStack) {
        super(label);
        this.displayStack = displayStack;
    }

    @Override
    public ItemStack createIcon() { return displayStack.get(); }
    }
