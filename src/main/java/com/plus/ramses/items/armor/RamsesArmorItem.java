package com.plus.ramses.items.armor;

import com.plus.ramses.entity.RamsesMod;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class RamsesArmorItem extends ItemArmor {

	public RamsesArmorItem(ArmorMaterial material, int armorType,
			String name) {
		super(material, 0, armorType);
        setUnlocalizedName(RamsesMod.MODID + "_" + name);
        setTextureName(RamsesMod.MODID + ":" + name);
	
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		if (stack.getItem() == RamsesMod.ramsesHelmet
				|| stack.getItem() == RamsesMod.ramsesChestplate
				|| stack.getItem() == RamsesMod.ramsesBoots) {
			return RamsesMod.MODID + ":models/armor/ramsesarmor1.png";

		} else if (stack.getItem() == RamsesMod.ramsesLeggings) {
			return RamsesMod.MODID + ":models/armor/ramsesarmor2.png";

		} else {
			System.out.println("Invalid Item");
			return null;
		}
	}

}
