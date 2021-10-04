package me.tsspidermine.TheMines.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class StoneWorldShakerMaterial implements ToolMaterial {

    public static final StoneWorldShakerMaterial INSTANCE = new StoneWorldShakerMaterial();

    @Override
    public int getDurability(){ return 850; }

    @Override
    public float getMiningSpeedMultiplier(){ return 2.0F; }

    @Override
    public float getAttackDamage(){ return 2.0F; }

    @Override
    public int getMiningLevel(){ return 2; }

    @Override
    public int getEnchantability(){ return 7; }

    @Override
    public Ingredient getRepairIngredient(){ return Ingredient.ofItems(Items.COBBLESTONE); }
}
