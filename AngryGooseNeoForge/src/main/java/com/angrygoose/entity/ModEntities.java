package com.angrygoose.entity;

import com.angrygoose.AngryGooseMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister.Entities ENTITY_TYPES =
            DeferredRegister.createEntities(AngryGooseMod.MOD_ID);

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(AngryGooseMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<GooseEntity>> GOOSE =
            ENTITY_TYPES.registerEntityType(
                    "goose",
                    GooseEntity::new,
                    MobCategory.MONSTER,
                    builder -> builder
                            .sized(0.7f, 0.9f)
                            .clientTrackingRange(10)
                            .updateInterval(3)
            );

    public static final DeferredHolder<Item, Item> GOOSE_SPAWN_EGG = ITEMS.register(
            "goose_spawn_egg",
            registryName -> new DeferredSpawnEggItem(
                    GOOSE,
                    0xF5F5F5,
                    0xFF8C00,
                    new Item.Properties()
            )
    );

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(GOOSE.get(), GooseEntity.createAttributes().build());
    }
}
