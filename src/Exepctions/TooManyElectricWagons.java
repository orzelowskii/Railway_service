package Exepctions;

public class TooManyElectricWagons extends Throwable {
    public TooManyElectricWagons(int maxNumOfElectricWagons) {
        super("Maximum number of electric wagons is " + maxNumOfElectricWagons);
    }
}
