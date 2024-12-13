package Wagon;

public class MailWagon extends Wagon{

    private int maxNumOfLetters;
    private boolean isInterstate;
    public MailWagon(String sender, int weightNet, int weightGross, security level, int maxNumOfLetters, boolean isInterstate) {
        super(sender, weightNet, weightGross, level);
        this.maxNumOfLetters = maxNumOfLetters;
        this.isInterstate = isInterstate;
    }

    public MailWagon() {
        super.id = ++counter;
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
        double letters = Math.random()*(10000-5000)+10000;
        this.maxNumOfLetters = (int)letters;
        double is = Math.random();
        this.isInterstate = is > 0.5;
    }

    @Override
    public String toString() {
        return "*********************************" + "\n" +
                "Mail Wagon" + "\n" +
                "ID - " + id + "\n" +
                "sender - " + getSender() + "\n" +
                "Net weight - " + getWeightNet() + "\n" +
                "Gross weight - " + getWeightGross() + "\n" +
                "Security level - " + getLevel() + "\n" +
                "Connection to elecrticity network - " + isConnectionToElectricityNetwork() + "\n" +
                "Loaded - " + isLoaded() + "\n" +
                "Max number of letters - " + maxNumOfLetters + "\n" +
                "Interstate - " + isInterstate + "\n" +
                "*********************************" + "\n";
    }

    public int getMaxNumOfLetters() {return maxNumOfLetters;}

    public boolean isInterstate() {return isInterstate;}
}
