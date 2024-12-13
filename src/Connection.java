public class Connection {

    private int id;
    private static int counter = 1;

    Station starting;
    Station destination;
    double distance;

    public Connection(Station s1,Station s2) {
        this.starting = s1;
        this.destination = s2;
        this.distance = (double)Math.round(Math.random()*(1000)/1000)+1;
        this.id = counter++;
    }

    public String getId() {
        return "ID: " + id;
    }

    public Station getStarting() {
        return starting;
    }

    public Station getDestination() {
        return destination;
    }

    public double getDistance() {return distance;}

    @Override
    public String toString() {
        return "\n**********************************" + "\n"+
                "Connection id - " + id + "\n" +
                "starting - " + starting + "\n" +
                "destination - " + destination + "\n" +
                "distansce between stations: " + distance + "\n" +
                "**********************************" + "\n\n";
    }

    public Connection reverseConnection(){
        Connection c = new Connection(this.destination,this.starting);
        c.distance = this.distance;
        return c;
    }

}
