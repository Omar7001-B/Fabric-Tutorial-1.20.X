package net.omar.tutorial;

import net.fabricmc.api.ClientModInitializer;
// Comment Added

public class TutorialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Tutorial.LOGGER.info("Hello Fabric world! (client)");
    }
}
