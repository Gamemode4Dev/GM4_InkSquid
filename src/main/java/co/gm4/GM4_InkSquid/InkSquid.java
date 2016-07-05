package co.gm4.GM4_InkSquid;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class InkSquid extends JavaPlugin {
	@Override
	public void onEnable(){
		SquidPoll sp = new SquidPoll();
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, sp, 0, 80);
	}
}
