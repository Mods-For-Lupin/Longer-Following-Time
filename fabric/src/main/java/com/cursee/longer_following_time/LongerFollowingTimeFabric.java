package com.cursee.longer_following_time;

import com.cursee.monolib.api.common.sailing.SailingApi;
import net.fabricmc.api.ModInitializer;

public class LongerFollowingTimeFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    SailingApi.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION,
        Constants.MOD_PUBLISHER, Constants.MOD_URL);
    LongerFollowingTime.init();
  }
}
