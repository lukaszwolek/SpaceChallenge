import java.util.ArrayList;

public class Main {
    public static void main (String [] args) throws Exception{

        //int budget;

        Simulation simulation = new Simulation();

        System.out.println("LOADING............");

        ArrayList<Item> list1Items = simulation.loadListOfItems1();
        ArrayList<Item> list2Items = simulation.loadListOfItems2();

        System.out.println("Pliki wczytane prawidlowo");


        //System.out.println(list1Items);

        //System.out.println(list2Items);


        ArrayList<Rocket> rocket1phase1 = simulation.loadU1(list1Items);
        System.out.println("Wczytuje drugi zestaw przedmiotów");
        ArrayList<Rocket> rocket1phase2 = simulation.loadU1(list2Items);
        list1Items=simulation.loadListOfItems1();
        list2Items=simulation.loadListOfItems2();
        ArrayList<Rocket> rocket2phase1 = simulation.loadU2(list1Items);
        System.out.println("Wczytuje drugi zestaw przedmiotów");
        ArrayList<Rocket> rocket2phase2 = simulation.loadU2(list2Items);

        //System.out.println("Symulacja rakiety U1 z pierwszym zestawem: "+simulation.RunSimulation(rocket1phase1));
        //System.out.println("Symulacja rakiety U1 z drugim zestawem: "+simulation.RunSimulation(rocket1phase2));
        //System.out.println("Symulacja rakiety U2 z pierwszym zestawem: "+simulation.RunSimulation(rocket2phase1));
        //System.out.println("Symulacja rakiety U2 z drugim zestawem: "+simulation.RunSimulation(rocket2phase2));

        System.out.println("---------------------------------------------");
        System.out.println("Koszt misji z rakietami U1 : "+ (simulation.RunSimulation(rocket1phase2)+simulation.RunSimulation(rocket1phase1)));
        System.out.println("Koszt misji z rakietami U2 : "+ (simulation.RunSimulation(rocket2phase2)+simulation.RunSimulation(rocket2phase1)));

    }
}
