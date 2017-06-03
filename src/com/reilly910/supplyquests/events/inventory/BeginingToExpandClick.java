package com.reilly910.supplyquests.events.inventory;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.reilly910.supplyquests.SupplyQuests;

public class BeginingToExpandClick implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		if (event.getCurrentItem() == null)
			return;

		if (event.getCurrentItem().getType() == Material.GRASS && event.getCurrentItem().getItemMeta()
				.getDisplayName().equals(ChatColor.DARK_PURPLE + "Begining to Expand")) {

			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			if (SupplyQuests.begToExpandReward.contains(player.getDisplayName())) {
				player.sendMessage("You have already completed this quest and claimed your reward!");
				player.getOpenInventory().close();
				return;
			}else if(!(SupplyQuests.gettingLucky.contains(player.getDisplayName()))){
				player.sendMessage("You need to complete the previous quest first!");
				player.getOpenInventory().close();
				return;
							
			}else {
				player.getOpenInventory().close();
				Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GRAY + "Begining to Expand Quest");
				ItemStack book = add1Lore(new ItemStack(Material.BOOK, 1), ChatColor.GRAY + "Begining to Expand",
						"Collect items to expand your island!");
				inv.setItem(1, book);

				ItemStack submitItem = add1Lore(new ItemStack(Material.HOPPER, 1), ChatColor.RED + "Submit",
						"32 x Oak Planks and 64 x Stone Bricks");
				inv.setItem(4, submitItem);
				ItemStack reward;
				if (SupplyQuests.begToExpand.contains(player.getDisplayName())) {
					reward = add1Lore(new ItemStack(Material.CHEST, 1), ChatColor.GREEN + "Claim Rewards",
							"Reward: 8x Grass Block, 32 Oak Logs");
				} else {
					reward = add1Lore(new ItemStack(Material.CHEST, 1), ChatColor.RED + "Claim Rewards",
							"Reward: 8x Grass Block, 32 Oak Logs");

				}
				inv.setItem(7, reward);

				player.openInventory(inv);

			}
		}else{
			return;
		}

	}

	private ItemStack add1Lore(ItemStack item, String name, String lore1) {

		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(lore1);
		meta.setLore(lore);
		meta.setDisplayName(name);
		item.setItemMeta(meta);

		return item;
	}

	private ItemStack add2Lore(ItemStack item, String name, String lore1, String lore2) {

		ItemMeta meta = item.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(lore1);
		lore.add(lore2);
		meta.setLore(lore);
		meta.setDisplayName(name);
		item.setItemMeta(meta);

		return item;
	}

}
