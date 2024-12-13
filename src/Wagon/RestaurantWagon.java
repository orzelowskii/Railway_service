package Wagon;

public class RestaurantWagon extends Wagon{

    private boolean isMeatServing;
    private int numOfStoolsInBar;

    public RestaurantWagon(String sender, int weightNet, int weightGross, security level) {
        super(sender, weightNet, weightGross, level);
        super.id = counter;
    }

    public RestaurantWagon() {
        super.id = ++counter;
        String[] names = {"Krokus","Artus","Goplana","Mewa","Posejdon","Sawa","Tetmajer","Wisla","Tatry","Pieniny","Mickiewicz","Slowacki"};
        double x = Math.random() * (names.length - 1);
        super.setSender(names[(int)x]);
        double net = Math.random()*(8000-2000)+8000;
        super.setWeightNet((int)net);
        double gross = Math.random()*(12000-5000)+12000;
        super.setWeightGross((int)gross);
        super.setLevel(security.mid);
        super.setConnectionToElectricityNetwork(true);
        super.loaded = false;
        double stools = (Math.random()*7)+2;
        this.numOfStoolsInBar = (int)stools;
        double meat = Math.random();
        this.isMeatServing = meat > 0.5;
    }



    @Override
    public String toString() {
        return "*********************************" + "\n" +
                "Restaurant wagon" + "\n" +
                "ID - " + id + "\n" +
                "sender - " + getSender() + "\n" +
                "Net weight - " + getWeightNet() + "\n" +
                "Gross weight - " + getWeightGross() + "\n" +
                "Security level - " + getLevel() + "\n" +
                "Loaded - " + isLoaded() + "\n" +
                "*********************************" + "\n";
    }
}
