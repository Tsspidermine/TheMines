package me.tsspidermine.TheMines.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class IronWorldShakerMaterial implements ToolMaterial {

    public static final IronWorldShakerMaterial INSTANCE = new IronWorldShakerMaterial();

    @Override
    public int getDurability(){ return 1250; }

    @Override
    public float getMiningSpeedMultiplier(){ return 3.0F; }

    @Override
    public float getAttackDamage(){ return 3.0F; }

    @Override
    public int getMiningLevel(){ return 3; }

    @Override
    public int getEnchantability(){ return 8; }

    @Override
    public Ingredient getRepairIngredient(){ return Ingredient.ofItems(Items.IRON_BLOCK); }
}
