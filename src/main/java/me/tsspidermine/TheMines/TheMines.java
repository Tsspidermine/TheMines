package me.tsspidermine.TheMines;

import draylar.magna.item.HammerItem;
import me.tsspidermine.TheMines.enchantments.AutosmeltEnchantment;
import me.tsspidermine.TheMines.enchantments.CrunchEnchantment;
import me.tsspidermine.TheMines.item.CrusherItem;
import me.tsspidermine.TheMines.materials.DiamondWorldShakerMaterial;
import me.tsspidermine.TheMines.materials.IronWorldShakerMaterial;
import me.tsspidermine.TheMines.materials.StoneWorldShakerMaterial;
import me.tsspidermine.TheMines.materials.WoodWorldShakerMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TheMines implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("themines");

	public static final ItemGroup TOOLS_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("themines", "the_mines_tools_group"),
			() -> new ItemStack(Items.DIAMOND_PICKAXE));

//	public static final Item FABRIC_ITEM = new FabricItem(new FabricItemSettings().group(TheMines.TOOLS_ITEM_GROUP).maxCount(1));
	public static final HammerItem WOODEN_WORLD_SHAKER = Registry.register(
			Registry.ITEM,
			new Identifier("themines", "wooden_world_shaker"),
			new HammerItem(
				WoodWorldShakerMaterial.INSTANCE,
				1,
				-2.8F,
				new FabricItemSettings().group(TheMines.TOOLS_ITEM_GROUP).maxCount(1)
			)
	);
	public static final HammerItem STONE_WORLD_SHAKER = Registry.register(
			Registry.ITEM,
			new Identifier("themines", "stone_world_shaker"),
			new HammerItem(
					StoneWorldShakerMaterial.INSTANCE,
					2,
					-2.8F,
					new FabricItemSettings().group(TheMines.TOOLS_ITEM_GROUP).maxCount(1)
			)
	);
	public static final CrusherItem IRON_WORLD_SHAKER = Registry.register(
			Registry.ITEM,
			new Identifier("themines", "iron_world_shaker"),
			new CrusherItem(
					IronWorldShakerMaterial.INSTANCE,
					3,
					-2.8F,
					new FabricItemSettings().group(TheMines.TOOLS_ITEM_GROUP).maxCount(1),
					1
			)
	);
	public static final CrusherItem DIAMOND_WORLD_SHAKER = Registry.register(
			Registry.ITEM,
			new Identifier("themines", "diamond_world_shaker"),
			new CrusherItem(
					DiamondWorldShakerMaterial.INSTANCE,
					3,
					-2.8F,
					new FabricItemSettings().group(TheMines.TOOLS_ITEM_GROUP).maxCount(1),
					1
			)
	);

	public static final CrusherItem MOLTEN_PICKAXE = Registry.register(
			Registry.ITEM,
			new Identifier("themines", "molten_pickaxe"),
			new CrusherItem(
					DiamondWorldShakerMaterial.INSTANCE,
					3,
					-2.8F,
					new FabricItemSettings().group(TheMines.TOOLS_ITEM_GROUP).maxCount(1),
					0
			)
	);

	public static Enchantment AUTOSMELTENCHANTMENT = Registry.register(
		Registry.ENCHANTMENT,
		new Identifier("themines", "autosmelt"),
		new AutosmeltEnchantment()
	);

	public static Enchantment CRUNCHENCHANTMENT = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("themines", "crunch"),
			new CrunchEnchantment()
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Loading TheMines");

//		Registry.register(Registry.ITEM, new Identifier("themines", "fabric_item"), FABRIC_ITEM);
	}
}
