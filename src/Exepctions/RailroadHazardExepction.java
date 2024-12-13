package Exepctions;

public class RailroadHazardExepction extends Throwable {
    public RailroadHazardExepction(double speed,int id){

        super("Speed od train is " + speed + " !!!" + "\n" +
                "Train Compositions - ID " +  id + "\n" );
    }
}
