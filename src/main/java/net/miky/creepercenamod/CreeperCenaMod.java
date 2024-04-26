package net.miky.creepercenamod;
import net.fabricmc.api.ModInitializer;
import net.miky.creepercenamod.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreeperCenaMod implements ModInitializer {

	public static final String MOD_ID = "creepercenamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModSounds.registerSounds();
	}
}
