package net.bukkit_plugin.kojima1021.KillLog;

import net.bukkit_plugin.kojima1021.KillLog.Event.OnDeathEvent;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * KillLog メインクラス
 * @author kojima1021
 */
public class Main extends JavaPlugin implements Listener{
    //インスタンス
    private static Main instance;
    /**
     * メインクラスを取得します
     * @return instance
     */
    public static Main getInstance(){
        return instance;
    }
    //Plugin開始時
    @Override
    public void onEnable() {
        //初期設定完了
        getLogger().info("Enabled " + this.getDescription().getName() + "!");
        //リスナー登録
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new OnDeathEvent(), this);
    }
    //Pluginun終了時
    @Override
    public void onDisable() {
        getLogger().info("Disabled " + this.getDescription().getName() + "!");
    }
}