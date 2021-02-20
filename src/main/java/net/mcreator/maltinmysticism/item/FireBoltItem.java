
package net.mcreator.maltinmysticism.item;

@MaltinmysticismModElements.ModElement.Tag
public class FireBoltItem extends MaltinmysticismModElements.ModElement {

	@ObjectHolder("maltinmysticism:fire_bolt")
	public static final Item block = null;

	public FireBoltItem(MaltinmysticismModElements instance) {
		super(instance, 120);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("fire_bolt");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
