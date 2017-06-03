package com.reilly910.supplyquests.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.reilly910.supplyquests.SupplyQuests;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;

public class Quest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to execute this command");
			return false;
		}

		Player player = (Player) sender;
		QuestInventory(player);

		return false;
	}

	public void QuestInventory(Player player) {

		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.BLACK + "Quests");
		ItemStack cobbleGen = nameItem1(new ItemStack(Material.COBBLESTONE, 1), ChatColor.BLUE + "Cobblestone Generator",
				 player);
		ItemStack lumberJack = nameItem(new ItemStack(Material.SAPLING, 1), ChatColor.GREEN + "Lumberjack", SupplyQuests.cobbleGen,
				player);
		ItemStack ironMiner = nameItem(new ItemStack(Material.IRON_PICKAXE, 1), ChatColor.GRAY + "Iron Miner",
				SupplyQuests.lumberJack, player);
		ItemStack appleFarmer = nameItem(new ItemStack(Material.APPLE, 1), ChatColor.GREEN + "Apple Farmer",
				SupplyQuests.ironMiner, player);
		ItemStack melonFarmer = nameItem(new ItemStack(Material.MELON, 1), ChatColor.GREEN + "Melon Farmer",
				SupplyQuests.appleFarmer, player);
		ItemStack gettingLucky = nameItem(new ItemStack(Material.DIAMOND, 1), ChatColor.AQUA + "Getting Lucky",
				SupplyQuests.melonFarmer, player);
		ItemStack begToExpand = nameItem(new ItemStack(Material.GRASS, 1), ChatColor.DARK_PURPLE + "Begining to Expand",
				SupplyQuests.gettingLucky, player);
		ItemStack groundBeef = nameItem(new ItemStack(Material.RAW_BEEF, 1), ChatColor.RED + "Ground Beef",
				SupplyQuests.begToExpand, player);
		ItemStack monsterFarm = nameItem(new ItemStack(Material.ROTTEN_FLESH, 1), ChatColor.RED + "Monster Farm",
				SupplyQuests.groundBeef, player);
		ItemStack netherTime = nameItem(new ItemStack(Material.QUARTZ_ORE, 1), ChatColor.WHITE + "Nether Time",
				SupplyQuests.monsterFarm, player);
		ItemStack lotsOfQuartz = nameItem(new ItemStack(Material.QUARTZ, 1), ChatColor.WHITE + "Lots of Quartz",
				SupplyQuests.netherTime, player);
		ItemStack PvpReady = nameItem(new ItemStack(Material.DIAMOND_SWORD, 1), ChatColor.RED + "PvP Ready",
				SupplyQuests.lotsOfQuartz, player);
		ItemStack katniss = nameItem(new ItemStack(Material.BOW, 1), ChatColor.RED + "Katniss", SupplyQuests.pvp, player);
		ItemStack rich = nameItem(new ItemStack(Material.DIAMOND_BLOCK, 1), ChatColor.GOLD + "Rich", SupplyQuests.katniss, player);
		ItemStack notch = nameItem(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1), ChatColor.GOLD + "Notch", SupplyQuests.rich,
				player);
		ItemStack tradingTime = nameItem(new ItemStack(Material.EMERALD, 1), ChatColor.GREEN + "Trading Time", SupplyQuests.notch,
				player);
		ItemStack finalChallenge = nameItem(new ItemStack(Material.NETHER_STAR, 1),
				ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE + "The Final Challenge", SupplyQuests.finalChallenge,
				player);

		inv.addItem(cobbleGen);
		inv.addItem(lumberJack);
		inv.addItem(ironMiner);
		inv.addItem(appleFarmer);
		inv.addItem(melonFarmer);
		inv.addItem(gettingLucky);
		inv.addItem(begToExpand);
		inv.addItem(groundBeef);
		inv.addItem(monsterFarm);
		inv.addItem(netherTime);
		inv.addItem(lotsOfQuartz);
		inv.addItem(PvpReady);
		inv.addItem(katniss);
		inv.addItem(rich);
		inv.addItem(notch);
		inv.addItem(tradingTime);
		inv.addItem(finalChallenge);
		player.openInventory(inv);

	}

	public ItemStack nameItem(ItemStack item, String name, ArrayList<String> array, Player player) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		item = addGlow(item, array, player);
		return item;
	}
	
	public ItemStack nameItem1(ItemStack item, String name, Player player) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);		
		return item;
	}

	public ItemStack addGlow(ItemStack item, ArrayList<String> array, Player player) {

		if (!(array.contains(player.getDisplayName()))) {

			net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
			NBTTagCompound tag = null;
			if (!nmsStack.hasTag()) {
				tag = new NBTTagCompound();
				nmsStack.setTag(tag);
			}
			if (tag == null)
				tag = nmsStack.getTag();
			NBTTagList ench = new NBTTagList();
			tag.set("ench", ench);
			nmsStack.setTag(tag);
			return CraftItemStack.asCraftMirror(nmsStack);
		}
		
		return item;
	}
}
