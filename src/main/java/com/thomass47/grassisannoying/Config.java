package com.thomass47.grassisannoying;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean isModEnabled = true;
    public static boolean hideBlockOutline = true;
    public static Configuration configuration;

    public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            syncConfig();
        }
    }

    public static void syncConfig() {
        isModEnabled = configuration.getBoolean(
            "isModEnabled",
            Configuration.CATEGORY_GENERAL,
            isModEnabled,
            "Set to false to disable attacking through grass");

        hideBlockOutline = configuration.getBoolean(
            "hideBlockOutline",
            Configuration.CATEGORY_GENERAL,
            hideBlockOutline,
            "Set to false to keep the block outline when aiming at an entity through grass");

        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    @cpw.mods.fml.common.eventhandler.SubscribeEvent
    public void onConfigChanged(cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals(GrassIsAnnoying.MODID)) {
            syncConfig();
        }
    }
}
