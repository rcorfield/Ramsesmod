package com.plus.ramses.entity;

import com.plus.ramses.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

@Mod(modid="ramses", name="Ramses", version="1.0")
public class Ramses extends EntityAnimal implements IEntityOwnable {
	
	@Instance(value = "ramses")
	public static Ramses instance;
	
    @SidedProxy(clientSide="com.plus.ramses.proxy.ClientProxy", serverSide="com.plus.ramses.proxy.CommonProxy")
    public static CommonProxy proxy;

	public Ramses(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}

    @EventHandler // used in 1.6.2
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
    
    @EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
    }
    
    @EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }

	@Override
	public String getOwnerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable var1) {
		// TODO Auto-generated method stub
		return null;
	}

}
