package Exepctions;

public class TooManyWagons extends Throwable {
    public TooManyWagons(int maxNumOfWagons) {
        super("Maximum number of wagons is " + maxNumOfWagons);
    }
}
