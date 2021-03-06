package com.reilly910.supplyquests.events.inventory;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftFirework;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import com.reilly910.supplyquests.SupplyQuests;

public class FinalChallengeReward implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		if (event.getCurrentItem() == null)
			return;
		
		ItemStack item = event.getCurrentItem();
		Player player = (Player) event.getWhoClicked();
		
		if(event.getInventory().getName().equals(ChatColor.GRAY + "Final Challenge Quest") && item.getType() == Material.CHEST){
			event.setCancelled(true);
			if(SupplyQuests.finalChallenge.contains(player.getDisplayName())){
				if(player.getWorld().getName().equals("ASkyBlock")){
					
					Random rand = new Random();
					int r = rand.nextInt(4) + 1;
					
					Location loc = player.getLocation().add(r-2, 0, 0);
					Block block = loc.getBlock();
			        loc.getBlock().setType(Material.CHEST);
			        Chest chest = (Chest)block.getState();
			        Inventory inv = chest.getInventory();
			        
					inv.addItem(new ItemStack(Material.BEACON,1));					
					SupplyQuests.finalChallengeReward.add(player.getDisplayName());
					player.sendMessage("Your Rewards have arrived");
					Bukkit.getServer().broadcastMessage(ChatColor.GREEN + player.getDisplayName() + " has completed all the quests!");
					player.getWorld().spawn(loc, Firework.class);
					player.getWorld().spawn(loc, Firework.class);
					player.getWorld().spawn(loc, Firework.class);
					player.getWorld().spawn(loc, Firework.class);
					Firework fw = loc.getWorld().spawn(loc, Firework.class);
					FireworkMeta meta = fw.getFireworkMeta();
				    meta.addEffect(FireworkEffect.builder().flicker(false).with(Type.BALL).trail(false).withColor(Color.GREEN).build());
				    fw.setFireworkMeta(meta);
					((CraftFirework)fw).getHandle().expectedLifespan = 1;
					player.getOpenInventory().close();
					return;
					
				}else{
					player.sendMessage("You aren't in the correct world to claim your reward!");
					player.getOpenInventory().close();
					
				}
				
				
			}else{
				player.sendMessage("You need to complete the quest before you claim the reward");
				player.getOpenInventory().close();
			}
			
			
			
			
		}

	}
	
	

}
