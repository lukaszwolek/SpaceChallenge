import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class Simulation {

    ArrayList<Item> loadListOfItems1 () throws Exception {
        File file1 = new File("phase1.txt");
        Scanner scan1 = new Scanner(file1);
        System.out.println("plik 1 wczytywany");
        ArrayList<Item> items = new ArrayList<>();

        while (scan1.hasNextLine())  {
            String line = scan1.nextLine();
            String[] item1 = line.split("=");
            items.add(new Item(item1[0], Integer.valueOf(item1[1])));

        }

        return items;
    }
    ArrayList<Item> loadListOfItems2 () throws Exception {
        File file2 = new File("phase2.txt");
        Scanner scan2 = new Scanner(file2);
        System.out.println("plik 2 wczytywany");
        ArrayList<Item> items = new ArrayList<>();

        while (scan2.hasNextLine())  {
            String line = scan2.nextLine();
            String[] item1 = line.split("=");
            items.add(new Item(item1[0], Integer.valueOf(item1[1])));

        }
        return items;
    }
    ArrayList<Rocket> loadU1 (ArrayList<Item> list) {
        ArrayList<Rocket> rocketsU1 = new ArrayList<>();

        Rocket rocket = new U1();
        int numberOfRocketsU1 = 1;
        int numberOfItems = 0;
        int l =0;

        int sum = 0;
        for (Item item :list)  {
            sum = sum + item.Weight;
        }

        while (sum !=0) {

            for (Item item : list) {
                    l++;
                if (rocket.canCarry(item)) {

                    rocket.carry(item);
                    //System.out.println("Zaladowano na rakiete U1 element nr " + (l + 1) + " o wadze " + item.Weight);
                    sum = sum - item.Weight;
                    item.Weight = 0;
                    numberOfItems++;

                }
                if (l == 15) {
                    rocketsU1.add(rocket);
                    rocket = new U1();
                    System.out.println("Dodano rakiete U1");
                    numberOfRocketsU1 = numberOfRocketsU1 + 1;
                    System.out.println("Aktualna ilosc rakiet: " + numberOfRocketsU1);
                    l = 0;
                }
            }
        }
        System.out.println("Zaladowano "+numberOfRocketsU1+" rakiet typu U1");
        return rocketsU1;
    }

    ArrayList<Rocket> loadU2 (ArrayList<Item> list) {

        ArrayList<Rocket> rocketsU2 = new ArrayList<>();

        Rocket rocket = new U2 ();
        int numberOfRocketsU2 = 1;

        int numberOfItems = 0;
        int l =0;
        int sum = 0;
        for (Item item :list)  {
            sum = sum + item.Weight;
        }

        while (sum !=0) {

            for (Item item : list) {
                l++;
                if (rocket.canCarry(item)) {

                    rocket.carry(item);

                    sum = sum - item.Weight;
                    item.Weight = 0;
                    numberOfItems++;

                }
                if (l == 15) {
                    rocketsU2.add(rocket);
                    rocket = new U2();
                    System.out.println("Dodano rakiete U2");
                    numberOfRocketsU2 = numberOfRocketsU2 + 1;
                    System.out.println("Aktualna ilosc rakiet: " + numberOfRocketsU2);
                    l = 0;
                }
            }
        }
        System.out.println("Zaladowano "+numberOfRocketsU2+" rakiet typu U2");
        return rocketsU2;
    }
    int RunSimulation (ArrayList<Rocket> rocket)  {
        int budget = 0;
        for (Rocket r  : rocket)  {
            if (r.launch() && r.land())  {
                budget = budget + r.getRocketCost();
            }
        }
        return budget;
    }
}
