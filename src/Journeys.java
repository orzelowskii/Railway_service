import java.util.ArrayList;

public class Journeys extends Thread {


    ArrayList<Connection> journey = new ArrayList<>();
    private int percentOfRoadBeetweenTwoStations;
    private int percentOfRoadBetweenStartEnd;
    private double distanceBetweenStartEnd;
    private double speedOfTrain;
    private int numOfConnections;
    private Station starting;
    private Station destination;
    private Station current;
    private int cycle;
    private boolean running = true;
    private Connection currentConnection;
    private static String monitor = new String();

    public Journeys(TrainComposition trainComposition, StationGrid stationGrid) {

        PathFinding pathFinding = new PathFinding(stationGrid);
        this.journey = pathFinding.pathFinding(trainComposition.starting, trainComposition.destination);
        this.starting = journey.get(0).getStarting();
        this.destination = journey.get(journey.size() - 1).getDestination();
        this.current = starting;
        double tmp = 0;
        for (Connection c : journey) {
            tmp = tmp + c.distance;
        }
        this.distanceBetweenStartEnd = tmp;
        this.speedOfTrain = trainComposition.getSpeedOfTrain();
        this.numOfConnections = pathFinding.getNumOfConnections();

    }

    @Override
    public void run() {
        int tmp = 0;
        while (running) {
            try {
                while (tmp < numOfConnections) {

                    int numOfCycle;
                    cycle = 1;

                    double timeToNextStation = (getDistanceBetweenNeighbors(journey.get(tmp)) / speedOfTrain);
                    numOfCycle = (int) (timeToNextStation * 3600);
                    for (int i = 0; i < numOfCycle; i++) {
                        Thread.sleep(1000);
                        synchronized (monitor) {
                            percentOfRoadBeetweenTwoStations = (cycle * 100) / numOfCycle;
                            cycle++;
                            percentOfRoadBetweenStartEnd = (tmp * 100) / numOfConnections;
                        }
                        if(!running){
                            break;
                        }
                    }
                    if(!running){
                        break;
                    }
                    current = getNextStation(journey, current);
                    Thread.sleep(2000);
                    tmp++;
                }
                if(!running){
                    break;
                }
                tmp=0;
                Thread.sleep(30000);
                journey = reverse(journey);
                current = journey.get(0).getStarting();
            } catch (InterruptedException e) {
                e.notifyAll();
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

    public ArrayList<Connection> reverse(ArrayList<Connection> connections) {
        ArrayList<Connection> tmp = new ArrayList<>();
        for (int i = connections.size() - 1; i >= 0; i--) {
            Connection c = connections.get(i).reverseConnection();
            tmp.add(c);
        }
        return tmp;
    }

    public void stopRunning() {
        running = false;
    }

    public double getDistanceBetweenNeighbors(Connection connection) {
        return connection.getDistance();
    }

    public int getPercentOfRoadBeetweenTwoStations() {
        return percentOfRoadBeetweenTwoStations;
    }

    public int getPercentOfRoadBetweenStartEnd() {
        return percentOfRoadBetweenStartEnd;
    }

    public double getSpeedOfTrain() {return speedOfTrain;}

    public Connection getCurrentConnection() {return currentConnection;}
}
