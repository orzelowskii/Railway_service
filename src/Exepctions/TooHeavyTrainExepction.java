package Exepctions;

public class TooHeavyTrainExepction extends Throwable {
    public TooHeavyTrainExepction(int weight){
        super("Max torsion of locomitive is " + weight + " kg");
    }
}
