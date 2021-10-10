package me.tsspidermine.TheMines.item;

import draylar.magna.api.BlockProcessor;
import draylar.magna.item.HammerItem;
import me.tsspidermine.TheMines.TheMines;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class CrusherItem extends HammerItem {

    // This is set in the main class, ignore this value
    private int breakRadius = 1;
    private int defaultBreakRadius;


    public CrusherItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int breakRadius) {
        super(toolMaterial, attackDamage, attackSpeed, settings, breakRadius);
        this.breakRadius = breakRadius;
        defaultBreakRadius = breakRadius;
    }

    public CrusherItem(ToolMaterial toolMaterial, int material, float attackDamage, Settings attackSpeed){
        super(toolMaterial, material, attackDamage, attackSpeed);
    }

    @Override
    public int getRadius(ItemStack stack) { return breakRadius;}

    @Override
    public boolean playBreakEffects() { return false;}

    @Override
    public BlockProcessor getProcessor(World world, PlayerEntity player, BlockPos pos, ItemStack heldStack) {
        if(EnchantmentHelper.getLevel(TheMines.AUTOSMELTENCHANTMENT, heldStack) > 0 || heldStack.isOf(TheMines.MOLTEN_PICKAXE)){
            return (tool, input) -> {
                Optional<SmeltingRecipe> cookedItem = world.getRecipeManager().getFirstMatch(
                        RecipeType.SMELTING,
                        new SimpleInventory(input),
                        world
                );

                if(cookedItem.isPresent()) {
                    return cookedItem.get().getOutput().copy();
                }

                return input;
            };
        } else {
            return super.getProcessor(world, player, pos, heldStack);
        }
    }

    @Override
    public boolean renderOutline(World world, BlockHitResult ray, PlayerEntity player, ItemStack stack){
        if(player == null)
            return true;

        if(EnchantmentHelper.getLevel(TheMines.CRUNCHENCHANTMENT, player.getMainHandStack()) > 0){
            breakRadius = EnchantmentHelper.getLevel(TheMines.CRUNCHENCHANTMENT, player.getMainHandStack()) + 1;
        } else{
            breakRadius = defaultBreakRadius;
        }

        return true;
    }
}
