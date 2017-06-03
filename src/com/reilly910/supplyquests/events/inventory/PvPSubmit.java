package com.reilly910.supplyquests.events.inventory;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.reilly910.supplyquests.SupplyQuests;

public class PvPSubmit implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		if (event.getCurrentItem() == null)
			return;

		if (event.getCurrentItem().getType() == Material.HOPPER
				&& event.getInventory().getName().equals(ChatColor.GRAY + "PvP Ready Quest")) {
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();

			if (SupplyQuests.katniss.contains(player.getDisplayName())) {
				player.sendMessage("You have already submitted this quest");
				return;
			}else{
				boolean completed = false;
				boolean helmet = checkInventory(player, Material.DIAMOND_HELMET, 1);
				boolean chestplate = checkInventory(player, Material.DIAMOND_CHESTPLATE, 1);
				boolean leggings = checkInventory(player, Material.DIAMOND_LEGGINGS, 1);
				boolean boots = checkInventory(player, Material.DIAMOND_BOOTS, 1);
				boolean sword = checkInventory(player, Material.DIAMOND_SWORD, 1);
				boolean gapples = checkInventory(player, Material.GOLDEN_APPLE, 5);
				if (helmet && chestplate && leggings && boots && sword && gapples) {
					completed = true;
				} else{
					
					if (helmet) {
						player.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET, 1));
						completed = false;
					}
					
					if (chestplate) {
						player.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
						completed = false;
					}
					
					if (leggings) {
						player.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
						completed = false;
					}
					
					if (boots) {
						player.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS, 1));
						completed = false;
					}
					
					if (sword) {
						player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
						completed = false;
					}
					
					if (gapples) {
						player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 5));
						completed = false;
					}
					
				}
				
				
				
				
				

				if(completed==true)

				{
					player.sendMessage("You have Completed the PvP Ready Quest");
					SupplyQuests.pvp.add(player.getDisplayName());
					player.getOpenInventory().close();
					return;
				}else
				{
					player.sendMessage("You are missing some items");
					player.getOpenInventory().close();
					return;
				}
				
			}
				
				
				
			
		}else{
			
			return;
		}


	}

	private boolean checkInventory(Player player, Material material, int amount) {
		int currentAmount = 0;
		ArrayList<Integer> itemLoc = new ArrayList<Integer>();
		;
		for (int i = 0; i < 36; i++) {

			if (player.getInventory().getItem(i) != null) {
				ItemStack item = player.getInventory().getItem(i);
				if (item.getType() == material) {
					if (item.getAmount() == amount) {
						player.getInventory().setItem(i, new ItemStack(Material.AIR, 0));
						return true;
					} else if (item.getAmount() > amount) {

						player.getInventory().getItem(i).setAmount(item.getAmount() - amount);
						return true;

					} else if (item.getAmount() + currentAmount >= amount) {

						if (item.getAmount() + currentAmount == amount) {
							itemLoc.add(i);
							for (int j = 0; j < itemLoc.size(); j++) {
								player.getInventory().setItem(itemLoc.get(j), new ItemStack(Material.AIR, 0));

							}
							return true;

						} else {
							int newAmount = 0;
							int currentPlace = 0;
							for (int k = 0; newAmount <= currentAmount; k++) {
								currentPlace = k;
								newAmount = newAmount + player.getInventory().getItem(itemLoc.get(k)).getAmount();
								player.getInventory().setItem(itemLoc.get(k), new ItemStack(Material.AIR, 0));
							}

							if (newAmount == currentAmount) {
								return true;

							} else {

								int temp = newAmount - amount;

								player.getInventory().getItem(itemLoc.get(currentPlace + 1)).setAmount(
										player.getInventory().getItem(itemLoc.get(currentPlace + 1)).getAmount()
												- temp);
								return true;

							}

						}

					} else {
						currentAmount = currentAmount + item.getAmount();
						itemLoc.add(i);
					}

				}
			} else {

			}

		}

		return false;
	}

}
