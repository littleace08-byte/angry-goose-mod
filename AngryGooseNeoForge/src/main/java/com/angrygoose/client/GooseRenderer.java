package com.angrygoose.client;

import com.angrygoose.AngryGooseMod;
import com.angrygoose.entity.GooseEntity;
import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * Renders the goose using the chicken model with a custom texture.
 */
public class GooseRenderer extends MobRenderer<GooseEntity, ChickenModel<GooseEntity>> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(AngryGooseMod.MOD_ID, "textures/entity/goose.png");

    public GooseRenderer(EntityRendererProvider.Context context) {
        super(context, new ChickenModel<>(context.bakeLayer(ModelLayers.CHICKEN)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(GooseEntity entity) {
        return TEXTURE;
    }
}
