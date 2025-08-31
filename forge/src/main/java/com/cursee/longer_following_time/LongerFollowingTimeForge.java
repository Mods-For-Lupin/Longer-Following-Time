package com.cursee.longer_following_time;

import com.cursee.monolib.core.sailing.Sailing;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class LongerFollowingTimeForge {

  public LongerFollowingTimeForge(final FMLJavaModLoadingContext context) {
    Sailing.register(Constants.MOD_ID, Constants.MOD_NAME, Constants.MOD_VERSION,
        Constants.MOD_PUBLISHER, Constants.MOD_URL);
    LongerFollowingTime.init();
  }
}
