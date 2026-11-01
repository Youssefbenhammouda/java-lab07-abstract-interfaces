package problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim);
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Stormbringer");
        saveObject(tim);

        List<String> saved = tim.write();
        tim.setHitPoints(0);
        tim.setWeapon("Stick");
        System.out.println("After damage: " + tim);
        loadObject(tim, saved);
        System.out.println("After load:   " + tim);

        System.out.println();

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
        System.out.println(werewolf);
        saveObject(werewolf);

        System.out.println();
        System.out.println("Enter new monster values:");
        loadObject(werewolf, readValues());
        System.out.println(werewolf);
    }

    public static void saveObject(ISaveable objectToSave) {
        for (String value : objectToSave.write()) {
            System.out.println("Saving " + value + " to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad, List<String> values) {
        objectToLoad.read(values);
    }

    public static List<String> readValues() {
        List<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 to enter a value, 0 to quit");
        while (true) {
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) {
                break;
            }
            if (choice.equals("1")) {
                System.out.print("Value: ");
                values.add(scanner.nextLine());
            }
        }
        return values;
    }
}
