package net.mcreator.maltinmysticism.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.Map;

@MaltinmysticismModElements.ModElement.Tag
public class InscriptionTabletEffectsProcedure extends MaltinmysticismModElements.ModElement {
	public InscriptionTabletEffectsProcedure(MaltinmysticismModElements instance) {
		super(instance, 105);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure InscriptionTabletEffects!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure InscriptionTabletEffects!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure InscriptionTabletEffects!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure InscriptionTabletEffects!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.BUBBLE, x, y, z, (int) 20, 0.2, 0.2, 0.2, 1);
		}
	}
}
