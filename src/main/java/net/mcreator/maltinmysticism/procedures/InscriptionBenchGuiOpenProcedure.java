package net.mcreator.maltinmysticism.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.Map;
import java.util.HashMap;

@MaltinmysticismModElements.ModElement.Tag
public class InscriptionBenchGuiOpenProcedure extends MaltinmysticismModElements.ModElement {
	public InscriptionBenchGuiOpenProcedure(MaltinmysticismModElements instance) {
		super(instance, 103);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure InscriptionBenchGuiOpen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			InscriptionBenchRecipesProcedure.executeProcedure($_dependencies);
		}
	}
}
