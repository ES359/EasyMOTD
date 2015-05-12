package me.ES359.EasyMOTD;

import Commands.EMListCommand;
import Commands.EMSetCommand;
import Commands.EMSetListCommand;
import Commands.EasyMOTDCommand;
import Events.Join;
import Events.ServerList;
import Utilities.Updater;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ES359 on 5/11/15.
 */
public class EMotd extends JavaPlugin
{

   public PluginDescriptionFile pdfFile = this.getDescription();

    /**
     * Make sure to fix chat restrictions system with updated code.
     *
     * AKA default message for incorrect arguments passed.
     *
     */

    public void onEnable()
    {
        Bukkit.getServer().getPluginManager().registerEvents(new ServerList(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Join(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Updater(), this);
        this.getCommand("easymotd").setExecutor(new EasyMOTDCommand(this));
        this.getCommand("emlist").setExecutor(new EMListCommand(this));
        this.getCommand("emset").setExecutor(new EMSetCommand(this));
        this.getCommand("emsetlist").setExecutor(new EMSetListCommand(this));
        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }

    boolean joinEnabled = this.getConfig().getBoolean("Messages.show-motd");

    public boolean isJoinEnabled()
    {
        return this.joinEnabled;
    }


}
