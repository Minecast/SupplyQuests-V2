package com.reilly910.supplyquests.events.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class PlayerRightClick implements Listener {
	
	@EventHandler
	public void onPlayerRightClick(PlayerInteractEvent event){
		
		if(!(event.getAction() == Action.RIGHT_CLICK_BLOCK)){
			return;
		}
		
		if(event.getClickedBlock().getType() != Material.CHEST){
			return;			
		}
		
		if(event.getClickedBlock().hasMetadata("chest")){			
			Location loc = event.getClickedBlock().getLocation();
			loc.getBlock().setType(Material.AIR);
			Inventory inv = event.getPlayer().getInventory();			
			event.getPlayer().updateInventory();
		}else{
			return;
		}
		
		
	}
	
	

}
