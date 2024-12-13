package Wagon;

public class BaggageMailWagon extends MailWagon{

    private int ratioLetter;
    private int ratioBaggege;

    public BaggageMailWagon(String sender, int weightNet, int weightGross, security level, int maxNumOfLetters, boolean isInterstate) {
        super(sender, weightNet, weightGross, level,maxNumOfLetters,isInterstate);
    }

    public BaggageMailWagon(){
        super.id = counter;
        String[] names = {"Krokus","Artus","Goplana","Mewa","Posejdon","Sawa","Tetmajer","Wisla","Tatry","Pieniny","Mickiewicz","Slowacki"};
        double x = Math.random() * (names.length - 1);
        super.setSender(names[(int)x]);
        double net = Math.random()*(8000-2000)+8000;
        super.setWeightNet((int)net);
        double gross = Math.random()*(12000-5000)+12000;
        super.setWeightGross((int)gross);
        super.setLevel(security.mid);
        super.setConnectionToElectricityNetwork(false);
        super.loaded = false;
        double ratio1 = (Math.random()*10)+1;
        double ratio2 = (Math.random()*10)+1;
        this.ratioLetter = (int)ratio1;
        this.ratioBaggege = (int)ratio2;
    }

    @Override
    public String toString() {
        return "*********************************" + "\n" +
                "Baggage Mail Wagon" + "\n" +
                "ID - " + id + "\n" +
                "sender - " + getSender() + "\n" +
                "Net weight - " + getWeightNet() + "\n" +
                "Gross weight - " + getWeightGross() + "\n" +
                "Security level - " + getLevel() + "\n" +
                "Connection to elecrticity network - " + isConnectionToElectricityNetwork() + "\n" +
                "Loaded - " + isLoaded() + "\n" +
                "Max number of letters - " + getMaxNumOfLetters() + "\n" +
                "Interstate - " + isInterstate() + "\n" +
                "Ratio between Baggeges and letters - " + ratioBaggege + ":" + ratioLetter + "\n" +
                "*********************************" + "\n";
    }
}
