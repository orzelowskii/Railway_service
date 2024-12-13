package Wagon;

public class FreightWagon extends Wagon{

    private boolean isOutdoor;
    private int maxLenghtOfFreight;

    public FreightWagon(String sender, int weightNet, int weightGross, security level) {
        super(sender, weightNet, weightGross, level);
        super.id = counter;
    }

    public FreightWagon() {
        super.id = ++counter;
        String[] names = {"Krokus","Artus","Goplana","Mewa","Posejdon","Sawa","Tetmajer","Wisla","Tatry","Pieniny","Mickiewicz","Slowacki"};
        double x = Math.random() * (names.length - 1);
        super.setSender(names[(int)x]);
        double net = Math.random()*(8000-2000)+8000;
        super.setWeightNet((int)net);
        double gross = Math.random()*(12000-5000)+12000;
        super.setWeightGross((int)gross);
        super.setLevel(security.high);
        super.setConnectionToElectricityNetwork(false);
        super.loaded = false;
        double is = Math.random();
        this.isOutdoor = is > 0.5;
        double lenght = Math.random()*(13)+8;
        this.maxLenghtOfFreight = (int)lenght;
    }

    @Override
    public String toString() {
        return "*********************************" + "\n" +
                "Freight Wagon" + "\n" +
                "ID - " + id + "\n" +
                "sender - " + getSender() + "\n" +
                "Net weight - " + getWeightNet() + "\n" +
                "Gross weight - " + getWeightGross() + "\n" +
                "Security level - " + getLevel() + "\n" +
                "Connection to elecrticity network - " + isConnectionToElectricityNetwork() + "\n" +
                "Loaded - " + isLoaded() + "\n" +
                "Is outdoor - " + isOutdoor + "\n" +
                "Max lenght of freight - " + maxLenghtOfFreight + "\n" +
                "*********************************" + "\n";
    }

    public boolean isOutdoor() {return isOutdoor;}

    public int getMaxLenghtOfFreight() {return maxLenghtOfFreight;}
}
