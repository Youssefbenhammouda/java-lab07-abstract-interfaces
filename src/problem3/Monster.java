package problem3;

import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Monster{name='" + name + "', hitPoints=" + hitPoints + ", strength=" + strength + "}";
    }

    @Override
    public List<String> write() {
        return List.of(this.name, String.valueOf(this.hitPoints),
                String.valueOf(this.strength));
    }

    @Override
    public void read(List<String> l) {
        if(l==null || l.size() != 3)return;
        name = l.get(0);
        hitPoints = Integer.parseInt(l.get(1));
        strength = Integer.parseInt(l.get(2));


    }
}
