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

public class NetherTimeClick implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		if (event.getCurrentItem() == null)
			return;

		if (event.getCurrentItem().getType() == Material.QUARTZ_ORE && event.getCurrentItem().getItemMeta()
				.getDisplayName().equals(ChatColor.WHITE + "Nether Time")) {

			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			if (SupplyQuests.netherTimeReward.contains(player.getDisplayName())) {
				player.sendMessage("You have already completed this quest and claimed your reward!");
				player.getOpenInventory().close();
				return;
			}else if(!(SupplyQuests.monsterFarm.contains(player.getDisplayName()))){
				player.sendMessage("You need to complete the previous quest first!");
				player.getOpenInventory().close();
				return;
							
			}else {
				player.getOpenInventory().close();
				Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GRAY + "Nether Time Quest");
				ItemStack book = add1Lore(new ItemStack(Material.BOOK, 1), ChatColor.GRAY + "Nether Time",
						"Get ready to build a nether portal!");
				inv.setItem(1, book);

				ItemStack submitItem = add1Lore(new ItemStack(Material.HOPPER, 1), ChatColor.RED + "Submit",
						"10 x Obsidian & 1 x Flint & Steel");
				inv.setItem(4, submitItem);
				ItemStack reward;
				if (SupplyQuests.cobbleGenReward.contains(player.getDisplayName())) {
					reward = add1Lore(new ItemStack(Material.CHEST, 1), ChatColor.GREEN + "Claim Rewards",
							"Reward: 3x Diamonds, 10x Obsidian, 1x Flint & Steel");
				} else {
					reward = add1Lore(new ItemStack(Material.CHEST, 1), ChatColor.RED + "Claim Rewards",
							"Reward: 3x Diamonds, 10x Obsidian, 1x Flint & Steel");

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
