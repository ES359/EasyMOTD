package Events;

import Utilities.Utils;
import me.ES359.EasyMOTD.EMotd;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by ES359 on 5/11/15.
 */
public class Join implements Listener
{
    EMotd main;
    public Join(EMotd instance)
    {
        this.main = instance;
    }

    Utils util = new Utils();

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player p = event.getPlayer();
        String config = util.color(this.main.getConfig().getString("Messages.motd"));

        config = config.replaceAll("%newline%","\n");
        config = config.replaceAll("%player%",p.getName());
        config = config.replaceAll("%staff%",util.getStaff());
        config = config.replaceAll("%users%",util.getUsers());
        config = config.replaceAll("%time%",""+util.getStamp());
        if(this.main.isJoinEnabled())
        {
            p.sendMessage(config);
        }
    }
}
