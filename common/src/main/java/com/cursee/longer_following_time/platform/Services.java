package com.cursee.longer_following_time.platform;

import com.cursee.longer_following_time.Constants;
import com.cursee.longer_following_time.platform.services.IPlatformHelper;
import java.util.ServiceLoader;

public class Services {

  public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

  public static <T> T load(Class<T> clazz) {

    final T loadedService = ServiceLoader.load(clazz, Services.class.getClassLoader()).findFirst()
        .orElseThrow(
            () -> new NullPointerException("Failed to load service for " + clazz.getName()));
    Constants.LOG.info("Loaded {} for service {}", loadedService, clazz);
    return loadedService;
  }
}