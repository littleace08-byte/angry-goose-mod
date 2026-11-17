package com.angrygoose.event;

import com.angrygoose.entity.GooseEntity;
import com.angrygoose.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

/**
 * When a chicken is hurt by a player, spawn an angry goose nearby.
 */
public class ModEvents {

    @SubscribeEvent
    public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        if (!(event.getEntity() instanceof Chicken chicken)) {
            return;
        }
        if (chicken.level().isClientSide()) {
            return;
        }
        if (!(event.getSource().getEntity() instanceof Player)) {
            return;
        }

        ServerLevel level = (ServerLevel) chicken.level();
        GooseEntity goose = ModEntities.GOOSE.get().create(level);
        if (goose == null) {
            return;
        }

        goose.setPos(
                chicken.getX() + (level.random.nextDouble() - 0.5) * 1.5,
                chicken.getY(),
                chicken.getZ() + (level.random.nextDouble() - 0.5) * 1.5
        );
        goose.setYRot(level.random.nextFloat() * 360.0F);

        // Immediately target the player who hit the chicken
        if (event.getSource().getEntity() instanceof Player player) {
            goose.setTarget(player);
        }

        level.addFreshEntity(goose);
    }
}
