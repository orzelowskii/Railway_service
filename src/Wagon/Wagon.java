package Wagon;

public class Wagon implements Comparable<Wagon>{

    public enum security{low,mid,high,master}

    private security level;
    private String sender;
    private int weightNet;
    private int weightGross;
    protected boolean connectionToElectricityNetwork;
    protected boolean loaded;
    protected int id;
    protected static int counter = 0;

    public Wagon(String sender, int weightNet, int weightGross, security level) {
        this.sender = sender;
        this.weightNet = weightNet;
        this.weightGross = weightGross;
        this.id = counter++;
        this.level = level;
    }
    public Wagon(){}

    @Override
    public int compareTo(Wagon wagon) {
        return this.weightGross - wagon.weightGross;
    }



    public String getSender() {
        return sender;
    }

    public int getWeightNet() { return weightNet; }

    public int getWeightGross() {
        return weightGross;
    }

    public boolean isConnectionToElectricityNetwork() {return connectionToElectricityNetwork;}

    public int getId() {
        return id;
    }

    public security getLevel() { return level; }

    public boolean isLoaded() {return loaded;}

    public void setSender(String sender) {this.sender = sender;}

    public void setLevel(security level) {
        this.level = level;
    }

    public void setWeightNet(int weightNet) {
        this.weightNet = weightNet;
    }

    public void setWeightGross(int weightGross) {
        this.weightGross = weightGross;
    }

    public void setConnectionToElectricityNetwork(boolean connectionToElectricityNetwork) {
        this.connectionToElectricityNetwork = connectionToElectricityNetwork;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setCounter(int counter) {
        Wagon.counter = counter;
    }
}