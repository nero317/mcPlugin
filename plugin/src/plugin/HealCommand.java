package plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("plugin.heal")) {
            sender.sendMessage(ChatColor.RED + "권한이 없습니다.");
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "플레이어만 사용 가능합니다.");
        }
        Player player = (Player) sender;

        player.setHealth(player.getHealthScale());
        player.setFoodLevel(20);
        player.setFireTicks(0);
        return true;
    }

}
