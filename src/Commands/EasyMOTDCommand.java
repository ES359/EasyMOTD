package Commands;

import Utilities.Utils;
import me.ES359.EasyMOTD.EMotd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by ES359 on 5/11/15.
 */
public class EasyMOTDCommand implements CommandExecutor
{
    Utils util = new Utils();
    EMotd main;
    public EasyMOTDCommand(EMotd instance)
    {
        this.main = instance;
    }



    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
    {

        if(cmd.getName().equalsIgnoreCase("easymotd") && !(sender.hasPermission("easymotd.command")))
        {
            sender.sendMessage(util.color("&b=======&e" + util.getPrefix() + "&b======="));
            sender.sendMessage(util.color("&eMotd plugin, created by, &b" + this.main.pdfFile.getAuthors() + "&e."));
          //  sender.sendMessage(util.color("&7&oSub commands: &8/em help &8&l--&b&l> &bDisplays help menu.\n"));
        }else {
            if(args.length < 1)
            {
                sender.sendMessage(util.color("&b=======&e" + util.getPrefix() + "&b======="));
                sender.sendMessage(util.color("&eMotd plugin, created by, &b" + this.main.pdfFile.getAuthors() + "&e."));
                sender.sendMessage(util.color("&7&oSub commands: &8/em help &8&l--&b&l> &bDisplays help menu.\n"));
            }else {
                if(args.length > 0)
                {
                    switch (args[0]) {
                        case "reload":
                        case "rl":
                            if (!sender.hasPermission("easymotd.reload"))
                                sender.sendMessage(util.permissionMessage("&c--> You need the permission", "&beasymotd.reload"));
                            else
                                this.main.reloadConfig();
                            sender.sendMessage(util.color(util.getPrefix() + "&c--> &eConfig has been reloaded, &a&o" + sender.getName()));
                            break;
                        case "help":
                            if (!sender.hasPermission("easymotd.help")) sender.sendMessage(util.permissionMessage("&c--> You need the permission", "&beasymotd.help"));
                            else
                                sender.sendMessage(util.color("&b=======[&eHelp&b]======="));
                            sender.sendMessage(util.color("&8/em permissions &b&l--&b&l> &aLists plugins permissions.\n" +
                                    "&8/em config &8&l--&b&l> &aLists configuration options/help.\n" +
                                    "&8/em commands &8&l--&b&l> &aLists all plugin commands."));
                            break;
                        case "commands":
                        case "cmds":
                            if (!sender.hasPermission("easymotd.commands"))
                                sender.sendMessage(util.permissionMessage("&c--> You need the permission", "&beasymotd.commands"));
                            else
                                sender.sendMessage(util.color("&b=======[&eCommands&b]======="));
                            sender.sendMessage(util.color("&8/em reload &b&l--&b&l> &cReloads the config file.\n" +
                                    "&8/em config &8&l--&b&l> &aLists configuration options/help.\n" +
                                    "&8/em commands &8&l--&b&l> &aLists all plugin commands.\n" +
                                    "&a------------------------\n" +
                                    "&8/emlist &8&l--&b&l> &aDisplays currently set messages.\n" +
                                    "&8/emset <msg> &8&l--&b&l> &aSets the In-game message.\n" +
                                    "&8/emsetlist <msg> &8&l--&b&l> &aSet the server list message.\n" +
                                    "&8/em &8&l--&b&l> &aDisplays main menu."));
                            break;

                        case "permissions":
                        case "perms":
                            if (!sender.hasPermission("easymotd.permissions")) sender.sendMessage(util.permissionMessage("&c--> You need the permission", "&beasymotd.permissions"));
                            else
                                sender.sendMessage(util.color("&b=======[&ePermissions&b]======="));
                                sender.sendMessage(util.color("&7easymotd.* &b&l--&b&l> &bGrants all access to the plugin. \n" +
                                    "&7easymotd.reload &8&l--&b&l> &bGrants permission to reload the plugin. \n" +
                                    "&7easymotd.command &8&l--&b&l> &bGrants permission for base command. \n" +
                                    "&7easymotd.list &8&l--&b&l> &bAllows you to list the messages.\n" +
                                    "&7easymotd.set &8&l--&b&l> &bAllows you to set In-game messages.\n" +
                                    "&7easymotd.setlist &8&l--&b&l> &bSet the server list motd.\n" +
                                    "&7easymotd.help &8&l--&b&l> &bAllows access to help.\n" +
                                    "&7easymotd.permissions &b&l--&b&l> &bAllows access to permissions.\n" +
                                    "&6easymotd.staff &8&l--&b&l> &bAllows user to be displayed on staff list."));
                            break;

                        case "config":
                            if(!sender.hasPermission("easymotd.config")) sender.sendMessage(util.permissionMessage("&c--> You need the permission","&beasymotd.config"));
                            else
                                sender.sendMessage(util.color("&b=======[&eConfiguration&b]======="));
                                sender.sendMessage(util.color("This section explains all of the configuration options available.\n" +
                                        "&6All of these functions can be used inside the commands.\n" +
                                        "&6%newline% &7&l--&8&l> &aUse this to start writing a new line.\n" +
                                        "&6%player% &7&l--&8&l> &aGets the current player (Yourself).\n" +
                                        "&6%staff% &7&l--&8&l> &aGets all of the online staff members. &cPermission: &6&oeasymotd.staff\n" +
                                        "&6%users% &7&l--&8&l> &aGets all online players.\n" +
                                        "&6%time% &7&l--&8&l> &aGets the time of the server."));
                        default:
                            sender.sendMessage(util.color(util.getPrefix() + "&c--> &bIncorrect arguments passed. &f/em help"));
                            break;
                    }
                }
            }
        }
        return true;
    }
}
