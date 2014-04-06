package net.bukkit_plugin.kojima1021.KillLog.Event;

import java.util.Calendar;
import java.util.Locale;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeathEvent implements Listener {

	/**
	 * KillLog Eventクラス
	 * PlayerDeathEvent
	 * @author kojima1021
	 */
	@EventHandler
    public void death(PlayerDeathEvent e) {
		 if (e.getEntity().getKiller() != null){
		    e.getEntity().getPlayer().getServer().getLogger().info("");
		    String prefix = ChatColor.RED + "[" + ChatColor.WHITE + "PVPLog" + ChatColor.RED + "]" + ChatColor.RESET;
		    Calendar.getInstance(Locale.JAPAN);
		    Calendar now = Calendar.getInstance();
		    int h = now.get(now.HOUR_OF_DAY);//時を取得
		    int m = now.get(now.MINUTE);     //分を取得
		    int s = now.get(now.SECOND);      //秒を取得
		    int a = (int) e.getEntity().getKiller().getHealth();
		    int b = (int) 2;
		    e.setDeathMessage(prefix + "  "+e.getEntity().getPlayer().getName() + "は" + e.getEntity().getKiller().getName() + "に殺された。   時刻 "+ h+"時"+m+"分"+s+"秒" );
		    e.getEntity().getKiller().sendMessage(prefix +" あなたは、" + e.getEntity().getPlayer().getName() + " を倒した。   (自分の残りのハートの数は " +a / b +"個です。 )" );
		    return;
		 }else {
			e.setDeathMessage(e.getDeathMessage());
			}
	}
}
