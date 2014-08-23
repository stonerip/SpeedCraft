package us.stonerip.speedcraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;


public final class speedcraft extends JavaPlugin {
	@Override
    public void onEnable() {
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }
 
    @Override
    public void onDisable() {
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase("scstart")) { // If the player typed /basic then do the following...
    		getLogger().info("Starting new run!");
    		sender.sendMessage("[SpeedCraft] Starting a new run!");
    		Player p = (Player)sender;
    		ByteArrayDataOutput out = ByteStreams.newDataOutput();
    		out.writeUTF("Connect");
    		out.writeUTF("s1");
			p.sendPluginMessage(this, "BungeeCord", out.toByteArray());
    		
    		
    		return true;
    	} //If this has happened the function will return true. 
            // If this hasn't happened the value of false will be returned.
    	return false; 
    }
    
    @EventHandler
    public void onBlockCanBuild(BlockCanBuildEvent event) {
        Material mat = event.getMaterial();

        if (mat.equals(Material.CACTUS)) {
        	getLogger().info("Placing");
            event.setBuildable(true);
        }
    }

}
