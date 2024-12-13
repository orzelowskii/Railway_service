import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PathFinding {

    HashMap<Station,Boolean> checked;
    StationGrid stationGrid;
    ArrayList<Connection> route;
//    private int numOfStations;

    public PathFinding(StationGrid stationGrid){
        checked = new HashMap<>();
        this.stationGrid = stationGrid;
    }

    public ArrayList<Connection> pathFinding(Station starting, Station destination){
        ArrayList<Station> stations = new ArrayList<>();
        finding(starting,destination,stations);
//        numOfStations = stations.size();
        route = convert(stations);
        return route;
    }

    private boolean finding(Station current , Station destination , ArrayList<Station> stations){
        checked.put(current,true);
        stations.add(current);
        if(destination.equals(current)){
            return true;
        }else {
            for(Connection connections : stationGrid.getConnections(current)){
                Station next = connections.getDestination();
                if(!checked.containsKey(next)){
                    if(finding(next,destination,stations)){
                        return true;
                    }
                }
            }
            stations.remove(stations.size() - 1);
            return false;
        }
    }

    private ArrayList<Connection> convert(ArrayList<Station> stations) {
        ArrayList<Connection> route = new ArrayList<>();
        if(stations.size() == 2){
         Station starting = stations.get(0);
         Station destination = stations.get(1);
         Connection c = stationGrid.getConnection(starting,destination);
         route.add(c);
        }else {
            for (int i = 0; i < stations.size() - 1; i++) {
                ArrayList<Connection> currentConnections = stationGrid.getConnections(stations.get(i));
                for (Connection c : currentConnections) {
                    if (c.getDestination().equals(stations.get(i + 1))) {
                        route.add(c);
                        break;
                    }
                }
            }
        }
        return route;
    }


//    public int getNumOfStations() {return numOfStations;}
     public int getNumOfConnections() {return route.size();}


}