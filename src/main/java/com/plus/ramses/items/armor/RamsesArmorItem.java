package com.plus.ramses.items.armor;

import com.plus.ramses.entity.RamsesMod;

import net.minecraft.item.ItemArmor;

public class RamsesArmorItem extends ItemArmor {

	public RamsesArmorItem(ArmorMaterial material, int armorType,
			String name) {
		super(material, 0, armorType);
        setUnlocalizedName(RamsesMod.MODID + "_" + name);
        setTextureName(RamsesMod.MODID + "_" + name);
	
	}

}
