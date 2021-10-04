package me.tsspidermine.TheMines.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DiamondWorldShakerMaterial implements ToolMaterial {

    public static final DiamondWorldShakerMaterial INSTANCE = new DiamondWorldShakerMaterial();

    @Override
    public int getDurability(){ return 1820; }

    @Override
    public float getMiningSpeedMultiplier(){ return 4.0F; }

    @Override
    public float getAttackDamage(){ return 4.0F; }

    @Override
    public int getMiningLevel(){ return 4; }

    @Override
    public int getEnchantability(){ return 13; }

    @Override
    public Ingredient getRepairIngredient(){ return Ingredient.ofItems(Items.DIAMOND); }
}
