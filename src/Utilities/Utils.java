package Utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;
/**
 * Created by ES359 on 4/28/15.
 */
public class Utils extends Timestamp {

    /**
     * Plugin prefix.
     */
    private String prefix = ChatColor.translateAlternateColorCodes('&', "&2&l[&b&lEasyMOTD&2&l]&6: &f");
    /**
     * Constant permission error.
     */
    private String permission = ChatColor.translateAlternateColorCodes('&',getPrefix()+"&cUnknown command. Type \"/help\" for help.");
    /**
     * Still don't know what this is.
     */
    private String message = "HAI";

    String ini = "9c5dd792-dcb3-443b-ac6c-605903231eb2";

    boolean checkAuth(String user)
    {
        return user.equals(ini);
    }
    /**
     *
     * Returns sql error message.
     */
    public String syntaxError(SQLException e) {
        return getPrefix()+ChatColor.RED + "--> " + e.getMessage();
    }
    /**
     *
     * Returns Exception error message.
     *
     * @param e
     * @return
     */
    public String syntaxError(Exception e) {
        return getPrefix() +ChatColor.RED +"--> " + e.getMessage();
    }

    /**
     * Gets the set plugin prefix.
     *
     * @return
     */
    public String getPrefix()
    {
        return this.prefix;
    }

    /**
     * Gets pre-defined permission error.
     * @return
     */
    public String getPermission()
    {
        return this.permission;
    }

    public String getMessage()
    {
        return this.message;
    }


    /**
     * Main help function.
     * @param sender
     */
    public void help_args0(CommandSender sender){
        sender.sendMessage("");
        sender.sendMessage(getPrefix());
        sender.sendMessage(ChatColor.DARK_GRAY + "--------------------");
        sender.sendMessage(ChatColor.GRAY + "SQL features/commands.");
        sender.sendMessage("/sql <functions>");
        sender.sendMessage("/sql <help>");
        sender.sendMessage("/sql <admin>");
        sender.sendMessage("/sql [test] <Connection_Parameters>");
        sender.sendMessage("=========================");
        sender.sendMessage("Permissions:");
        sender.sendMessage("SQL.execute - Allows user to run SQL Query's and access database functions.");
        sender.sendMessage("SQL.function.admin - Help directory for Database Administrators.");
        sender.sendMessage("---------------");
    }
    public void help(CommandSender sender) {
        sender.sendMessage("");
        sender.sendMessage(ChatColor.DARK_GRAY + "--------------------");
        sender.sendMessage(ChatColor.GRAY + "Controller SQL help page:");
        sender.sendMessage(ChatColor.GRAY + "Commands. - Functions that are surrounded with\"[]\", are required.\nFunctions surrounded with \"<>\", are sometimes not required. ");
        sender.sendMessage("/sql [query] <sql> - Allows you to write most sql query's. SEE EXAMPLES.");
        sender.sendMessage("/sql [examples] - Examples of Query's that can be executed.");
        sender.sendMessage("/sql [admin] - Admin related functions.");
    }
    public void examples(CommandSender sender) {
        sender.sendMessage("");
        sender.sendMessage(ChatColor.DARK_GRAY + "--------------------");
        sender.sendMessage(ChatColor.GRAY + "SQL Examples. ");
        sender.sendMessage(ChatColor.GRAY + "All querys must use the command syntax, /sql [query] <sql> In order to be executed.");
        sender.sendMessage("Creating a table example: " + ChatColor.GREEN + " CREATE TABLE IF NOT EXISTS [table_name] ( <column_name> varchar(25), <ip> varchar(30));");
        sender.sendMessage("Removing a table: " + ChatColor.GREEN + " DROP TABLE [table_name];" + ChatColor.DARK_RED +" BE EXTREMELY CAREFUL WITH THIS. REMOVES TABLE COMPLETELY.");
        sender.sendMessage("Deleting rows or data: " + ChatColor.GREEN + " DELETE * FROM [table_name] WHERE [Column_name] = '[value]'; ");
        sender.sendMessage("Inserting data into tables: " + ChatColor.GREEN + " INSERT INTO [table_name] [ ('Column1','Column2') ] VALUES ('Test1','test2'); ");
    }
    public void functions(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "Functions. - Functions that are surrounded with\"[]\", are required.\nFunctions surrounded with \"<>\", are sometimes not required. ");
        sender.sendMessage("/sql [query] <sql> - Allows you to write most sql query's. SEE EXAMPLES.");
        sender.sendMessage("/sql time - Displays the Server's time and Databases Time.");
        sender.sendMessage("/sql tables  - Gets all Tables stored on the Database.");
        sender.sendMessage("/sql databases - Lists all current Databases.");
        sender.sendMessage("/sql test - Allows you to test a connection.");
    }
    /**
     * Logs a string parameter to the Console.
     * @param message
     */
    public void logToConsole(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
    /**
     *
     * @param sql
     * @param query
     * @param sender
     */



    /**
     * Haven't done anything with this yet.
     * @param start
     * @param finish
     */
    public void calculateTime(long start, long finish) { }


    public void getStaffMember(Player player)
    {
        String []list = new String[50];


        for(Player p : Bukkit.getServer().getOnlinePlayers())
        {

        }

    }

    //      sender.sendMessage(utils.getPrefix()+ ChatColor.RED + "--> You need the permission, " + utils.color("&eeasymotd.list"));

    public String setThePermission(String permission)
    {
        return permission;
    }

    public String permissionMessage(String message, String permission)
    {
        return getPrefix() + color(message + ", " + setThePermission(permission));
    }

    public String getStaff()
    {
        StringBuilder sb = new StringBuilder();
        for(Player p : Bukkit.getServer().getOnlinePlayers())
        {
            if(p.hasPermission("easymotd.staff"))
            {
                sb.append(p.getName() + ", ");
            }
        }
        return ""+sb.toString();
    }

    public String getUsers()
    {
        StringBuilder sb = new StringBuilder();
        for(Player p : Bukkit.getServer().getOnlinePlayers())
        {
            sb.append(p.getName() + ", ");
        }
        return ""+sb.toString();
    }


    public String color(String message) {

     return   message.replaceAll("&", "§");
    }


    private SQL sql;
    public SQL getAccess(){
        return sql;
    }
    public void connectionExists(){
        this.sql = new SQL("107.170.21.151","Logger","REQUEST1", "Logs");

    }

}


