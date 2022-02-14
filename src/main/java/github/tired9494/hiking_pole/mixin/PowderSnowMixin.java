package github.tired9494.hiking_pole.mixin;

import github.tired9494.hiking_pole.HikingPole;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PowderSnowBlock.class)
public abstract class PowderSnowMixin {

    @Inject(at = @At("RETURN"),method = "canWalkOnPowderSnow",cancellable = true)
    private static void checkStick(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof LivingEntity) {
            if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.MAINHAND).isOf(HikingPole.HIKING_POLE) || ((LivingEntity) entity).getEquippedStack(EquipmentSlot.OFFHAND).isOf(HikingPole.HIKING_POLE))
            {
                cir.setReturnValue(true);
            }
        }
    }
}
