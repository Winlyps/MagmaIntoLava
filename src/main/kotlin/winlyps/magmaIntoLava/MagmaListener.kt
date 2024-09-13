package winlyps.magmaIntoLava

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class MagmaListener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        // Check if the action is a right-click block action
        if (event.action != Action.RIGHT_CLICK_BLOCK) return

        val clickedBlock = event.clickedBlock ?: return

        // Check if the clicked block is a magma block
        if (clickedBlock.type == Material.MAGMA_BLOCK) {
            // Check if the player is holding an item that can be placed (like a block)
            val itemInHand = event.item
            if (itemInHand != null && itemInHand.type.isBlock) {
                // The player is trying to place a block, so do nothing
                return
            }

            // Set the block to lava
            clickedBlock.type = Material.LAVA
            plugin.logger.info("${event.player.name} turned a magma block into lava at ${clickedBlock.location}")
        }
    }
}