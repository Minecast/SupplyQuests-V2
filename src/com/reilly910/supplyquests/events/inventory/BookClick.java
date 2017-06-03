package com.reilly910.supplyquests.events.inventory;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BookClick implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		
		if(event.getInventory().getName().contains("Quest") && event.getCurrentItem().getType() == Material.BOOK){
			event.setCancelled(true);
		}else{
			return;
		}
		
		
		
	}

}
