package com.angrygoose;

import com.angrygoose.entity.ModEntities;
import com.angrygoose.event.ModEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;

@Mod(AngryGooseMod.MOD_ID)
public class AngryGooseMod {
    public static final String MOD_ID = "angrygoose";

    public AngryGooseMod(IEventBus modEventBus, ModContainer modContainer) {
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModEntities.ITEMS.register(modEventBus);
        modEventBus.addListener(ModEntities::registerAttributes);

        NeoForge.EVENT_BUS.register(ModEvents.class);
    }
}
