package me.tsspidermine.TheMines.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class WoodWorldShakerMaterial implements ToolMaterial {

    public static final WoodWorldShakerMaterial INSTANCE = new WoodWorldShakerMaterial();

    @Override
    public int getDurability(){ return 500; }

    @Override
    public float getMiningSpeedMultiplier(){ return 1.25F; }

    @Override
    public float getAttackDamage(){ return 1.0F; }

    @Override
    public int getMiningLevel(){ return 1; }

    @Override
    public int getEnchantability(){ return 5; }

    @Override
    public Ingredient getRepairIngredient(){ return Ingredient.ofItems(Items.OAK_WOOD); }
}
