import java.util.ArrayList;

public class Station {

    private int id;
    private static int counter = 1;

    public Station(StationGrid stationGrid) {
        this.id = counter++;
        if(id != 1){
            double tmp = Math.random() * (stationGrid.stations.size());
            ArrayList<Integer> checked = new ArrayList<Integer>();
            for(int i = 0;i<tmp;i++) {
                double x = Math.random() * (stationGrid.stations.size() - 1);
                if(!checked.contains((int)x)) {
                    Station s = stationGrid.stations.get((int) x);
                    stationGrid.addConnection(s, this);
                    stationGrid.addConnection(this,s);
                }
                checked.add((int)x);
            }

        }
        stationGrid.stations.add(this);
    }


    @Override
    public String toString() {
        return "Station: " + id;
    }

    public int getId() {return id;}
}
