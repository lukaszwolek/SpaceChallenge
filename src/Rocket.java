public class Rocket implements SpaceShip {

    private int rocketCost;        //koszt rakiety
    private int rocketWeight;    //waga samej rakiety
    private int rocketWithCargoWeight;   //aktualna waga z towarem
    private int rocketMaxWeight;  //maksymalna waga z towarem
    private int weightOfItem;       //waga Itemu
    //private double chanceOfLaunch;   //prawdopod. katastrofy przy starcie
    //private double chanceOfLand;       //prawdopod. katastrofy przy lądowaniu


    public boolean launch () {
        return true;
    }

    public boolean land () {
        return true;
    }

    public void setRocketCost (int cost) { this.rocketCost = cost; }
    public void setRocketWeight (int weight) {
        this.rocketWeight = weight;
    }
    public int getRocketCost () {
        return rocketCost;
    }
    public int getRocketWeight () {
        return rocketWeight;
    }
    public void setRockedMaxWeight (int maxWeight) {
        this.rocketMaxWeight = maxWeight;
    }
    public int getRocketMaxWeight () {
        return rocketMaxWeight;
    }
    public void setRocketWithCargoWeight (int rocketWithCargoWeight) {this.rocketWithCargoWeight = rocketWithCargoWeight;}
    public int getRocketWithCargoWeight () {return rocketWithCargoWeight;}
    public void setWeightOfItem (Item item) {
        this.weightOfItem = item.Weight;
    }
    public int getWeightOfItem () { return weightOfItem; }
    //public void setChanceOfLaunch (double chanceOfLaunch) {this.chanceOfLaunch = chanceOfLaunch;}
    //public double getChanceOfLaunch () {return chanceOfLaunch;}
    //public void setChanceOfLand (double chanceOfLand) {this.chanceOfLaunch = chanceOfLand;}
    //public double getChanceOfLand () {return chanceOfLand;}


    public void setNewWeight (Item item) {
        this.rocketWeight = rocketWeight + item.Weight;
    }

    public boolean canCarry (Item item) {
        if (item.Weight + rocketWithCargoWeight <= rocketMaxWeight ) {
            //System.out.println("Waga itemu: "+item.Weight+ " Aktualna masa statku: "+rocketWithCargoWeight);
            return true;
        } else  {
            //System.out.println("Przeładowanie");
            return false;
        }
    }

    public void carry(Item item) {
        setRocketWithCargoWeight(getRocketWithCargoWeight() + item.getWeight());
    }
}

class U1 extends Rocket {
    double chanceOfLaunch = 0.05;
    double chanceOfLand = 0.01;
    U1()  {
        setRocketCost(100000000);   //$
        setRocketWeight(10000);
        setRocketWithCargoWeight(10000);
        setRockedMaxWeight(18000);
        //setChanceOfLaunch(0.05);//*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight())));
        //setChanceOfLand(0.01);//*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight())));
    }
    @Override
    public boolean launch () {
        double randomNumber = Math.random();
        //System.out.println("Szansa na eksplozje przy starcie: "+chanceOfLaunch*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight())));
        //System.out.println("Random: "+randomNumber);
        //System.out.println("Waga towaru: "+(getRocketWithCargoWeight()-getRocketWeight()));
        if ((chanceOfLaunch*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight()))) <= randomNumber) {
            return true;
        }  else  {
            return false;
        }
    }
    @Override
    public boolean land () {
        double randomNumber = Math.random();
        //System.out.println("Szansa na eksplozje przy ladowaniu: "+chanceOfLand*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight())));
        //System.out.println("Random: "+randomNumber);
        //System.out.println("Waga towaru: "+(getRocketWithCargoWeight()-getRocketWeight()));
        if ((chanceOfLand*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight()))) <= randomNumber) {
            return true;
        }  else  {
            return false;
        }
    }


}
class U2 extends Rocket {
    double chanceOfLaunch = 0.04;
    double chanceOfLand = 0.08;
    U2()  {
        setRocketCost(120000000);   //$
        setRocketWeight(18000);
        setRocketWithCargoWeight(18000);
        setRockedMaxWeight(29000);
        //setChanceOfLaunch(0.04);//*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight())));
        //setChanceOfLand(0.08);//*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight())));
    }
    @Override
    public boolean launch () {
        double randomNumber = Math.random();
        //System.out.println("Szansa na eksplozje przy starcie: "+chanceOfLaunch*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight())));
        //System.out.println("Random: "+randomNumber);
        //System.out.println("Waga towaru: "+(getRocketWithCargoWeight()-getRocketWeight()));
        if ((chanceOfLaunch*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight()))) <= randomNumber) {
            return true;
        }  else  {
            return false;
        }
    }
    @Override
    public boolean land () {
        double randomNumber = Math.random();
        //System.out.println("Szansa na eksplozje przy ladowaniu: "+chanceOfLand*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight())));
        //System.out.println("Random: "+randomNumber);
        //System.out.println("Waga towaru: "+(getRocketWithCargoWeight()-getRocketWeight()));
        if ((chanceOfLand*((double)(getRocketWithCargoWeight() - getRocketWeight())/ (double)(getRocketMaxWeight() - getRocketWeight()))) <= randomNumber) {
            return true;
        }  else  {
            return false;
        }
    }


}


