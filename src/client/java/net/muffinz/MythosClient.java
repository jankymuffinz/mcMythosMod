package net.muffinz;

import net.fabricmc.api.ClientModInitializer;
import net.muffinz.items.KingInYellow.KingInYellowItemRenderer;

public class MythosClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        GeoItemRenderer.registerItemRenderer(Mythos.THE_KING_IN_YELLOW, new KingInYellowItemRenderer());
    }
}