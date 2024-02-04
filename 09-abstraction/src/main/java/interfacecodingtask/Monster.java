package interfacecodingtask;

import java.util.ArrayList;
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
    public List<String> write() {
        List<String> result = new ArrayList<>();
        result.add(name);
        result.add(String.valueOf(hitPoints));
        result.add(String.valueOf(strength));
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
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}
