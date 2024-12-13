import Exepctions.TooHeavyTrainExepction;
import Exepctions.TooManyElectricWagons;
import Exepctions.TooManyWagons;
import Wagon.Wagon;
import Wagon.PassangerWagon;
import Wagon.RestaurantWagon;
import Wagon.MailWagon;
import Wagon.BaggageMailWagon;
import Wagon.FreightWagon;
import Wagon.HeavyFreightWagon;
import Wagon.RefrigeratedWagon;
import Wagon.LiquidMaterialsWagon;
import Wagon.GazMaterialsWagon;
import Wagon.ExplosiveMaterialsWagon;
import Wagon.ToxicMaterialsWagon;
import Wagon.LiquidToxicMaterialsWagon;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    private ArrayList<TrainComposition> trainCompositions = new ArrayList<>();
    private ArrayList<Locomotive> signedLocomotives = new ArrayList<>();
    private ArrayList<Locomotive> unSignedLocomitives = new ArrayList<>();
    private ArrayList<Wagon> signedWagons = new ArrayList<>();
    private ArrayList<Wagon> unSignedWagon = new ArrayList<>();
    private ArrayList<Wagon> loadedWagons = new ArrayList<>();
    private ArrayList<Wagon> unLoadedWagons = new ArrayList<>();
    private ArrayList<Station> stations = new ArrayList<>();

    public void menu(StationGrid stationGrid,ArrayList<TrainComposition> trainCompositions,ArrayList<Locomotive> locomotives,ArrayList<Wagon> wagons,ArrayList<Station> stations){

        this.signedLocomotives = locomotives;
        this.signedWagons = wagons;
        this.unLoadedWagons = wagons;
        this.stations = stations;
        this.trainCompositions = trainCompositions;

        System.out.println("   ***MENU***");

        System.out.println("1. -> Nowa Lokomotywa");
        System.out.println("2. -> Nowy Wagon");
        System.out.println("3. -> Nowa Stacja");
        System.out.println("4. -> Przypisz wagon do lokomotywy");
        System.out.println("5. -> Załaduj Wagon");
        System.out.println("6. -> Rozładuj Wagon");
        System.out.println("7. -> Usun Lokomotywe");
        System.out.println("8. -> Usun Wagon");
        System.out.println("9. -> Usun Stacje");
        System.out.println("10. -> Usun Pociag");
        System.out.println("11. -> Nowy Pociag");
        System.out.println("12. -> Wyswietl dane o Pociagu");
        System.out.println("13. -> KONIEC");
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Wybierz opcje: ");
        int option;
        option = scanner.nextInt();

        switch (option){
            case 1 :
                createLocomotive(stationGrid);
                break;
            case 2 :
                createWagon(stationGrid);
                break;
            case 3 :
                createStation(stationGrid);
                break;
            case 4 :
                assignLocomotiveToWagon(stationGrid);
                break;
            case 5 :
                load(stationGrid);
                break;
            case 6 :
                unLoad(stationGrid);
                break;
            case 7 :
                removeLocomotive(stationGrid);
                break;
            case 8 :
                removeWagon(stationGrid);
                break;
            case 9 :
                removeStation(stationGrid,locomotives);
                break;
            case 10 :
                removeTrain(stationGrid);
                break;
            case 11 :
                createTrain(stationGrid);
                break;
            case 12 :
                displayTrain(stationGrid);
                break;
            case 13 :
                System.out.println("     END");
                endProgram();
            default:
                break;
        }

    }

    private void createLocomotive(StationGrid stationGrid){
        Locomotive locomotive = new Locomotive(stationGrid);
        if(!locomotive.getDestination().equals(locomotive.getStarting())){
            unSignedLocomitives.add(locomotive);
            menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
        }else {
            menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
        }
    }

    private void createWagon(StationGrid stationGrid) {
        System.out.println("1. -> Passanger Wagon");
        System.out.println("2. -> Restaurant Wagon");
        System.out.println("3. -> Freight Wagon");
        System.out.println("4. -> Mail Wagon");
        System.out.println("5. -> Baggage-Mail Wagon");
        System.out.println("6. -> Heavy Freight Wagon");
        System.out.println("7. -> Refrigerated Wagon");
        System.out.println("8. -> Liquid Materials wagon");
        System.out.println("9. -> Gas Materials Wagon");
        System.out.println("10. -> Explosive Materials Wagon");
        System.out.println("11. -> Toxic Materials Wagon");
        System.out.println("12. -> Liquid-Toxic Materials Wagon");
        System.out.println();
        System.out.print("Wyebirz rodzaj wagonu: ");
        Scanner scanner1 = new Scanner(System.in);
        int wagonType = scanner1.nextInt();
        switch (wagonType) {
            case 1:
                Wagon wagon = new PassangerWagon();
                unSignedWagon.add(wagon);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 2:
                Wagon wagon1 = new RestaurantWagon();
                unSignedWagon.add(wagon1);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 3:
                Wagon wagon2 = new FreightWagon();
                unSignedWagon.add(wagon2);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 4:
                Wagon wagon3 = new MailWagon();
                unSignedWagon.add(wagon3);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 5:
                Wagon wagon4 = new BaggageMailWagon();
                unSignedWagon.add(wagon4);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 6:
                Wagon wagon5 = new HeavyFreightWagon();
                unSignedWagon.add(wagon5);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 7:
                Wagon wagon6 = new RefrigeratedWagon();
                unSignedWagon.add(wagon6);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 8:
                Wagon wagon7 = new LiquidMaterialsWagon();
                unSignedWagon.add(wagon7);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 9:
                Wagon wagon8 = new GazMaterialsWagon();
                unSignedWagon.add(wagon8);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 10:
                Wagon wagon9 = new ExplosiveMaterialsWagon();
                unSignedWagon.add(wagon9);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 11:
                Wagon wagon10 = new ToxicMaterialsWagon();
                unSignedWagon.add(wagon10);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            case 12:
                Wagon wagon11 = new LiquidToxicMaterialsWagon();
                unSignedWagon.add(wagon11);
                menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
                break;
            default:
                System.out.println("blad");
        }
    }

    private void createStation(StationGrid stationGrid){
        Station station = new Station(stationGrid);
        stations.add(station);
        stationGrid.addStationToGrid(station,stationGrid);
        menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
    }

    private void assignLocomotiveToWagon(StationGrid stationGrid){
        int i = 1;
        int j = 1;
        int x = 0;
        if(unSignedWagon.isEmpty() || (signedLocomotives.isEmpty() && unSignedLocomitives.isEmpty())){
            System.out.println();
            System.out.println("niemozna przypisac wagonu do lokomotywt\n");
            menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
        }else {
            for (Wagon w : unSignedWagon) {
                System.out.println(i++ + ". -> ID of Wagon - " + w.getId());
            }
            System.out.print("wybierz wagon: ");
            Scanner scanner2 = new Scanner(System.in);
            int wag = scanner2.nextInt();
            Wagon tmpWagon = unSignedWagon.get(wag - 1);
            System.out.println();
            for (Locomotive l : signedLocomotives) {
                System.out.println(j++ + ". -> ID of Locomotive - " + l.getId());
                x++;
            }
            for (Locomotive l : unSignedLocomitives) {
                System.out.println(j++ + ". -> ID of Locomotive - " + l.getId());
            }
            System.out.print("Wyebirz lokomotywe: ");
            Scanner scanner3 = new Scanner(System.in);
            int loc = scanner3.nextInt();
            Locomotive tmpLocomotive;
            if (loc <= x) {
                tmpLocomotive = signedLocomotives.get(loc - 1);
            } else {
                tmpLocomotive = unSignedLocomitives.get(loc - signedLocomotives.size() - 1);
            }

            boolean tmp = false;

            for (TrainComposition tc : trainCompositions) {
                if (tc.getId() == tmpLocomotive.getId()) {
                    try {
                        if(tmpLocomotive.getMaxWeightOfTorsion() > (tmpLocomotive.getMaxWeightOfTorsion()+tmpWagon.getWeightGross())){
                            if (tmpLocomotive.getMaxNumOfWagons() > (tmpLocomotive.getMaxNumOfWagons() + 1)){
                                if(tmpLocomotive.getMaxNumOfElectricWagons() > (tmpLocomotive.getMaxNumOfElectricWagons() + 1)){
                                    unSignedWagon.remove(tmpWagon);
                                    signedWagons.add(tmpWagon);
                                }
                            }
                        }
                        tc.addWagon(tmpLocomotive, tmpWagon);
                    }  catch (TooHeavyTrainExepction e) {
                        e.printStackTrace();
                    } catch (TooManyElectricWagons e) {
                        e.printStackTrace();
                    } catch (TooManyWagons e) {
                        e.printStackTrace();
                    }
                    tmp = true;
                }
            }

            if (!tmp) {
                ArrayList<Wagon> wagons = new ArrayList<>();
                wagons.add(tmpWagon);
                TrainComposition trainComposition = null;
                try {
                    if(tmpLocomotive.getMaxWeightOfTorsion() > (tmpLocomotive.getMaxWeightOfTorsion()+tmpWagon.getWeightGross())){
                        if (tmpLocomotive.getMaxNumOfWagons() > (tmpLocomotive.getMaxNumOfWagons() + 1)){
                            if(tmpLocomotive.getMaxNumOfElectricWagons() > (tmpLocomotive.getMaxNumOfElectricWagons() + 1)){
                                unSignedWagon.remove(tmpWagon);
                                signedWagons.add(tmpWagon);
                                unSignedLocomitives.remove(tmpLocomotive);
                                signedLocomotives.add(tmpLocomotive);
                            }
                        }
                    }
                    trainComposition = new TrainComposition(tmpLocomotive, wagons, stationGrid);
                } catch (TooHeavyTrainExepction e) {
                    e.printStackTrace();
                } catch (TooManyElectricWagons e) {
                    e.printStackTrace();
                } catch (TooManyWagons e) {
                    e.printStackTrace();
                }
                trainCompositions.add(trainComposition);
            }
            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        }
    }

    private void load(StationGrid stationGrid) {
        int i = 1;
        if (unLoadedWagons.isEmpty()) {
            System.out.println();
            System.out.println("brak wagonow do zaladowania\n");
            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        } else {
            for (Wagon w : unLoadedWagons) {
                if(!w.isLoaded()){
                    System.out.println(i++ + ". -> ID of Wagon - " + w.getId());
                }
            }
            System.out.print("wybierz wagon ktory chcesz załadować: ");
            Scanner scanner2 = new Scanner(System.in);
            int wag = scanner2.nextInt();
            Wagon tmpWagon;
            tmpWagon = unLoadedWagons.get(wag - 1);
            tmpWagon.setLoaded(true);
            loadedWagons.add(tmpWagon);
            unLoadedWagons.remove(tmpWagon);
            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        }
    }

    private void unLoad(StationGrid stationGrid){
        int i = 1;
        if (loadedWagons.isEmpty()) {
            System.out.println();
            System.out.println("brak wagonow do rozladowania\n");
            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        } else {
            for (Wagon w : loadedWagons) {
                if(w.isLoaded()){
                    System.out.println(i++ + ". -> ID of Wagon - " + w.getId());
                }
            }
            System.out.print("wybierz wagon ktory chcesz rozladowac: ");
            Scanner scanner2 = new Scanner(System.in);
            int wag = scanner2.nextInt();
            Wagon tmpWagon;
            tmpWagon = loadedWagons.get(wag - 1);
            tmpWagon.setLoaded(false);
            unLoadedWagons.add(tmpWagon);
            loadedWagons.remove(tmpWagon);

            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        }
    }

    private void removeLocomotive(StationGrid stationGrid){
        int j =1;
        int x = 0;
        for(Locomotive l : signedLocomotives){
            System.out.println(j++ + ". -> ID of Locomotive - " + l.getId());
            x++;
        }
        for(Locomotive l : unSignedLocomitives){
            System.out.println(j++ + ". -> ID of Locomotive - " + l.getId());
        }
        if(signedLocomotives.isEmpty() && unSignedLocomitives.isEmpty()){
            System.out.println();
            System.out.println("Brak lokomotyw do usunievia!\n");
            menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
        } else {
            System.out.print("Wyebirz lokomotywe ktora chcesz usunac: ");
            Scanner scanner3 = new Scanner(System.in);
            int loc = scanner3.nextInt();
            Locomotive tmpLocomotive;
            if (loc <= x) {
                tmpLocomotive = signedLocomotives.get(loc - 1);
                signedLocomotives.remove(tmpLocomotive);
                TrainComposition tmp = null;
                for (TrainComposition tc : trainCompositions) {
                    for (Map.Entry<Locomotive, ArrayList<Wagon>> entry : tc.trainComposition.entrySet()) {
                        if (entry.getKey().equals(tmpLocomotive)) {
                            ArrayList<Wagon> w = entry.getValue();
                            unSignedWagon.addAll(w);
                            signedWagons.removeAll(w);
                            tmp = tc;
                        }
                    }
                }
                trainCompositions.remove(tmp);
                tmp.getJourneys().stopRunning();
                tmp.getSpeed().stopRunning();
            } else {
                tmpLocomotive = unSignedLocomitives.get(loc - signedLocomotives.size() - 1);
                unSignedLocomitives.remove(tmpLocomotive);
            }
            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        }
    }

    private void removeWagon(StationGrid stationGrid){
        int x = 0;
        int i = 1;
        if(signedWagons.isEmpty() && unSignedWagon.isEmpty()){
            System.out.println();
            System.out.println("brak wagonow do usuniecia\n");
            menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
        }else {
            for (Wagon w : signedWagons) {
                System.out.println(i++ + ". -> ID of Wagon - " + w.getId());
                x++;
            }
            for (Wagon w : unSignedWagon) {
                System.out.println(i++ + ". -> ID of Wagon - " + w.getId());
            }
            System.out.print("wybierz wagon ktory chcesz usunac: ");
            Scanner scanner2 = new Scanner(System.in);
            int wag = scanner2.nextInt();
            Wagon tmpWagon;
            if (wag <= x) {
                tmpWagon = signedWagons.get(wag - 1);
                signedWagons.remove(tmpWagon);
                for (TrainComposition tc : trainCompositions) {
                    for (Map.Entry<Locomotive, ArrayList<Wagon>> entry : tc.trainComposition.entrySet()) {
                        ArrayList<Wagon> w = entry.getValue();
                        if (w.contains(tmpWagon)) {
                            w.remove(tmpWagon);
                        }
                    }
                }
            } else {
                tmpWagon = unSignedWagon.get(wag - signedWagons.size() - 1);
                unSignedWagon.remove(tmpWagon);
            }
            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        }
    }

    private void removeStation(StationGrid stationGrid,ArrayList<Locomotive> locomotives){
        int i = 1;
        if(stations.isEmpty()){
            System.out.println();
            System.out.println("brak stacji do usuniecia\n");
            menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
        }
        for(Station s : stations){
            System.out.println(i++ + ". -> ID of Wagon - " + s.getId());
        }
        System.out.print("wybierz stacje ktora chcesz usunac: ");
        Scanner scanner2 = new Scanner(System.in);
        int sta = scanner2.nextInt();
        Station tmpStation = stations.get(sta-1);

        stationGrid.removeConnection(tmpStation);

        for(Locomotive l : locomotives){
            if(l.getDestination().equals(tmpStation)){
                l.changeDestinationStation(stationGrid,l);
            }
            if (l.getStarting().equals(tmpStation)) {
                l.changeStartingStation(stationGrid,l);
            }
            PathFinding pathFinding = new PathFinding(stationGrid);
            pathFinding.pathFinding(l.getStarting(),l.getDestination());
        }

        stations.remove(tmpStation);
        menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
    }

    private void removeTrain(StationGrid stationGrid){
        int i = 1;
        if(trainCompositions.isEmpty()){
            System.out.println();
            System.out.println("brak pociagow do usunienia\n");
            menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
        }else {
            for (TrainComposition ts : trainCompositions) {
                System.out.println(i++ + ". -> ID of Train - " + ts.getId());
            }
            System.out.print("wybierz pociag ktora chcesz usunac: ");
            Scanner scanner2 = new Scanner(System.in);
            int train = scanner2.nextInt();
            TrainComposition tmpTrain = trainCompositions.get(train - 1);

            ArrayList<Wagon> w = tmpTrain.wagons;
            signedWagons.removeAll(w);
            for (Locomotive l : tmpTrain.getTrainComposition().keySet()) {
                signedLocomotives.remove(l);
            }
            trainCompositions.remove(tmpTrain);
            tmpTrain.getJourneys().stopRunning();
            tmpTrain.getSpeed().stopRunning();
            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        }
    }

    private void createTrain(StationGrid stationGrid){
        int j = 1;
        if(unSignedLocomitives.isEmpty() || unSignedWagon.isEmpty()){
            System.out.println();
            System.out.println("nie mozna stworzyc nowego pociagu\n");
            menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
        }else {
            for (Locomotive l : unSignedLocomitives) {
                System.out.println(j++ + ". -> ID of Locomotive - " + l.getId());
            }
            System.out.print("Wyebirz lokomotywe: ");
            Scanner scanner3 = new Scanner(System.in);
            int loc = scanner3.nextInt();
            Locomotive tmpLocomotive = unSignedLocomitives.get(loc - 1);
            System.out.println();

            System.out.println("Maksymalna ilosc wagonow: " + unSignedWagon.size());
            System.out.print("wybierz ilość wagonow ile chcesz podlaczyc pod lokomotywe: ");
            Scanner scanner = new Scanner(System.in);
            int tmpNumOfWagons = scanner.nextInt();
            System.out.println();

            ArrayList<Wagon> tmpWagons = new ArrayList<>();
            ArrayList<Wagon> chosenWagons = new ArrayList<>();
            int totalWeightOfWagons = 0;
            int totalNumOfWagons = 0;
            int totalNumOfElectricWagons = 0;

            for (int k = 0; k < tmpNumOfWagons; k++) {
                int i = 1;
                for (Wagon w : unSignedWagon) {
                    if(!chosenWagons.contains(w)){
                        System.out.println(i++ + ". -> ID of Wagon - " + w.getId());
                    }
                }
                System.out.print("wybierz wagon: ");
                Scanner scanner2 = new Scanner(System.in);
                int wag = scanner2.nextInt();
                Wagon tmpWagon = unSignedWagon.get(wag - 1);
                chosenWagons.add(tmpWagon);
                if(tmpLocomotive.getMaxWeightOfTorsion() > (totalWeightOfWagons + tmpWagon.getWeightGross())){
                    if (tmpLocomotive.getMaxNumOfWagons() > (totalNumOfWagons + 1)){
                        if(tmpLocomotive.getMaxNumOfElectricWagons() > (totalNumOfElectricWagons + 1)){
                            unSignedWagon.remove(tmpWagon);
                            signedWagons.add(tmpWagon);
                            unSignedLocomitives.remove(tmpLocomotive);
                            signedLocomotives.add(tmpLocomotive);
                            tmpWagons.add(tmpWagon);
                        }
                    }
                }
                totalWeightOfWagons = totalWeightOfWagons + tmpWagon.getWeightGross();
                totalNumOfWagons++;
                if(tmpWagon.isConnectionToElectricityNetwork()){totalNumOfElectricWagons++;}
            }

            TrainComposition trainComposition = null;
            try {
                if(tmpLocomotive.getMaxWeightOfTorsion() > totalWeightOfWagons){
                    if (tmpLocomotive.getMaxNumOfWagons() > totalNumOfWagons){
                        if(tmpLocomotive.getMaxNumOfElectricWagons() > totalNumOfElectricWagons){
                            unSignedWagon.removeAll(tmpWagons);
                            signedWagons.addAll(tmpWagons);
                        }
                    }
                }
                trainComposition = new TrainComposition(tmpLocomotive, tmpWagons, stationGrid);
            } catch (TooHeavyTrainExepction e) {
                e.printStackTrace();
            } catch (TooManyElectricWagons e) {
                e.printStackTrace();
            } catch (TooManyWagons e) {
                e.printStackTrace();
            }
            trainCompositions.add(trainComposition);
            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        }

    }

    private void displayTrain(StationGrid stationGrid){
        int i = 1;
        if(trainCompositions.isEmpty()){
            System.out.println();
            System.out.println("brak pociagow do wyswietlenia\n");
            menu(stationGrid,trainCompositions, signedLocomotives, signedWagons,stations);
        }else {
            for (TrainComposition ts : trainCompositions) {
                System.out.println(i++ + ". -> ID of Train - " + ts.getId());
            }
            System.out.print("wybierz pociag ktory  chcesz wyswietlic: ");
            Scanner scanner2 = new Scanner(System.in);
            int train = scanner2.nextInt();
            TrainComposition tmpTrain = trainCompositions.get(train - 1);
            System.out.println(tmpTrain.toString().replaceAll("[\\[\\]\\{\\},=]", ""));
            menu(stationGrid, trainCompositions, signedLocomotives, signedWagons, stations);
        }
    }

    private void endProgram() {
        for(TrainComposition ts : trainCompositions){
            ts.getJourneys().stopRunning();
            ts.getSpeed().stopRunning();
        }
    }

}
