import java.util.ArrayList;
import java.util.HashMap;

public class StationGrid {
    HashMap<Station, ArrayList<Connection>> connectionGraph;
    public ArrayList<Station> stations;

    public StationGrid() {
        this.connectionGraph = new HashMap<Station,ArrayList<Connection>>();
        this.stations = new ArrayList<Station>();
    }

    public void addConnection(Station s1,Station s2){
        if(!connectionGraph.containsKey(s1)){
            connectionGraph.put(s1,new ArrayList<>());
            connectionGraph.get(s1).add(new Connection(s1,s2));
        }else {
            connectionGraph.get(s1).add(new Connection(s1,s2));
        }
        if(!stations.contains(s1)){
            stations.add(s1);
        }
        if(!stations.contains(s2)){
            stations.add(s2);
        }

    }

    public void addStationToGrid(Station station,StationGrid stationGrid){
        stationGrid.stations.add(station);
    }

    public void removeConnection(Station station){
        connectionGraph.remove(station);
        for(ArrayList<Connection> connections : connectionGraph.values()){
            for(int i = connections.size()-1;i>=0;i--){
                Connection c = connections.get(i);
                if(c.getDestination().equals(station) || c.getStarting().equals(station)){
                    connections.remove(c);
                }
            }
        }
    }

    public ArrayList<Connection> getConnections(Station station){
        return connectionGraph.getOrDefault(station,new ArrayList<>());
    }

    @Override
    public String toString() {
        return "StationGrid" + "\n" +
                "connectionGraph" +"\n" + connectionGraph + "\n" ;
    }

    public Connection getConnection(Station starting, Station destination) {
        for(Connection c : connectionGraph.get(starting)){
            if(c.getDestination().equals(destination)){
                return c;
            }
        }
        return null;
    }
}