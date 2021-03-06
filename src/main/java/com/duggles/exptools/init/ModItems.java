package com.duggles.exptools.init;

import com.duggles.exptools.item.*;
import com.duggles.exptools.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import static cpw.mods.fml.common.registry.GameRegistry.registerItem;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems
{
    public static Item.ToolMaterial experienceMaterial = EnumHelper.addToolMaterial("experienceMaterial", 3, 1000, 10.0F, 3.0F, 22);

    public static final item_exptools xpEnderPearl  = new itemXpEnderP();
    public static final item_exptools xpIngot       = new itemXpIngot();
    public static final item_exptools xpCrystal     = new itemXpCrystal();
    public static final item_exptools xpCrystalT2   = new itemXpCrystalT2();
    public static final item_exptools xpCrystalT3   = new itemXpCrystalT3();
    public static final item_exptools xpWand        = new itemXpWand();
//  public static final item_exptools magicMirror   = new itemMagicMirror();

    public static ItemPickaxe   xpPickaxe;
    public static ItemAxe       xpAxe;
    public static ItemSpade     xpShovel;
    public static ItemSword     xpSword;
    public static ItemHoe       xpHoe;

    public static void init()
    {
        registerItem(xpIngot,     "xpIngot");
        registerItem(xpEnderPearl,"xpEnderPearl");
        registerItem(xpCrystal,   "xpCrystal");
        registerItem(xpCrystalT2, "xpCrystalT2");
        registerItem(xpCrystalT3, "xpCrystalT3");
        registerItem(xpWand,      "xpWand");
//      registerItem(magicMirror, "magicMirror");

        registerItem(xpPickaxe = new itemXpPickaxe("xpPickaxe",experienceMaterial), "xpPickaxe");
        registerItem(xpAxe     = new itemXpAxe    ("xpAxe",    experienceMaterial), "xpAxe");
        registerItem(xpShovel  = new itemXpShovel ("xpShovel", experienceMaterial), "xpShovel");
        registerItem(xpSword   = new itemXpSword  ("xpSword",  experienceMaterial), "xpSword");
        registerItem(xpHoe     = new itemXpHoe    ("xpHoe",    experienceMaterial), "xpHoe");
    }

}
