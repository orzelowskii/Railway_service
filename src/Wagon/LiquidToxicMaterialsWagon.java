package Wagon;

public class LiquidToxicMaterialsWagon extends HeavyFreightWagon{

    private int volume;
    private int weightOfm3;
    private int radiationLevel;
    private boolean isDangerous;

    public LiquidToxicMaterialsWagon(String sender, int weightNet, int weightGross, security level) {
        super(sender, weightNet, weightGross, level);
    }

    public LiquidToxicMaterialsWagon() {
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
        double weight = Math.random()*(13)+8;
        this.weightOfm3 = (int)weight;
        double volume = Math.random()*(130)+80;
        this.volume = (int)volume;
        double is = Math.random();
        this.isDangerous = is > 0.5;
        double level = Math.random()*(10)+1;
        this.radiationLevel = (int)level;
    }
    @Override
    public String toString() {
        return "*********************************" + "\n" +
                "Liquid Toxic Materials Wagon" + "\n" +
                "ID - " + id + "\n" +
                "sender - " + getSender() + "\n" +
                "Net weight - " + getWeightNet() + "\n" +
                "Gross weight - " + getWeightGross() + "\n" +
                "Security level - " + getLevel() + "\n" +
                "Connection to elecrticity network - " + isConnectionToElectricityNetwork() + "\n" +
                "Loaded - " + isLoaded() + "\n" +
                "Is outdoor - " + isOutdoor() + "\n" +
                "Max lenght of freight - " + getMaxLenghtOfFreight() + "\n" +
                "weight - " + weightOfm3 + " kg/m3" + "\n" +
                "Volume - " + volume + " m3" + "\n" +
                "Is dangerous - " + isDangerous + "\n" +
                "Radiation level on scale 1-10 - " + radiationLevel + "\n" +
                "*********************************" + "\n";
    }
}
