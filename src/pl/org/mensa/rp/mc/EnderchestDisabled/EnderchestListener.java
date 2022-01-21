package pl.org.mensa.rp.mc.EnderchestDisabled;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnderchestListener implements Listener {
	EnderchestDisabledPlugin plugin;
	
	public EnderchestListener(EnderchestDisabledPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEnderchestThing(PlayerInteractEvent e) {
		if (e.getClickedBlock() == null) return;
		
		if (e.getClickedBlock().getType() == Material.ENDER_CHEST
				&& e.getAction() == Action.RIGHT_CLICK_BLOCK
				&& !e.getPlayer().hasPermission("enderchestdisabled.bypass")) {
			e.setCancelled(true);
		}
	}
}
