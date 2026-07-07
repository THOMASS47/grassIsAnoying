package com.thomass47.grassisannoying;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static boolean isModEnabled = true;
    public static boolean hideBlockOutline = true;

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

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
}
