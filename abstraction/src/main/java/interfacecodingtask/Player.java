package interfacecodingtask;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
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
    public List<String> write() {
        List<String> result = new ArrayList<>();
        result.add(name);
        result.add(String.valueOf(hitPoints));
        result.add(String.valueOf(strength));
        result.add(weapon);
        return result;
    }

    @Override
    public void read(List<String> data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        name = data.get(0);
        hitPoints = Integer.parseInt(data.get(1));
        strength = Integer.parseInt(data.get(2));
        weapon = data.get(3);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon +
                "'}";
    }
}
