
package net.mcreator.maltinmysticism.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.maltinmysticism.procedures.HomunculusOnEntityTickUpdateProcedure;
import net.mcreator.maltinmysticism.procedures.ConditionSNotittingProcedure;
import net.mcreator.maltinmysticism.procedures.ClickOnHumonProcedure;
import net.mcreator.maltinmysticism.MaltinmysticismModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@MaltinmysticismModElements.ModElement.Tag
public class HomunculusEntity extends MaltinmysticismModElements.ModElement {
	public static EntityType entity = null;
	public HomunculusEntity(MaltinmysticismModElements instance) {
		super(instance, 69);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("homunculus")
						.setRegistryName("homunculus");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13408768, -10079488, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("homunculus_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("maltinmysticism:textures/humunculustexture.png");
				}
			};
		});
	}
	public static class CustomEntity extends TameableEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 1;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1, (float) 10, (float) 2, false) {
				@Override
				public boolean shouldExecute() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldExecute() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}

				@Override
				public boolean shouldContinueExecuting() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldContinueExecuting() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}
			});
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
				@Override
				public boolean shouldExecute() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldExecute() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}

				@Override
				public boolean shouldContinueExecuting() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldContinueExecuting() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}
			});
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1) {
				@Override
				public boolean shouldExecute() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldExecute() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}

				@Override
				public boolean shouldContinueExecuting() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldContinueExecuting() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}
			});
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this) {
				@Override
				public boolean shouldExecute() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldExecute() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}

				@Override
				public boolean shouldContinueExecuting() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldContinueExecuting() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}
			});
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this) {
				@Override
				public boolean shouldExecute() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldExecute() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}

				@Override
				public boolean shouldContinueExecuting() {
					double x = CustomEntity.this.getPosX();
					double y = CustomEntity.this.getPosY();
					double z = CustomEntity.this.getPosZ();
					Entity entity = CustomEntity.this;
					return super.shouldContinueExecuting() && ConditionSNotittingProcedure.executeProcedure(ImmutableMap.of("entity", entity));
				}
			});
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			Item item = itemstack.getItem();
			if (itemstack.getItem() instanceof SpawnEggItem) {
				retval = super.processInteract(sourceentity, hand);
			} else if (this.world.isRemote) {
				retval = this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack);
			} else {
				if (this.isTamed()) {
					if (this.isOwner(sourceentity)) {
						if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal((float) item.getFood().getHealing());
							retval = true;
						} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.consumeItemFromStack(sourceentity, itemstack);
							this.heal(4);
							retval = true;
						} else {
							retval = super.processInteract(sourceentity, hand);
						}
					}
				} else if (this.isBreedingItem(itemstack)) {
					this.consumeItemFromStack(sourceentity, itemstack);
					if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
						this.setTamedBy(sourceentity);
						this.world.setEntityState(this, (byte) 7);
					} else {
						this.world.setEntityState(this, (byte) 6);
					}
					this.enablePersistence();
					retval = true;
				} else {
					retval = super.processInteract(sourceentity, hand);
					if (retval)
						this.enablePersistence();
				}
			}
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("sourceentity", sourceentity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ClickOnHumonProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				HomunculusOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public AgeableEntity createChild(AgeableEntity ageable) {
			CustomEntity retval = (CustomEntity) entity.create(this.world);
			retval.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(retval)), SpawnReason.BREEDING,
					(ILivingEntityData) null, (CompoundNBT) null);
			return retval;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			return false;
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer TorsoGroup;
		private final ModelRenderer Head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer ArmRight;
		private final ModelRenderer cube_r4;
		private final ModelRenderer ArmRight2;
		private final ModelRenderer cube_r5;
		private final ModelRenderer FootOne;
		private final ModelRenderer FootOne2;
		public Modelcustom_model() {
			textureWidth = 64;
			textureHeight = 64;
			TorsoGroup = new ModelRenderer(this);
			TorsoGroup.setRotationPoint(-0.025F, 13.25F, -0.25F);
			TorsoGroup.setTextureOffset(24, 0).addBox(-2.475F, -3.25F, -1.75F, 5.0F, 9.0F, 3.0F, 0.0F, false);
			TorsoGroup.setTextureOffset(39, 8).addBox(2.525F, -3.25F, -1.75F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			TorsoGroup.setTextureOffset(36, 27).addBox(-4.475F, -3.25F, -1.75F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			TorsoGroup.setTextureOffset(20, 20).addBox(-3.075F, 0.75F, -2.25F, 6.0F, 7.0F, 4.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 9.8125F, -0.1375F);
			Head.setTextureOffset(0, 0).addBox(-3.0F, -5.8125F, -3.3625F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			Head.setTextureOffset(0, 21).addBox(-3.5F, -6.3125F, 2.6375F, 7.0F, 11.0F, 1.0F, 0.0F, false);
			Head.setTextureOffset(0, 12).addBox(-2.5F, -7.3125F, -4.3625F, 5.0F, 2.0F, 7.0F, 0.0F, false);
			Head.setTextureOffset(23, 31).addBox(-3.5F, -6.3125F, -2.3625F, 1.0F, 7.0F, 5.0F, 0.0F, false);
			Head.setTextureOffset(11, 28).addBox(2.5F, -6.3125F, -2.3625F, 1.0F, 7.0F, 5.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-3.0F, -4.3125F, -3.1625F);
			Head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, 0.3054F);
			cube_r1.setTextureOffset(0, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(3.0F, -4.3125F, -3.1625F);
			Head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -0.3054F);
			cube_r2.setTextureOffset(0, 12).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 8.1875F, 4.1375F);
			Head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.2182F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(24, 12).addBox(-3.5F, -3.5F, -0.5F, 7.0F, 7.0F, 1.0F, 0.0F, false);
			ArmRight = new ModelRenderer(this);
			ArmRight.setRotationPoint(3.3F, 10.9333F, 0.0F);
			ArmRight.setTextureOffset(33, 42).addBox(0.1F, 3.0667F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			ArmRight.setTextureOffset(13, 40).addBox(-0.3F, 5.0667F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.7F, 1.3667F, 0.0F);
			ArmRight.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, -0.2182F);
			cube_r4.setTextureOffset(0, 42).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			ArmRight2 = new ModelRenderer(this);
			ArmRight2.setRotationPoint(-3.3F, 10.9333F, 0.0F);
			ArmRight2.setTextureOffset(40, 22).addBox(-2.1F, 3.0667F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			ArmRight2.setTextureOffset(37, 17).addBox(-2.7F, 5.0667F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-0.7F, 1.3667F, 0.0F);
			ArmRight2.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, 0.2182F);
			cube_r5.setTextureOffset(30, 31).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			FootOne = new ModelRenderer(this);
			FootOne.setRotationPoint(2.0F, 19.25F, 0.0F);
			FootOne.setTextureOffset(35, 35).addBox(-1.5F, 2.75F, -3.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
			FootOne.setTextureOffset(40, 4).addBox(-1.5F, 1.75F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			FootOne2 = new ModelRenderer(this);
			FootOne2.setRotationPoint(-2.0F, 19.25F, 0.0F);
			FootOne2.setTextureOffset(0, 35).addBox(-1.5F, 2.75F, -3.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
			FootOne2.setTextureOffset(40, 0).addBox(-1.5F, 1.75F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			TorsoGroup.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			ArmRight.render(matrixStack, buffer, packedLight, packedOverlay);
			ArmRight2.render(matrixStack, buffer, packedLight, packedOverlay);
			FootOne.render(matrixStack, buffer, packedLight, packedOverlay);
			FootOne2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.ArmRight2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.FootOne2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.ArmRight.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.FootOne.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
