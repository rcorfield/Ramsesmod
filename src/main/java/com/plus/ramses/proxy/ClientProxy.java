package com.plus.ramses.proxy;

import net.minecraft.item.Item;

import com.plus.ramses.entity.RamsesMod;
import com.plus.ramses.entity.pets.Ramses;
import com.plus.ramses.entity.pets.eggs.RamsesEgg;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
	
	protected int modEntityID = -1;
        
        @Override
        public void registerRenderers() {
                // This is for rendering entities and so forth later on
        }
        
        
        @Override
        public void registerModEntities() {
        	registerModEntityWithEgg(Ramses.class, "Ramses", 0xE18519, 0x000000);
        }
        
        
        
//        public void registerModEntity(Class parEntityClass, String parEntityName)
//        {
//            EntityRegistry.registerModEntity(parEntityClass, parEntityName, ++modEntityID, 
//                  WildAnimals.instance, 80, 3, false);
//        }

        public void registerModEntityWithEgg(Class parEntityClass, String parEntityName, 
              int parEggColor, int parEggSpotsColor)
        {
            EntityRegistry.registerModEntity(parEntityClass, parEntityName, ++modEntityID, 
                  RamsesMod.instance, 80, 3, false);
            registerSpawnEgg(parEntityName, parEggColor, parEggSpotsColor);
        }

        // can't use vanilla spawn eggs with entities registered with modEntityID, so use 
        // custom eggs. Name passed must match entity name string
        public void registerSpawnEgg(String parSpawnName, int parEggColor, int parEggSpotsColor)
        {
            Item ramsesEgg = new RamsesEgg(parSpawnName, parEggColor, 
                  parEggSpotsColor).setUnlocalizedName("spawn_egg_"+parSpawnName.toLowerCase())
                  .setTextureName("ramsesmod:spawn_egg");
            
            GameRegistry.registerItem(ramsesEgg, "spawnEgg"+parSpawnName);
        }
}