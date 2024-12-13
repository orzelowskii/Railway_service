package Wagon;

public class PassangerWagon extends Wagon{

    private int numOfSittingPlaces;
    private int numOfToilets;

    public PassangerWagon(String sender, int weightNet, int weightGross, security security, int numOfSittingPlaces,int numOfToilets) {
        super(sender, weightNet, weightGross, security);
        this.numOfSittingPlaces = numOfSittingPlaces;
        this.numOfToilets = numOfToilets;
        super.id = counter;
        super.connectionToElectricityNetwork = true;
        super.loaded = false;
    }

    public PassangerWagon(){
        super.id = ++counter;
        String[] names = {"Krokus","Artus","Goplana","Mewa","Posejdon","Sawa","Tetmajer","Wisla","Tatry","Pieniny","Mickiewicz","Slowacki"};
        double x = Math.random() * (names.length - 1);
        super.setSender(names[(int)x]);
        double net = Math.random()*(6000)+2000;
        super.setWeightNet((int)net);
        double gross = Math.random()*(7000)+5000;
        super.setWeightGross((int)gross);
        super.setLevel(security.mid);
        super.setConnectionToElectricityNetwork(true);
        super.loaded = false;
        double numOfSitting = Math.random()*(100-25)+100;
        this.numOfSittingPlaces = (int)numOfSitting;
        this.numOfToilets = 2;
    }

    @Override
    public String toString() {
        if(isLoaded()){
            return "*********************************" + "\n" +
                    "Passanger Wagon" + "\n" +
                    "ID - " + id + "\n" +
                    "sender - " + getSender() + "\n" +
                    "Net weight - " + getWeightNet() + "\n" +
                    "Gross weight - " + getWeightGross() + "\n" +
                    "Security level - " + getLevel() + "\n" +
                    "Connection to elecrticity network - " + isConnectionToElectricityNetwork() + "\n" +
                    "Loaded - " + isLoaded() + "\n" +
                    "Number of sitting places - " + numOfSittingPlaces + "\n" +
                    "Number of people in wagon - " + numOfSittingPlaces + "\n" +
                    "Number of toilets - " + numOfToilets + "\n" +
                    "*********************************" + "\n";
        }else {
            return "*********************************" + "\n" +
                    "Passanger Wagon" + "\n" +
                    "ID - " + id + "\n" +
                    "sender - " + getSender() + "\n" +
                    "Net weight - " + getWeightNet() + "\n" +
                    "Gross weight - " + getWeightGross() + "\n" +
                    "Security level - " + getLevel() + "\n" +
                    "Connection to elecrticity network - " + isConnectionToElectricityNetwork() + "\n" +
                    "Loaded - " + isLoaded() + "\n" +
                    "Number of sitting places - " + numOfSittingPlaces + "\n" +
                    "Number of toilets - " + numOfToilets + "\n" +
                    "*********************************" + "\n";
        }
    }

    public boolean isLoaded() {
        return loaded;
    }

    @Override
    public int getId() {
        return super.getId();
    }

}
