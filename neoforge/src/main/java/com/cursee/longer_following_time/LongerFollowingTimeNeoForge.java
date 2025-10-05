package com.cursee.longer_following_time;

import com.cursee.monolib.api.common.sailing.SailingApi;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class LongerFollowingTimeNeoForge {

  public LongerFollowingTimeNeoForge(final IEventBus eventBus) {
    SailingApi.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION,
        Constants.MOD_PUBLISHER, Constants.MOD_URL);
    LongerFollowingTime.init();
  }
}
