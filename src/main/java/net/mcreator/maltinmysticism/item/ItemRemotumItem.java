
package net.mcreator.maltinmysticism.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.maltinmysticism.itemgroup.MaltinAlchemyItemGroup;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

@MaltinmysticismModElements.ModElement.Tag
public class ItemRemotumItem extends MaltinmysticismModElements.ModElement {
	@ObjectHolder("maltinmysticism:item_remotum")
	public static final Item block = null;
	public ItemRemotumItem(MaltinmysticismModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MaltinAlchemyItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
			setRegistryName("item_remotum");
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
