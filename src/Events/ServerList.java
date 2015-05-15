package Events;


import Utilities.Utils;
import me.ES359.EasyMOTD.EMotd;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by ES359 on 5/11/15.
 */
public class ServerList implements Listener
{
    EMotd main;
    public ServerList(EMotd instance)
    {
        this.main= instance;
    }
    Utils util = new Utils();
    @EventHandler
    public void serverPing(ServerListPingEvent event)
    {
        String pingmessage = this.main.getConfig().getString("Messages.pingmotd");
        pingmessage = pingmessage.replaceAll("&", "\u00A7");
        pingmessage = pingmessage.replaceAll("%newline%", "\n");
        pingmessage = pingmessage.replaceAll("%staff%",util.getStaff(main));
        pingmessage = pingmessage.replaceAll("%users%",util.getUsers());
        pingmessage = pingmessage.replaceAll("%time%",""+util.getStamp());
        event.setMotd(pingmessage);
        //uitl.logToConsole("TEST: " +event.getAddress());
    }

}