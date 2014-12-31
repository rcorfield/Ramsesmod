package com.plus.ramses.entity.pets.eggs;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Egg extends EntityThrowable {
	protected String entityToSpawnName = "";
	protected EntityAnimal entityToSpawn;
	protected int colorBase;
	protected int colorSpots;

	public Egg(World par1World) {
		super(par1World);
	}

	public Egg(World par1World, EntityLivingBase par2EntityLivingBase,
			int parColorBase, int parColorSpots) {
		super(par1World, par2EntityLivingBase);
		colorBase = parColorBase;
		colorSpots = parColorSpots;
	}

	public void setEntityToSpawn(String parEntityToSpawnName) {
		entityToSpawnName = parEntityToSpawnName;
	}

	public String getEntityToSpawn() {
		return entityToSpawnName;
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null) {
			par1MovingObjectPosition.entityHit.attackEntityFrom(
					DamageSource.causeThrownDamage(this, getThrower()), 0.0F);
		}

		// never spawn entity on client side
		if (!worldObj.isRemote) {
			entityToSpawn = (EntityAnimal) EntityList.createEntityByName(
					entityToSpawnName, worldObj);
			entityToSpawn.setGrowingAge(-20000);
			entityToSpawn.setLocationAndAngles(posX, posY, posZ, rotationYaw,
					0.0F);
			worldObj.spawnEntityInWorld(entityToSpawn);
		}

		for (int j = 0; j < 10; ++j) {
			worldObj.spawnParticle("ramsesSmoke", posX, posY, posZ, 0.0D,
					0.0D, 0.0D);
		}

		if (!worldObj.isRemote) {
			setDead();
		}
	}

	public int getColorBase() {
		return colorBase;
	}

	public int getColorSpots() {
		return colorSpots;
	}
}
