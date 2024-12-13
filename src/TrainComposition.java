import Exepctions.RailroadHazardExepction;
import Exepctions.TooHeavyTrainExepction;
import Exepctions.TooManyElectricWagons;
import Exepctions.TooManyWagons;
import Wagon.Wagon;

import java.util.*;


public class TrainComposition implements Comparable<TrainComposition>{

    Map<Locomotive,ArrayList<Wagon>> trainComposition = new LinkedHashMap<>();
    ArrayList<Wagon> wagons = new ArrayList<>();
    Journeys journeys;
    Speed speed;
    public double wholeDistance;
    private double speedOfTrain;
    private int id;
    private static int counter = 1;
    int weightOfWagons;
    int numOfWagons;
    int numOfElectricWagons;
    Station starting;
    Station destination;
    Station current;

    public TrainComposition(Locomotive locomotive, ArrayList<Wagon> tmp, StationGrid stationGrid) throws TooHeavyTrainExepction,TooManyElectricWagons,TooManyWagons {


        trainComposition.put(locomotive,wagons);
        weightOfWagons = 0;
        numOfWagons = 0;
        numOfElectricWagons = 0;

        starting = locomotive.getStarting();
        destination = locomotive.getDestination();
        current = starting;
        speedOfTrain = locomotive.getSpeed();


        int x = 0;
        if (tmp.get(0).isConnectionToElectricityNetwork()) {
            x = 1;
        }

        try{
            for(int i = 0;i < tmp.size();i++){
                    if(locomotive.getMaxWeightOfTorsion() > (weightOfWagons + tmp.get(i).getWeightGross())){
                        if(locomotive.getMaxNumOfWagons() > (numOfWagons + 1) ){
                            if(locomotive.getMaxNumOfElectricWagons() > (numOfElectricWagons + x)){
                                trainComposition.get(locomotive).add(tmp.get(i));
                                weightOfWagons = weightOfWagons + tmp.get(i).getWeightGross();
                                numOfWagons++;
                                if(tmp.get(i).isConnectionToElectricityNetwork()){
                                    numOfElectricWagons++;
                                }
                            }else {
                                throw new TooManyElectricWagons(locomotive.getMaxNumOfElectricWagons());
                            }
                        }else {
                            throw new TooManyWagons(locomotive.getMaxNumOfWagons());
                        }
                    }else {
                        throw new TooHeavyTrainExepction(locomotive.getMaxWeightOfTorsion());
                    }
            }
        }catch (TooHeavyTrainExepction e){
            e.printStackTrace();
        } catch (TooManyWagons e) {
            e.printStackTrace();
        } catch (TooManyElectricWagons e) {
            e.printStackTrace();
        }
        this.id = counter++;
        PathFinding pathFinding = new PathFinding(stationGrid);
        ArrayList<Connection> connections = pathFinding.pathFinding(locomotive.getStarting(),locomotive.getDestination());
        double tmpDistance = 0;
        for(Connection c : connections){
            tmpDistance = tmpDistance + c.getDistance();
        }
        this.wholeDistance = tmpDistance;
        this.journeys = new Journeys(this,stationGrid);
        journeys.start();
        this.speed = new Speed(this,locomotive);
        speed.start();
    }


    public void addWagon(Locomotive locomotive,Wagon wagon)throws TooHeavyTrainExepction,TooManyElectricWagons,TooManyWagons {
        int tmp = 0;
        if (wagon.isConnectionToElectricityNetwork()) {
            tmp = 1;
        }
        try {
            if (locomotive.getMaxWeightOfTorsion() > (getWeightOfWagons(locomotive) + wagon.getWeightGross())) {
                if (locomotive.getMaxNumOfWagons() > getNumOfWagons(locomotive)) {
                    if (locomotive.getMaxNumOfElectricWagons() > (getNumOfElectricWagons(locomotive) + tmp)) {
                        trainComposition.get(locomotive).add(wagon);
                        weightOfWagons = weightOfWagons + wagon.getWeightGross();
                        numOfWagons++;
                        if (wagon.isConnectionToElectricityNetwork()) {
                            numOfElectricWagons++;
                        }
                    } else {
                        throw new TooManyElectricWagons(locomotive.getMaxNumOfElectricWagons());
                    }
                } else {
                    throw new TooManyWagons(locomotive.getMaxNumOfWagons());
                }
            } else {
                throw new TooHeavyTrainExepction(locomotive.getMaxWeightOfTorsion());
            }
        } catch (TooHeavyTrainExepction e) {
            e.printStackTrace();
        } catch (TooManyWagons e) {
            e.printStackTrace();
        } catch (TooManyElectricWagons e) {
            e.printStackTrace();
        }
    }

    public Map<Locomotive, ArrayList<Wagon>> getTrainComposition() {
        return trainComposition;
    }

    @Override
    public String toString() {
        return "\n" +"TRAIN COMPOSIOTION - ID " + id + "\n" +
                "Whole distance - " + wholeDistance + "\n" +
                "Distance already traveled to next Station - " + journeys.getPercentOfRoadBeetweenTwoStations() + " %" + "\n" +
                "Distance already traveled - " + journeys.getPercentOfRoadBetweenStartEnd() + " %" + "\n" +
                trainComposition + "\n";
    }

    public double getSpeedOfTrain() {return speedOfTrain;}

    public int getWeightOfWagons(Locomotive locomotive) {
        int weight = 0;
        for(Wagon w : trainComposition.get(locomotive)){
            weight = weight + w.getWeightGross();
        }
        return weight;
    }

    public int getNumOfWagons(Locomotive locomotive) {
        int num = 0;
        for(Wagon w : trainComposition.get(locomotive)){
            num++;
        }
        return num;
    }

    public int getNumOfElectricWagons(Locomotive locomotive) {
        int num = 0;
        for(Wagon w : trainComposition.get(locomotive)){
            if(w.isConnectionToElectricityNetwork()){
                num++;
            }
        }
        return num;
    }

    public Journeys getJourneys() {return journeys;}

    public Speed getSpeed() {return speed;}

    @Override
    public int compareTo(TrainComposition o) {
        return (int)(this.wholeDistance *1000) - (int)(o.wholeDistance *1000);
    }


    public int getId() {return id;}

}
