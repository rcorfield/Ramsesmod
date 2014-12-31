package com.plus.ramses.entity;


import com.plus.ramses.entity.pets.Ramses;

import com.plus.ramses.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.World;




@Mod(modid=RamsesMod.MODID, name=RamsesMod.MODNAME, version=RamsesMod.MODVERSION)
public class RamsesMod { 
	
	
	public static final String MODID = "ramsesmod";
	public static final String MODNAME = "RamsesMod";
	public static final String MODVERSION = "1.0";


	Block customBlock;

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
            proxy.registerRenderers();
            proxy.registerModEntities();
    }
    
    private void loadObjects() {

       ramses = new Ramses(null);	
	}

	@EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }

//	@Override
//	public String getOwnerName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Entity getOwner() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public EntityAgeable createChild(EntityAgeable var1) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
