package net.mcreator.maltinmysticism.procedures;

@MaltinmysticismModElements.ModElement.Tag
public class InsFireTablet1EffectProcedure extends MaltinmysticismModElements.ModElement {

	public InsFireTablet1EffectProcedure(MaltinmysticismModElements instance) {
		super(instance, 119);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure InsFireTablet1Effect!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure InsFireTablet1Effect!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure InsFireTablet1Effect!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure InsFireTablet1Effect!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure InsFireTablet1Effect!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 15, 0.2, 0.2, 0.2, 1);
		}
		entity.setFire((int) 10);

	}

}
