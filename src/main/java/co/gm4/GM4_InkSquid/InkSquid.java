package co.gm4.GM4_InkSquid;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InkSquid extends JavaPlugin {
	public static int RADIUS, POLL_FREQ, BLIND_DUR;
	@Override
	public void onEnable(){
		saveDefaultConfig();
		RADIUS = getConfig().getInt("squid-radius");
		POLL_FREQ = getConfig().getInt("poll-freq");
		BLIND_DUR = getConfig().getInt("blind-duration");
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					Material m = p.getLocation().getBlock().getType();
					if(m == Material.WATER || m == Material.STATIONARY_WATER) {
						for(Entity e : p.getNearbyEntities(RADIUS, RADIUS, RADIUS)) {
							if(e.getType() == EntityType.SQUID) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,BLIND_DUR,5,false,false));
								break;
							}
						}
					}
				}
			}
		}, 0, POLL_FREQ);
	}
}
