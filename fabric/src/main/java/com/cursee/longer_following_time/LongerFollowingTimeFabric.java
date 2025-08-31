package com.cursee.longer_following_time;

import com.cursee.monolib.core.sailing.Sailing;
import net.fabricmc.api.ModInitializer;

public class LongerFollowingTimeFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION,
        Constants.MOD_PUBLISHER, Constants.MOD_URL);
    LongerFollowingTime.init();
  }
}
