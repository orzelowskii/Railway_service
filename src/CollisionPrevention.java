import java.util.ArrayList;

public class CollisionPrevention extends Thread{


    ArrayList<TrainComposition> trainCompositions ;

    private final static String monitor = new String();
    private boolean running = true;

    public CollisionPrevention(ArrayList<TrainComposition> trainCompositions) {
        this.trainCompositions = trainCompositions;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            for (TrainComposition tc : trainCompositions) {
                if(!running){
                    break;
                }
                for(TrainComposition tc2 : trainCompositions) {
                    if(!running){
                        break;
                    }
                    if(!tc.equals(tc2)) {
                        if (tc.current.equals(tc2.current) && getNextStation(tc2.journeys.journey, tc2.current).equals(getNextStation(tc.journeys.journey, tc2.current))) {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    try {
                        Thread.sleep((int) (tc.journeys.getDistanceBetweenNeighbors(tc.journeys.getCurrentConnection()) / (int) tc.journeys.getSpeedOfTrain()));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    monitor.notifyAll();
                }
            }
        }





    }
    public Station getNextStation(ArrayList<Connection> route, Station current) {
        Station next = null;
        for (Connection c : route) {
            if (c.getStarting().equals(current)) {
                next = c.getDestination();
            }
        }
        return next;
    }
    public void stopRunning() {
        running = false;
    }
}
