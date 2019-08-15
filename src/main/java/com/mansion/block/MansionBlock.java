package com.mansion.block;

import com.mansion.core.MansionMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class MansionBlock extends Block {

	public MansionBlock(Properties properties) {
		super(properties);
		this.setRegistryName(MansionMod.MODID, "mansion_block");
	}
	
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		final int xOffset = 3, yFloor = -1, yHeight = 3, zStart = 0, zEnd = 6;
		
		for (int x = -xOffset; x <= xOffset; x++) {
			for (int y = yFloor; y <= yHeight; y++) {
				for (int z = zStart; z <= zEnd; z++) {
					if (Math.abs(x) == xOffset || z == zStart || z == zEnd || y == yFloor || y == yHeight) {
						if (x == 0 && (y == 0 || y == 1) && z == 0) {
							continue;
						}
						else if (y == 1 && Math.abs(x) == xOffset && z != zStart && z != zEnd) {
							worldIn.setBlockState(pos.add(x, y, z), Blocks.GLASS.getDefaultState());
						}
						else {
							worldIn.setBlockState(pos.add(x, y, z), Blocks.OAK_PLANKS.getDefaultState());
						}
					}
					else {
						worldIn.setBlockState(pos.add(x, y, z), Blocks.AIR.getDefaultState());
					}
				}
			}
		}
		
		return worldIn.setBlockState(pos, Blocks.OAK_DOOR.getDefaultState());
	}

}
