package Commands;

import Utilities.Utils;
import me.ES359.EasyMOTD.EMotd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by ES359 on 5/11/15.
 */
public class EMListCommand implements CommandExecutor {

   EMotd main;
    Utils utils = new Utils();

    public EMListCommand(EMotd instance)
    {
        this.main = instance;
    }



    public boolean onCommand(CommandSender sender, Command cmd, String command, String args[])
    {
       if(cmd.getName().equalsIgnoreCase("emlist") && !(sender.hasPermission("easymotd.list")))
       {
           sender.sendMessage(utils.permissionMessage("&c--> You need the required permission","&eeasymotd.list"));
       }else if(args.length < 1)
       {
           /**
            * Also, Possible to iterate through the player is online IE:
            *
            * for(Player p : p.isOnline ? )
            *
            */
           sender.sendMessage(utils.color("&b========[&eMessages&b]======="));
           sender.sendMessage("Staff online: "+utils.getStaff());
           sender.sendMessage(utils.color("&6In-game message: &f"+this.main.getConfig().getString("Messages.motd")));
           sender.sendMessage(utils.color("&6PingList Message: &f"+this.main.getConfig().getString("Messages.pingmotd")));
           sender.sendMessage(utils.color("&b========================"));
       }
        return true;
    }

}
