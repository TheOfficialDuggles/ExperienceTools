package com.duggles.exptools.creativetab;


import com.duggles.exptools.init.ModItems;
import com.duggles.exptools.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabExperienceTools
{
    public static final CreativeTabs ExperienceTools_TAB = new CreativeTabs(Reference.MODID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.xpEnderPearl;
        }
    };
}
