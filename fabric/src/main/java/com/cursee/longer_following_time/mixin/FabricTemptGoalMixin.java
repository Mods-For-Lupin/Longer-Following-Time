package com.cursee.longer_following_time.mixin;

import com.cursee.longer_following_time.ConfiguredValues;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.crafting.Ingredient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TemptGoal.class)
public class FabricTemptGoalMixin {

  @Unique
  float longer_following_time$addedSeconds = 0.0f;

  @Shadow
  @Final
  private Ingredient items;

  @Inject(at = @At("TAIL"), method = "shouldFollow", cancellable = true)
  private void longer_following_time$shouldFollow(LivingEntity entity,
      CallbackInfoReturnable<Boolean> cir) {

    // original return statement
    // return this.items.test(entity.getMainHandItem()) || this.items.test(entity.getOffhandItem());

    if (longer_following_time$addedSeconds > 0 && longer_following_time$addedSeconds != 1) {
      longer_following_time$addedSeconds--;
    }

    if (items.test(entity.getMainHandItem())
        || items.test(entity.getOffhandItem()) && longer_following_time$addedSeconds == 0) {
      longer_following_time$addedSeconds = ((int) ConfiguredValues.addedSeconds) * 20;
    }

    if (longer_following_time$addedSeconds == 1) {
      longer_following_time$addedSeconds = 0;
    }

    cir.setReturnValue(
        longer_following_time$addedSeconds > 0 || items.test(entity.getMainHandItem())
            || items.test(entity.getOffhandItem()));
  }
}
