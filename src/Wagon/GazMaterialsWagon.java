package Wagon;

public class GazMaterialsWagon extends FreightWagon{

    private boolean isExplosive;
    private int pressure;

    public GazMaterialsWagon(String sender, int weightNet, int weightGross, security level) {
        super(sender, weightNet, weightGross, level);
    }

    public GazMaterialsWagon() {
        super.id = counter;
        String[] names = {"Krokus","Artus","Goplana","Mewa","Posejdon","Sawa","Tetmajer","Wisla","Tatry","Pieniny","Mickiewicz","Slowacki"};
        double x = Math.random() * (names.length - 1);
        super.setSender(names[(int)x]);
        double net = Math.random()*(8000-2000)+8000;
        super.setWeightNet((int)net);
        double gross = Math.random()*(12000-5000)+12000;
        super.setWeightGross((int)gross);
        super.setLevel(security.master);
        super.setConnectionToElectricityNetwork(false);
        super.loaded = false;
        double is = Math.random();
        this.isExplosive = is > 0.5;
        double pressure = Math.random()*(5)+2;
        this.pressure = (int)pressure;
        }

    @Override
    public String toString() {
        return "*********************************" + "\n" +
                "Gaz Materials Wagon" + "\n" +
                "ID - " + id + "\n" +
                "sender - " + getSender() + "\n" +
                "Net weight - " + getWeightNet() + "\n" +
                "Gross weight - " + getWeightGross() + "\n" +
                "Security level - " + getLevel() + "\n" +
                "Connection to elecrticity network - " + isConnectionToElectricityNetwork() + "\n" +
                "Loaded - " + isLoaded() + "\n" +
                "Is outdoor - " + isOutdoor() + "\n" +
                "Max lenght of freight - " + getMaxLenghtOfFreight() + "\n" +
                "Is explosive - " + isExplosive + "\n" +
                "Pressure - " + pressure + " MPa" + "\n" +
                "*********************************" + "\n";
    }
}
