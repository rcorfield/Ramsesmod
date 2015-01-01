package com.plus.ramses.entity.pets;

import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.World;

public class Ramses extends EntityOcelot {

	public Ramses(World par1World) {
		super(par1World);
		this.setTamed(true);
	}

}
