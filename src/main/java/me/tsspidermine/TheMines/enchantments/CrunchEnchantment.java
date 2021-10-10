package me.tsspidermine.TheMines.enchantments;

import me.tsspidermine.TheMines.TheMines;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class CrunchEnchantment extends Enchantment {

    public CrunchEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {return 15; }

    @Override
    public int getMaxLevel() { return 2; }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !other.equals(TheMines.AUTOSMELTENCHANTMENT);

    }
}
