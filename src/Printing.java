import Wagon.Wagon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Printing extends Thread{

    private ArrayList<TrainComposition> trainCompositions;
    private boolean running = true;
    private final static String monitor = new String();

    public Printing(ArrayList<TrainComposition> trainCompositions){this.trainCompositions = trainCompositions;}

    @Override
    public void run() {
        while (running){
            synchronized (monitor) {
                try {
                    if(!running){
                        break;
                    }
                    print(trainCompositions);
                    Thread.sleep(5000);
                    if(!running){
                        break;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void print(ArrayList<TrainComposition> trainCompositions) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("AppState.txt"));

            Collections.sort(trainCompositions);

            for(TrainComposition trainComposition : trainCompositions){
                for(ArrayList<Wagon> wagons : trainComposition.trainComposition.values()){
                    Collections.sort(wagons);
                }
                bw.write(trainComposition.toString().replaceAll("[\\[\\]\\{\\},=]", "") + "\n\n");
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void stopRunning() {
        running = false;
    }
}

