import Exepctions.RailroadHazardExepction;

import java.util.ArrayList;

public class Locomotive {

    private String name;
    private Station mother;

    private int id;
    private static int counter = 1;

    private Station starting;
    private Station destination;

    private int maxNumOfWagons;
    private int maxWeightOfTorsion;
    private int maxNumOfElectricWagons;
    private double speed;

    public Locomotive(String name, Station mother , Station starting, Station destination,
                      int maxNumOfCarraiges, int maxWeightOfTorsion, int maxNumOfElectricCarriges, double speed) {

        this.name = name;
        this.mother = mother;
        this.starting = starting;
        try{
            if(starting.equals(destination)){
                throw new IllegalArgumentException("stacja docelowa taka sama jak poczatkowa");
            }else {
                this.destination = destination;
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        this.maxNumOfWagons = maxNumOfCarraiges;
        this.maxWeightOfTorsion = maxWeightOfTorsion;
        try{
            if(maxNumOfElectricCarriges > maxNumOfCarraiges){
                throw new IllegalArgumentException("Liczba wagonow elektrycznych wieksza niz ogolna dostepn ilosc wagonow");
            }else {
                this.maxNumOfElectricWagons = maxNumOfElectricCarriges;
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        this.speed = speed;

        this.id = counter++;

    }

    public Locomotive(StationGrid stationGrid){
        this.id = counter++;
        String[] names = {"Krokus","Artus","Goplana","Mewa","Posejdon","Sawa","Tetmajer","Wisla","Tatry","Pieniny","Mickiewicz","Slowacki"};
        double name = Math.random() * (names.length);
        this.name = names[(int)name];
        double mother = Math.random()*(stationGrid.stations.size());
        this.mother = stationGrid.stations.get((int)mother);
        double start = Math.random()*(stationGrid.stations.size());
        this.starting = stationGrid.stations.get((int)start);
        boolean tmp = false;
        double end;
        do{
            tmp = false;
            end = Math.random()*(stationGrid.stations.size());
            try {
                if((int)end == (int)start){
                    tmp = true;
                    throw new IllegalArgumentException("stacja docelowa taka sama jak poczatkowa");
                }else {
                    this.destination = stationGrid.stations.get((int)end);
                }
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }while(tmp);
        double maxNumOfWagons = Math.random()*10+20;
        this.maxNumOfWagons = (int)maxNumOfWagons;
        double maxTorsion = (Math.random()*260000)+150000;
        this.maxWeightOfTorsion = (int)maxTorsion;
        double electric = Math.random()*10+12;
        this.maxNumOfElectricWagons = (int)electric;
        this.speed = Math.random()*31+100;
    }

    public void changeStartingStation(StationGrid stationGrid,Locomotive locomotive){
        int tmp = stationGrid.stations.size();
        double newStation = (Math.random()*tmp)+1;
        locomotive.setStarting(stationGrid.stations.get((int)newStation-1));

    }

    public void changeDestinationStation(StationGrid stationGrid,Locomotive locomotive){
        int tmp = stationGrid.stations.size();
        double newStation = (Math.random()*tmp)+1;
        locomotive.setDestination(stationGrid.stations.get((int)newStation-1));
    }

    @Override
    public String toString() {
        return "*********************************" + "\n" +
                "Locomotive " + "\n" +
                "ID - " + id + "\n" +
                "name - '" + name + "' " + "\n" +
                "mother - " + mother + "\n" +
                "starting station - " + starting + "\n" +
                "destination station - " + destination + "\n" +
                "maximum number of carriges - " + maxNumOfWagons + "\n" +
                "maximum Weight Of Torsion - " + maxWeightOfTorsion + " Kg" + "\n" +
                "maximum Number Of Electric Carriges - " + maxNumOfElectricWagons + "\n" +
                "speed - " + (int)speed + "\n" +
                "*********************************" + "\n";
    }

    public String getName() {return name;}

    public int getId() {return id;}

    public double getSpeed() {return speed;}

    public int getMaxWeightOfTorsion() {return maxWeightOfTorsion;}

    public int getMaxNumOfElectricWagons() {return maxNumOfElectricWagons;}

    public int getMaxNumOfWagons() {return maxNumOfWagons;}

    public Station getStarting() {return starting;}

    public Station getDestination() {return destination;}

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setStarting(Station starting) {this.starting = starting;}

    public void setDestination(Station destination) {this.destination = destination;}
}
