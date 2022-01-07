package com.lemby.silicon.itemgroup;

import com.lemby.silicon.init.SiliconBlocks;
import com.lemby.silicon.init.SiliconItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class SiliconItemGroup extends ItemGroup {

    private Supplier<ItemStack> displayStack;

    public static final SiliconItemGroup SILICON_ITEM_GROUP = new SiliconItemGroup("siliconitemgroup", () -> new ItemStack(SiliconItems.CRYSTAL_APPLE.get()));
    public static final SiliconItemGroup SILICON_BLOCK_GROUP = new SiliconItemGroup("siliconblockgroup", () -> new ItemStack(SiliconBlocks.GEM_INSIGNIA.get()));
    public static final SiliconItemGroup SILICON_GEM_GROUP = new SiliconItemGroup("silicongemgroup", () -> new ItemStack(SiliconItems.COAL_GEM.get()));

    private SiliconItemGroup(String label, Supplier<ItemStack> displayStack) {
        super(label);
        this.displayStack = displayStack;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public ItemStack createIcon() { return displayStack.get(); }
    }
