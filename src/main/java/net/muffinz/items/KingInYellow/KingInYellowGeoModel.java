package net.muffinz.items.KingInYellow;

import net.minecraft.util.Identifier;
import net.muffinz.items.KingInYellow.KingInYellow;

public class KingInYellowGeoModel extends AnimatedGeoModel<KingInYellow> {
    private static final Identifier modelPath = new Identifier(GeckoLib.MOD_ID, "geo/jack.geo.json");
    private static final Identifier texturePath = new Identifier(GeckoLib.MOD_ID, "textures/item/jack.png");
    private static final Identifier animationsPath = new Identifier(GeckoLib.MOD_ID, "animations/jackinthebox.animation.json");

    @Override
    public Identifier getModelResource(KingInYellow animatable) {
        return modelPath;
    }

    @Override
    public Identifier getTextureResource(KingInYellow animatable) {
        return texturePath;
    }

    @Override
    public Identifier getAnimationResource(KingInYellow animatable) {
        return animationsPath;
    }
}