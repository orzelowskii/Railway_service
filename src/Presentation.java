import Exepctions.TooHeavyTrainExepction;
import Exepctions.TooManyElectricWagons;
import Exepctions.TooManyWagons;
import Wagon.Wagon;
import Wagon.PassangerWagon;
import Wagon.FreightWagon;
import Wagon.RestaurantWagon;

import java.util.ArrayList;

public class Presentation {
    public static void main(String[] args) throws TooHeavyTrainExepction, TooManyWagons, TooManyElectricWagons {

        StationGrid stationGrid = new StationGrid();
        Station s1 = new Station(stationGrid);
        Station s2 = new Station(stationGrid);
        Station s3 = new Station(stationGrid);
        Station s4 = new Station(stationGrid);
        Station s5 = new Station(stationGrid);
        Station s6 = new Station(stationGrid);
        Station s7 = new Station(stationGrid);
        Station s8 = new Station(stationGrid);
        Station s9 = new Station(stationGrid);
        Station s10 = new Station(stationGrid);

        ArrayList<Station> stations = new ArrayList<>();
        stations.add(s1);
        stations.add(s2);
        stations.add(s3);
        stations.add(s4);
        stations.add(s5);
        stations.add(s6);
        stations.add(s7);
        stations.add(s8);
        stations.add(s9);
        stations.add(s10);

        PathFinding pathFinding = new PathFinding(stationGrid);

        Locomotive l1 = new Locomotive("Krokus" , s1,s2,s5,6,30000,3,120);
        Locomotive l2 = new Locomotive("Polon" , s1,s1,s4,10,350000,3,120);
        ArrayList<Locomotive> locomotives = new ArrayList<>();
        locomotives.add(l1);
        locomotives.add(l2);


        Wagon w1 = new PassangerWagon("nowak",3000,6000, Wagon.security.mid,86,2);
        Wagon w2 = new FreightWagon("kaszub",3000,5000, Wagon.security.high);
        Wagon w3 = new RestaurantWagon("siekiera",4000,7000, Wagon.security.mid);

        Wagon w4 = new RestaurantWagon("gora",4000,7000, Wagon.security.mid);
        Wagon w5 = new FreightWagon("krzys",4000,12000, Wagon.security.mid);
        Wagon w6 = new FreightWagon("kowal",4000,4000, Wagon.security.mid);
        Wagon w7 = new FreightWagon("kowal",4000,4000, Wagon.security.mid);


        ArrayList<Wagon> wagons1 = new ArrayList<>();
        wagons1.add(w1);
        wagons1.add(w2);
        wagons1.add(w3);

        ArrayList<Wagon> wagons2 = new ArrayList<>();
        wagons2.add(w4);
        wagons2.add(w5);
        wagons2.add(w6);

        ArrayList<Wagon> wagons = new ArrayList<>();
        wagons.add(w1);
        wagons.add(w2);
        wagons.add(w3);
        wagons.add(w4);
        wagons.add(w5);
        wagons.add(w6);

        TrainComposition trainComposition1 = new TrainComposition(l1,wagons1,stationGrid);
        TrainComposition trainComposition2 = new TrainComposition(l2,wagons2,stationGrid);

        trainComposition2.addWagon(l2,w7);

        ArrayList<TrainComposition> tc = new ArrayList<>();
        tc.add(trainComposition1);
        tc.add(trainComposition2);

        System.out.println(stationGrid.toString().replaceAll("[\\[\\]\\{\\},=]", ""));


        Printing printing = new Printing(tc);
        printing.start();
        Menu menu = new Menu();
        menu.menu(stationGrid,tc,locomotives,wagons,stations);
        printing.stopRunning();

    }
}
