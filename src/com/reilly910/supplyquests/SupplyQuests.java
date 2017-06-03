package com.reilly910.supplyquests;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.reilly910.supplyquests.commands.Quest;
import com.reilly910.supplyquests.events.inventory.AppleClick;
import com.reilly910.supplyquests.events.inventory.AppleReward;
import com.reilly910.supplyquests.events.inventory.AppleSubmit;
import com.reilly910.supplyquests.events.inventory.BegginingToExpandSubmit;
import com.reilly910.supplyquests.events.inventory.BeginingToExpandClick;
import com.reilly910.supplyquests.events.inventory.BeginingToExpandReward;
import com.reilly910.supplyquests.events.inventory.BookClick;
import com.reilly910.supplyquests.events.inventory.CobbleClick;
import com.reilly910.supplyquests.events.inventory.CobbleReward;
import com.reilly910.supplyquests.events.inventory.CobbleSubmit;
import com.reilly910.supplyquests.events.inventory.FinalChallengeClick;
import com.reilly910.supplyquests.events.inventory.FinalChallengeReward;
import com.reilly910.supplyquests.events.inventory.FinalChallengeSubmit;
import com.reilly910.supplyquests.events.inventory.GettingLuckyReward;
import com.reilly910.supplyquests.events.inventory.GroundBeefClick;
import com.reilly910.supplyquests.events.inventory.GroundBeefReward;
import com.reilly910.supplyquests.events.inventory.GroundBeefSubmit;
import com.reilly910.supplyquests.events.inventory.IronMinerClick;
import com.reilly910.supplyquests.events.inventory.IronMinerSubmit;
import com.reilly910.supplyquests.events.inventory.IronReward;
import com.reilly910.supplyquests.events.inventory.KatnissClick;
import com.reilly910.supplyquests.events.inventory.KatnissReward;
import com.reilly910.supplyquests.events.inventory.KatnissSubmit;
import com.reilly910.supplyquests.events.inventory.LotsOfQuartzClick;
import com.reilly910.supplyquests.events.inventory.LotsOfQuartzReward;
import com.reilly910.supplyquests.events.inventory.LotsOfQuartzSubmit;
import com.reilly910.supplyquests.events.inventory.LumberClick;
import com.reilly910.supplyquests.events.inventory.LumberReward;
import com.reilly910.supplyquests.events.inventory.LumberSubmit;
import com.reilly910.supplyquests.events.inventory.MelonClick;
import com.reilly910.supplyquests.events.inventory.MelonReward;
import com.reilly910.supplyquests.events.inventory.MelonSubmit;
import com.reilly910.supplyquests.events.inventory.MonsterFarmClick;
import com.reilly910.supplyquests.events.inventory.MonsterFarmReward;
import com.reilly910.supplyquests.events.inventory.MonsterFarmSubmit;
import com.reilly910.supplyquests.events.inventory.NetherTimeClick;
import com.reilly910.supplyquests.events.inventory.NetherTimeReward;
import com.reilly910.supplyquests.events.inventory.NetherTimeSubmit;
import com.reilly910.supplyquests.events.inventory.NotchClick;
import com.reilly910.supplyquests.events.inventory.NotchReward;
import com.reilly910.supplyquests.events.inventory.NotchSubmit;
import com.reilly910.supplyquests.events.inventory.PvPClick;
import com.reilly910.supplyquests.events.inventory.PvPReward;
import com.reilly910.supplyquests.events.inventory.PvPSubmit;
import com.reilly910.supplyquests.events.inventory.RichClick;
import com.reilly910.supplyquests.events.inventory.RichReward;
import com.reilly910.supplyquests.events.inventory.RichSubmit;
import com.reilly910.supplyquests.events.inventory.TradingTimeClick;
import com.reilly910.supplyquests.events.inventory.TradingTimeReward;
import com.reilly910.supplyquests.events.inventory.TradingTimeSubmit;
import com.reilly910.supplyquests.events.inventory.gettingLuckyClick;
import com.reilly910.supplyquests.events.inventory.gettingLuckySubmit;
import com.reilly910.supplyquests.events.player.PlayerJoin;
import com.reilly910.supplyquests.events.player.PlayerRightClick;

public class SupplyQuests extends JavaPlugin {

	private static SupplyQuests instance;

	public static ArrayList<String> cobbleGen = new ArrayList<String>();
	public static ArrayList<String> cobbleGenReward = new ArrayList<String>();
	public static ArrayList<String> lumberJack = new ArrayList<String>();
	public static ArrayList<String> lumberJackReward = new ArrayList<String>();
	public static ArrayList<String> ironMiner = new ArrayList<String>();
	public static ArrayList<String> ironMinerReward = new ArrayList<String>();
	public static ArrayList<String> appleFarmer = new ArrayList<String>();
	public static ArrayList<String> appleFarmerReward = new ArrayList<String>();
	public static ArrayList<String> melonFarmer = new ArrayList<String>();
	public static ArrayList<String> melonFarmerReward = new ArrayList<String>();
	public static ArrayList<String> gettingLucky = new ArrayList<String>();
	public static ArrayList<String> gettingLuckyReward = new ArrayList<String>();
	public static ArrayList<String> begToExpand = new ArrayList<String>();
	public static ArrayList<String> begToExpandReward = new ArrayList<String>();
	public static ArrayList<String> groundBeef = new ArrayList<String>();
	public static ArrayList<String> groundBeefReward = new ArrayList<String>();
	public static ArrayList<String> monsterFarm = new ArrayList<String>();
	public static ArrayList<String> monsterFarmReward = new ArrayList<String>();
	public static ArrayList<String> netherTime = new ArrayList<String>();
	public static ArrayList<String> netherTimeReward = new ArrayList<String>();
	public static ArrayList<String> lotsOfQuartz = new ArrayList<String>();
	public static ArrayList<String> lotsOfQuartzReward = new ArrayList<String>();
	public static ArrayList<String> pvp = new ArrayList<String>();
	public static ArrayList<String> pvpReward = new ArrayList<String>();
	public static ArrayList<String> katniss = new ArrayList<String>();
	public static ArrayList<String> katnissReward = new ArrayList<String>();
	public static ArrayList<String> rich = new ArrayList<String>();
	public static ArrayList<String> richReward = new ArrayList<String>();
	public static ArrayList<String> notch = new ArrayList<String>();
	public static ArrayList<String> notchReward = new ArrayList<String>();
	public static ArrayList<String> tradingTime = new ArrayList<String>();
	public static ArrayList<String> tradingTimeReward = new ArrayList<String>();
	public static ArrayList<String> finalChallenge = new ArrayList<String>();
	public static ArrayList<String> finalChallengeReward = new ArrayList<String>();

	public void onEnable() {
		instance = this;
		loadConfig();
		registerEvents();
		registerCommands();

	}

	public void onDisable() {

		savingConfig();

	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new CobbleClick(), this);
		pm.registerEvents(new CobbleSubmit(), this);
		pm.registerEvents(new CobbleReward(), this);
		pm.registerEvents(new LumberClick(), this);
		pm.registerEvents(new LumberSubmit(), this);
		pm.registerEvents(new LumberReward(), this);
		pm.registerEvents(new IronMinerClick(), this);
		pm.registerEvents(new IronMinerSubmit(), this);
		pm.registerEvents(new IronReward(), this);
		pm.registerEvents(new AppleClick(), this);
		pm.registerEvents(new AppleSubmit(), this);
		pm.registerEvents(new AppleReward(), this);
		pm.registerEvents(new MelonClick(), this);
		pm.registerEvents(new MelonSubmit(), this);
		pm.registerEvents(new MelonReward(), this);
		pm.registerEvents(new gettingLuckyClick(), this);
		pm.registerEvents(new gettingLuckySubmit(), this);
		pm.registerEvents(new GettingLuckyReward(), this);
		pm.registerEvents(new BegginingToExpandSubmit(), this);
		pm.registerEvents(new BeginingToExpandClick(), this);
		pm.registerEvents(new BeginingToExpandReward(), this);
		pm.registerEvents(new GroundBeefClick(), this);
		pm.registerEvents(new GroundBeefSubmit(), this);
		pm.registerEvents(new GroundBeefReward(), this);
		pm.registerEvents(new MonsterFarmClick(), this);
		pm.registerEvents(new MonsterFarmSubmit(), this);
		pm.registerEvents(new MonsterFarmReward(), this);
		pm.registerEvents(new NetherTimeClick(), this);
		pm.registerEvents(new NetherTimeSubmit(), this);
		pm.registerEvents(new NetherTimeReward(), this);
		pm.registerEvents(new LotsOfQuartzClick(), this);
		pm.registerEvents(new LotsOfQuartzSubmit(), this);
		pm.registerEvents(new LotsOfQuartzReward(), this);
		pm.registerEvents(new PvPClick(), this);
		pm.registerEvents(new PvPSubmit(), this);
		pm.registerEvents(new PvPReward(), this);
		pm.registerEvents(new KatnissClick(), this);
		pm.registerEvents(new KatnissSubmit(), this);
		pm.registerEvents(new KatnissReward(), this);
		pm.registerEvents(new RichClick(), this);
		pm.registerEvents(new RichSubmit(), this);
		pm.registerEvents(new RichReward(), this);
		pm.registerEvents(new NotchClick(), this);
		pm.registerEvents(new NotchSubmit(), this);
		pm.registerEvents(new NotchReward(), this);
		pm.registerEvents(new TradingTimeClick(), this);
		pm.registerEvents(new TradingTimeSubmit(), this);
		pm.registerEvents(new TradingTimeReward(), this);
		pm.registerEvents(new FinalChallengeClick(), this);
		pm.registerEvents(new FinalChallengeSubmit(), this);
		pm.registerEvents(new FinalChallengeReward(), this);
		pm.registerEvents(new BookClick(), this);
		pm.registerEvents(new PlayerRightClick(), this);

	}

	public void registerCommands() {

		getCommand("quest").setExecutor(new Quest());

	}

	public static SupplyQuests getInst() {

		return instance;
	}

	private void loadConfig() {

		File file = new File(getDataFolder(), "config.yml");
		if (!file.exists()) {
			getLogger().info("config.yml not found, creating!");
			saveDefaultConfig();
			return;
		} else {
			getLogger().info("config.yml found, loading!");
		}

		loadSection("cobbleGen", cobbleGen);
		loadSection("cobbleGenReward", cobbleGenReward);
		loadSection("lumberJack", lumberJack);
		loadSection("lumberJackReward", lumberJackReward);
		loadSection("ironMiner", ironMiner);
		loadSection("ironMinerReward", ironMinerReward);
		loadSection("appleFarmer", appleFarmer);
		loadSection("appleFarmerReward", appleFarmerReward);
		loadSection("melonFarmer", melonFarmer);
		loadSection("melonFarmerReward", melonFarmerReward);
		loadSection("gettingLucky", gettingLucky);
		loadSection("gettingLuckyReward", gettingLuckyReward);
		loadSection("begToExpand", begToExpand);
		loadSection("begToExpandReward", begToExpandReward);
		loadSection("groundBeef", groundBeef);
		loadSection("groundBeefReward", groundBeefReward);
		loadSection("monsterFarm", monsterFarm);
		loadSection("monsterFarmReward", monsterFarmReward);
		loadSection("netherTime", netherTime);
		loadSection("netherTimeReward", netherTimeReward);
		loadSection("lotsOfQuartz", lotsOfQuartz);
		loadSection("lotsOfQuartzReward", lotsOfQuartzReward);
		loadSection("pvp", pvp);
		loadSection("pvpReward", pvpReward);
		loadSection("katniss", katniss);
		loadSection("katnissReward", katnissReward);
		loadSection("rich", rich);
		loadSection("richReward", richReward);
		loadSection("notch", notch);
		loadSection("notchReward", notchReward);
		loadSection("tradingTime", tradingTime);
		loadSection("tradingTimeReward", tradingTimeReward);
		loadSection("finalChallenge", finalChallenge);
		loadSection("finalChallengeReward", finalChallengeReward);

	}

	private void loadSection(String name, ArrayList<String> array) {
		FileConfiguration config = getConfig();

		array.addAll(config.getStringList(name));

	}

	private void savingConfig() {

		saveDefaultConfig();
		updateConfig("cobbleGen", cobbleGen);
		updateConfig("cobbleGenReward", cobbleGenReward);
		updateConfig("lumberJack", lumberJack);
		updateConfig("lumberJackReward", lumberJackReward);
		updateConfig("ironMiner", ironMiner);
		updateConfig("ironMinerReward", ironMinerReward);
		updateConfig("appleFarmer", appleFarmer);
		updateConfig("appleFarmerReward", appleFarmerReward);
		updateConfig("melonFarmer", melonFarmer);
		updateConfig("melonFarmerReward", melonFarmerReward);
		updateConfig("gettingLucky", gettingLucky);
		updateConfig("gettingLuckyReward", gettingLuckyReward);
		updateConfig("begToExpand", begToExpand);
		updateConfig("begToExpandReward", begToExpandReward);
		updateConfig("groundBeef", groundBeef);
		updateConfig("groundBeefReward", groundBeefReward);
		updateConfig("monsterFarm", monsterFarm);
		updateConfig("monsterFarmReward", monsterFarmReward);
		updateConfig("netherTime", netherTime);
		updateConfig("netherTimeReward", netherTimeReward);
		updateConfig("lotsOfQuartz", lotsOfQuartz);
		updateConfig("lotsOfQuartzReward", lotsOfQuartzReward);
		updateConfig("pvp", pvp);
		updateConfig("pvpReward", pvpReward);
		updateConfig("katniss", katniss);
		updateConfig("katnissReward", katnissReward);
		updateConfig("rich", rich);
		updateConfig("richReward", richReward);
		updateConfig("notch", notch);
		updateConfig("notchReward", notchReward);
		updateConfig("tradingTime", tradingTime);
		updateConfig("tradingTimeReward", tradingTimeReward);
		updateConfig("finalChallenge", finalChallenge);
		updateConfig("finalChallengeReward", finalChallengeReward);

	}

	private void updateConfig(String name, ArrayList<String> array) {

		FileConfiguration config = getConfig();
		config.set(name, array);
		saveConfig();
	}

}
