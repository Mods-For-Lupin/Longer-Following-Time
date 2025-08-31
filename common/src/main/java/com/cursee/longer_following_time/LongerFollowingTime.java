package com.cursee.longer_following_time;

import com.cursee.longer_following_time.platform.Services;
import com.cursee.longer_following_time.util.Config;
import java.io.File;

public class LongerFollowingTime {

  public static void init() {
  }

  public static void createOrLoadConfig() {

    // ensure the config directory exists
    String configDirPath = Services.PLATFORM.getGameDirectory() + File.separator + "config";
    File configDir = new File(configDirPath);

    if (!configDir.isDirectory() && !configDir.mkdirs()) {
      Constants.LOG.info("Insufficient privilege to create directory {}, retaining default config.",
          configDirPath);
      return;
    }

    // check if the config file exists, then either create or load its values
    String configFilePath = configDirPath + File.separator + Constants.MOD_ID + ".toml";
    File configFile = new File(configFilePath);

    if (!configFile.isFile()) {

      Constants.LOG.info("{} did not exist, creating with default values.", configFilePath);

      Config config = new Config(configFilePath);
      config.set("addedSeconds", 4.0f);
      config.save();
    }
    else {

      Constants.LOG.info("{} exists, loadin configuration from file.", configFilePath);

      Config config = new Config(configFilePath);
      ConfiguredValues.addedSeconds = config.getFloat("addedSeconds", 4.0f);
    }
  }
}