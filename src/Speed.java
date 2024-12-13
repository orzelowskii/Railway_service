import Exepctions.RailroadHazardExepction;

public class Speed extends Thread{


    private TrainComposition trainComposition;
    private Locomotive locomotive;
    private boolean running = true;

    public Speed(TrainComposition trainComposition,Locomotive locomotive){
        this.trainComposition = trainComposition;
        this.locomotive = locomotive;
    }

    @Override
    public void run() {
        while (running){
            speedChange(locomotive,trainComposition);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.notifyAll();
            }
        }
    }

    public void speedChange(Locomotive locomotive,TrainComposition trainComposition){
        double tmp = Math.random();
        if(tmp>0.5){
            locomotive.setSpeed(locomotive.getSpeed() + (locomotive.getSpeed() * 0.03 ));
        }else {
            locomotive.setSpeed(locomotive.getSpeed() - (locomotive.getSpeed() * 0.03 ));
        }
        if(locomotive.getSpeed() > 200){
            try {
                throw new RailroadHazardExepction(locomotive.getSpeed(),trainComposition.getId());
            } catch (RailroadHazardExepction e) {
                e.printStackTrace();
            }
            locomotive.setSpeed(150);
        }
    }

    public void stopRunning() {
        running = false;
    }

}
