package Wagon;

public class RefrigeratedWagon extends FreightWagon{

    private int numOfRefrigerators;
    private int temp;

    public RefrigeratedWagon(String sender, int weightNet, int weightGross, security level) {
        super(sender, weightNet, weightGross, level);
    }

    public RefrigeratedWagon() {
        super.id = counter;
        String[] names = {"Krokus","Artus","Goplana","Mewa","Posejdon","Sawa","Tetmajer","Wisla","Tatry","Pieniny","Mickiewicz","Slowacki"};
        double x = Math.random() * (names.length - 1);
        super.setSender(names[(int)x]);
        double net = Math.random()*(8000-2000)+8000;
        super.setWeightNet((int)net);
        double gross = Math.random()*(12000-5000)+12000;
        super.setWeightGross((int)gross);
        super.setLevel(security.high);
        super.setConnectionToElectricityNetwork(true);
        super.loaded = false;
        double temp = Math.random()*(13)+8;
        this.temp = (int)temp;
        double num = Math.random()*(13)+8;
        this.numOfRefrigerators = (int)num;
    }

    @Override
    public String toString() {
        return "*********************************" + "\n" +
                "Refrigerated Wagon" + "\n" +
                "ID - " + id + "\n" +
                "sender - " + getSender() + "\n" +
                "Net weight - " + getWeightNet() + "\n" +
                "Gross weight - " + getWeightGross() + "\n" +
                "Security level - " + getLevel() + "\n" +
                "Connection to elecrticity network - " + isConnectionToElectricityNetwork() + "\n" +
                "Loaded - " + isLoaded() + "\n" +
                "Is outdoor - " + isOutdoor() + "\n" +
                "Max lenght of freight - " + getMaxLenghtOfFreight() + "\n" +
                "Temperature - " + temp + "\n" +
                "Number of refrigerators - " + numOfRefrigerators + "\n" +
                "*********************************" + "\n";
    }
}
