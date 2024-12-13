import Exepctions.TooHeavyTrainExepction;
import Exepctions.TooManyElectricWagons;
import Exepctions.TooManyWagons;
import Wagon.Wagon;
import Wagon.FreightWagon;
import Wagon.PassangerWagon;
import Wagon.RefrigeratedWagon;
import Wagon.RestaurantWagon;
import Wagon.HeavyFreightWagon;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        StationGrid stationGrid = new StationGrid();

        ArrayList<Station> stations = new ArrayList<>();
        for(int i = 0;i<100;i++){
            Station station = new Station(stationGrid);
            stations.add(station);
        }

        PathFinding pathFinding = new PathFinding(stationGrid);

        ArrayList<Locomotive> locomotives = new ArrayList<>();
        for(int i = 0;i<25;i++){
            Locomotive locomotive = new Locomotive(stationGrid);
            locomotives.add(locomotive);
        }

        ArrayList<TrainComposition> trainCompositions = new ArrayList<>();
        ArrayList<Wagon> wagons = new ArrayList<>();

        for(int i = 0;i<locomotives.size();i++){
            double numOfWagons = Math.random()*6+5;
            ArrayList<Wagon> tmp = new ArrayList<>();
            for(int j = 0;j<(int)numOfWagons;j++){
                if((i+j) % 5 == 0){
                    Wagon wagon = new FreightWagon();
                    wagons.add(wagon);
                    tmp.add(wagon);
                } else if ((i+j) % 4 == 0) {
                    Wagon wagon = new HeavyFreightWagon();
                    wagons.add(wagon);
                    tmp.add(wagon);
                }else if ((i+j) % 3 == 0) {
                    Wagon wagon = new RefrigeratedWagon();
                    wagons.add(wagon);
                    tmp.add(wagon);
                }else if ((i+j) % 2 == 0) {
                    Wagon wagon = new PassangerWagon();
                    wagons.add(wagon);
                    tmp.add(wagon);
                }else{
                    Wagon wagon = new RestaurantWagon();
                    wagons.add(wagon);
                    tmp.add(wagon);
                }
            }
            TrainComposition trainComposition;
            try {
                trainComposition = new TrainComposition(locomotives.get(i),tmp,stationGrid);
            } catch (TooHeavyTrainExepction e) {
                throw new RuntimeException(e);
            } catch (TooManyElectricWagons e) {
                throw new RuntimeException(e);
            } catch (TooManyWagons e) {
                throw new RuntimeException(e);
            }
            trainCompositions.add(trainComposition);
        }

        Printing printing = new Printing(trainCompositions);
        printing.start();
        Menu menu = new Menu();
        menu.menu(stationGrid,trainCompositions,locomotives,wagons,stations);
        printing.stopRunning();


    }
}
