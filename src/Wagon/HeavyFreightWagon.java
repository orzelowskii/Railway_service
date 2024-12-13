package Wagon;

public class HeavyFreightWagon extends FreightWagon{

    private int maxWeightOfEachElement;
    private boolean builtInExcavetor;

    public HeavyFreightWagon(String sender, int weightNet, int weightGross, security level) {
        super(sender, weightNet, weightGross, level);
    }

    public HeavyFreightWagon() {
        super.id = counter;
        String[] names = {"Krokus","Artus","Goplana","Mewa","Posejdon","Sawa","Tetmajer","Wisla","Tatry","Pieniny","Mickiewicz","Slowacki"};
        double x = Math.random() * (names.length - 1);
        super.setSender(names[(int)x]);
        double net = Math.random()*(8000)+18000;
        super.setWeightNet((int)net);
        double gross = Math.random()*(30000-12000)+30000;
        super.setWeightGross((int)gross);
        super.setLevel(security.high);
        super.setConnectionToElectricityNetwork(false);
        super.loaded = false;
        double is = Math.random();
        this.builtInExcavetor = is > 0.5;
        double weight = Math.random()*(13)+8;
        this.maxWeightOfEachElement = (int)weight;
    }

    @Override
    public String toString() {
        return "*********************************" + "\n" +
                "Heavy freight Wagon" + "\n" +
                "ID - " + id + "\n" +
                "sender - " + getSender() + "\n" +
                "Net weight - " + getWeightNet() + " \n" +
                "Gross weight - " + getWeightGross() + "\n" +
                "Security level - " + getLevel() + "\n" +
                "Connection to elecrticity network - " + isConnectionToElectricityNetwork() + "\n" +
                "Loaded - " + isLoaded() + "\n" +
                "Is outdoor - " + isOutdoor() + "\n" +
                "Max lenght of freight - " + getMaxLenghtOfFreight() + "\n" +
                "Built-in Excavator - " + builtInExcavetor + "\n" +
                "Max weight od each element - " + maxWeightOfEachElement + "\n" +
                "*********************************" + "\n";
    }
}
