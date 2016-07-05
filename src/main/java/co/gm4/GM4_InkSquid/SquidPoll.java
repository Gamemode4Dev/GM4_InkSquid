package co.gm4.GM4_InkSquid;

import java.util.ArrayList;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.entity.Squid;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class SquidPoll extends TimerTask implements Runnable {
	@Override
	public void run(){
		ArrayList<Squid>squids=new ArrayList<Squid>(Bukkit.getWorlds().get(0).getEntitiesByClass(Squid.class));
		ArrayList<Player>players=new ArrayList<Player>(Bukkit.getWorlds().get(0).getPlayers());
		ArrayList<Player>submergedplayers = new ArrayList<Player>();
		for(Player p : players){
			if(p.getLocation().getBlock().getRelative(BlockFace.UP).getType() == Material.STATIONARY_WATER)	//For some reason Mateiral.WATER doesn't match any form of water
				submergedplayers.add(p);
		}
		
		if(submergedplayers.isEmpty() || squids.isEmpty())
			return;
		
		for(Player p : submergedplayers){
			for(Squid s : squids){
				if(p.getLocation().distance(s.getLocation())<5){
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,120,5,false,false));
				}
			}
		}
	}
}
