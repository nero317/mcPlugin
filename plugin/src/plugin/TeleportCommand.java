package plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "플레이어만 사용 가능합니다.");
            return false;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "플레이어를 입력하세요.");
            return false;
        }

        if (target == null) {
            player.sendMessage(ChatColor.RED + "존재하지않는 플레이어입니다.");
            return false;
        }

        player.teleport(target.getLocation());
        return true;
    }
}
