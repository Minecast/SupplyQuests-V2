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

public class MonsterFarmClick implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		if (event.getCurrentItem() == null)
			return;

		if (event.getCurrentItem().getType() == Material.ROTTEN_FLESH && event.getCurrentItem().getItemMeta()
				.getDisplayName().equals(ChatColor.RED + "Monster Farm")) {

			Player player = (Player) event.getWhoClicked();
			event.setCancelled(true);
			if (SupplyQuests.monsterFarmReward.contains(player.getDisplayName())) {
				player.sendMessage("You have already completed this quest and claimed your reward!");
				player.getOpenInventory().close();
				return;
			}else if(!(SupplyQuests.groundBeef.contains(player.getDisplayName()))){
				player.sendMessage("You need to complete the previous quest first!");
				player.getOpenInventory().close();
				return;
							
			}else {
				player.getOpenInventory().close();
				Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GRAY + "Monster Farm Quest");
				ItemStack book = add1Lore(new ItemStack(Material.BOOK, 1), ChatColor.GRAY + "Monster Farmer",
						"Build a mob farm and collect some loot!");
				inv.setItem(1, book);

				ItemStack submitItem = add1Lore(new ItemStack(Material.HOPPER, 1), ChatColor.RED + "Submit",
						"64x Rotten Flesh, 32x String, 32x Arrow, 32x Bone, 16 Gunpowder, 5x Spider Eye");
				inv.setItem(4, submitItem);
				ItemStack reward;
				if (SupplyQuests.monsterFarm.contains(player.getDisplayName())) {
					reward = add1Lore(new ItemStack(Material.CHEST, 1), ChatColor.GREEN + "Claim Rewards",
							"Reward: 16x Iron, 3x Diamonds, 1x Flint");
				} else {
					reward = add1Lore(new ItemStack(Material.CHEST, 1), ChatColor.RED + "Claim Rewards",
							"Reward: 16x Iron, 3x Diamonds, 1x Flint");

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
