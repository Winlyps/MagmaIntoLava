package winlyps.magmaIntoLava

import org.bukkit.plugin.java.JavaPlugin

class MagmaIntoLava : JavaPlugin() {

    override fun onEnable() {
        // Register the event listener
        server.pluginManager.registerEvents(MagmaListener(this), this)
        logger.info("MagmaIntoLava plugin has been enabled!")
    }

    override fun onDisable() {
        logger.info("MagmaIntoLava plugin has been disabled!")
    }
}