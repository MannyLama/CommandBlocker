package me.treyruffy.commandblocker.Bukkit;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import me.treyruffy.commandblocker.MethodInterface;

public class BukkitMethods implements MethodInterface {

	@Override
	public String getVersion() {
		return BukkitMain.get().getDescription().getVersion();
	}

	@Override
	public File getDataFolder() {
		return ((JavaPlugin) getPlugin()).getDataFolder();
	}

	@Override
	public void executeCommand(String cmd) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
	}

	@Override
	public void setupMetrics() {
		Metrics metrics = new Metrics((JavaPlugin) getPlugin());
	}

	@Override
	public void sendMessage(Object player, String msg) {
		if (msg != null || msg.length() != 0){
			((CommandSender) player).sendMessage(msg);
		}
	}

	@Override
	public Object getPlugin() {
		return BukkitMain.get();
	}

	@Override
	public void log(String msg) {
		Bukkit.getServer().getConsoleSender().sendMessage(msg.replaceAll("&", "§"));
	}

}
