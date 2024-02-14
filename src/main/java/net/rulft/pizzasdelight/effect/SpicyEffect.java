package net.rulft.pizzasdelight.effect;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class SpicyEffect extends MobEffect {
    protected SpicyEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        // This method is called for each tick while the effect is active
        if (!pLivingEntity.level.isClientSide() && pLivingEntity.getHealth() > 1) {
            pLivingEntity.setSecondsOnFire(1); // Set on fire for 1 second (adjust as needed)
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        // This method controls how often the effect tick method is called
        // In this example, it is called every 20 ticks (1 second)
        return pDuration % 320 == 0;
    }
}
