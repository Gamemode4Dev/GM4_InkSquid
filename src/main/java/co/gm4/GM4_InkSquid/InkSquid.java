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
	@Override
	public void onEnable(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					Material m = p.getLocation().getBlock().getType();
					if(m == Material.WATER || m == Material.STATIONARY_WATER) {
						for(Entity e : p.getNearbyEntities(5, 5, 5)) {
							if(e.getType() == EntityType.SQUID) {
								p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,100,5,false,false));
								break;
							}
						}
					}
				}
			}
		}, 0, 80);
	}
}
