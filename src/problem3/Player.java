package problem3;

import java.util.List;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', hitPoints=" + hitPoints + ", strength=" + strength + ", weapon='" + weapon + "'}";
    }

    @Override
    public List<String> write() {
        return List.of(this.name, String.valueOf(this.hitPoints),
                String.valueOf(this.strength), this.weapon);
    }

    @Override
    public void read(List<String> l) {
        if(l==null || l.size() != 4)return;
        name = l.get(0);
        hitPoints = Integer.parseInt(l.get(1));
        strength = Integer.parseInt(l.get(2));
        weapon = l.get(3);
    }
}
