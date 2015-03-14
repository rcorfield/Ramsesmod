package com.plus.ramses.entity;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import com.plus.ramses.entity.pets.Ramses;
import com.plus.ramses.items.armor.RamsesArmorItem;
import com.plus.ramses.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;




@Mod(modid=RamsesMod.MODID, name=RamsesMod.MODNAME, version=RamsesMod.MODVERSION)
public class RamsesMod { 
	
	
	public static final String MODID = "ramsesmod";
	public static final String MODNAME = "RamsesMod";
	public static final String MODVERSION = "1.0";


	Block customBlock;
	public static RamsesArmorItem ramsesHelmet;
	public static RamsesArmorItem ramsesChestplate;
	public static RamsesArmorItem ramsesLeggings;
	public static RamsesArmorItem ramsesBoots;

	ArmorMaterial ramsesArmor = EnumHelper.addArmorMaterial("ramsesarmor", 20, 
			new int[] { 5,  5, 5, 5 }, 10);

	
	public static Ramses ramses;

	
	@Instance(MODID)
	public static RamsesMod instance;
	
    @SidedProxy(clientSide="com.plus.ramses.proxy.ClientProxy", serverSide="com.plus.ramses.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler // used in 1.6.2
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
    
    @EventHandler // used in 1.6.2
    public void init(FMLInitializationEvent event) {

    	loadObjects();
    	loadArmor();
    	loadRecipes();
    	proxy.registerRenderers();
    	proxy.registerModEntities();
    	
    }


	private void loadArmor() {
		
    	ramsesHelmet = new RamsesArmorItem(ramsesArmor, 0, "RamsesHelmet");
    	ramsesChestplate = new RamsesArmorItem(ramsesArmor, 1, "RamsesChestplate");
    	ramsesLeggings = new RamsesArmorItem(ramsesArmor, 2, "RamsesLeggings");
    	ramsesBoots = new RamsesArmorItem(ramsesArmor, 3, "RamsesBoots");

        GameRegistry.registerItem(ramsesHelmet, "RamsesHelmet");
        GameRegistry.registerItem(ramsesChestplate, "RamsesChestplate");
        GameRegistry.registerItem(ramsesLeggings, "RamsesLeggings");
        GameRegistry.registerItem(ramsesBoots, "RamsesBoots");

	}
	
    
	private void loadRecipes() {
		// Create recipes for the Ramses Armor
		GameRegistry.addRecipe(new ItemStack(RamsesMod.ramsesHelmet),
				"XXX",
				"X X",
				"   ", 'X', Blocks.lapis_ore);

		GameRegistry.addRecipe(new ItemStack(RamsesMod.ramsesChestplate),
				"X X",
				"XXX",
				"XXX", 'X', Blocks.lapis_ore);

		GameRegistry.addRecipe(new ItemStack(RamsesMod.ramsesLeggings),
				"XXX",
				"X X",
				"X X", 'X', Blocks.lapis_ore);

		GameRegistry.addRecipe(new ItemStack(RamsesMod.ramsesBoots),
				"   ",
				"X X",
				"X X", 'X', Blocks.lapis_ore);
	}

	private void loadObjects() {

       ramses = new Ramses(null);	
	}

	@EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }

}
