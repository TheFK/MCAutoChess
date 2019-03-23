package main.Mode;

import main.Interface.SpecialItemsGenerator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ChessPlayer {
    private int playernumber;
    private Player p;
    private Location spawn;
    private int money;
    private int xp;
    private int level;

    public ChessPlayer(Player p, int playernumber) {
        this(p, playernumber, null);
    }

    public ChessPlayer(Player p, int playernumber, Location spawn) {
        this.playernumber = playernumber;
        this.p = p;
        this.spawn = spawn;
        this.money = 1;
        this.xp = 0;
        this.level = 1;
        refreshPlayerInformation();
    }

    public int getPlayernumber() {
        return playernumber;
    }

    public Player getPlayer() {
        return p;
    }

    public Location getSpawn() {
        return spawn;
    }

    public int getMoney() {
        return money;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addXp(int amount) {
        this.xp = this.xp + amount;
        refreshLevel();
    }

    public void addMoney(int amount) {
        this.money = this.money + money;
        refreshPlayerInformation();
    }

    public void refreshLevel(){
        if(xp >= 0 && xp < 1){
            this.level = 1;
        }
        else if(xp >= 1 && xp < 2){
            this.level = 2;
        }
        else if(xp >= 2 && xp < 4){
            this.level = 3;
        }
        else if(xp >= 4 && xp < 8){
            this.level = 4;
        }
        else if(xp >= 8 && xp < 16){
            this.level = 5;
        }
        else if(xp >= 16 && xp < 32){
            this.level = 6;
        }
        else if(xp >= 32 && xp < 56){
            this.level = 7;
        }
        else if(xp >= 56 && xp < 88){
            this.level = 8;
        }
        else if(xp >= 88 && xp < 128){
            this.level = 9;
        }
        else if(xp >= 128){
            this.level = 10;
        }
    }

    public void refreshPlayerInformation(){
        SpecialItemsGenerator sigen = new SpecialItemsGenerator();

        this.p.getInventory().setItem(44,new ItemStack(Material.DIAMOND,this.money));
        this.p.updateInventory();
        this.p.setLevel(this.level);
    }
}
