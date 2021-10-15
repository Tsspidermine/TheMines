package me.tsspidermine.TheMines.mixin;

import me.tsspidermine.TheMines.TheMines;
import me.tsspidermine.TheMines.item.CrusherItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(MinecraftClient.class)
public abstract class CrunchEnchantmentMixin {


    @Shadow @Nullable public ClientPlayerEntity player;

    @Inject(method = "tick", at = @At("RETURN"), cancellable = true)
    private void modifyRadius(CallbackInfo ci){

//        if(EnchantmentHelper.getLevel(TheMines.CRUNCHENCHANTMENT, stack) > 0){
//            CrusherItem.breakRadius = EnchantmentHelper.getLevel(TheMines.CRUNCHENCHANTMENT, stack) + 1;
//        } else{
//            CrusherItem.breakRadius = CrusherItem.defaultBreakRadius;
//        }

        ItemStack heldStack;
//
//        return EnchantmentHelper.getLevel()
        if (this.player != null){
            heldStack = this.player.getMainHandStack();
            if (heldStack != null) {
                CrusherItem.breakRadius = EnchantmentHelper.getLevel(TheMines.CRUNCHENCHANTMENT, heldStack) + 1;
            }
        }
    }
}
