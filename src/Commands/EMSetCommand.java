package Commands;

import Utilities.Utils;
import me.ES359.EasyMOTD.EMotd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by ES359 on 5/11/15.
 */
public class EMSetCommand implements CommandExecutor
{
    EMotd main;
    public EMSetCommand(EMotd instance)
    {
        this.main = instance;
    }
    Utils utils = new Utils();
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
    {
        if(cmd.getName().equalsIgnoreCase("emset") && !(sender.hasPermission("easymotd.setmotd")))
        {
            sender.sendMessage(utils.permissionMessage("&c--> You need the permission","&beasymotd.setmotd"));
        }else if(args.length < 1)
        {
            sender.sendMessage(utils.color("&b======[&eUsage&b]======"));
            sender.sendMessage("/emset <message>" + utils.color(" &b- Sets the In-game message."));
            sender.sendMessage("You may use color coding in your messages.");
            sender.sendMessage(utils.color("&bFor more information, follow this link: &2&ohttp://ess.khhq.net/mc/"));
        }else if(args.length > 0)
        {
            StringBuilder builder = new StringBuilder();

            for(int i=0; i <args.length; i++ )
            {
                builder.append(args[i] + " ");
            }
            String message = builder.toString();
            this.main.getConfig().set("Messages.motd", utils.color(message));
            this.main.saveConfig();
            sender.sendMessage(utils.color(utils.getPrefix() +"&c--> You have set the message to: "+ this.main.getConfig().getString("Messages.motd")));

        }
        return true;
    }
}
