//package design5;
import java.util.Random;
public class Performance {

    String[] args;
    PointCP3 test1;
    PointCP2 test2;

    public double time(){
        int i;
        Random randXOrRho = new Random();
        Random randYOrTheta = new Random();
        long start = System.nanoTime();
        for(i = 0; i < 1000; i++){
            double randomXOrRho = randXOrRho.nextDouble() * 3;
            double randomYOrTheta = randYOrTheta.nextDouble() * 3;
            PointCP3(randomXOrRho, randomYOrTheta);
        }
        for(i = 0; i < 1000; i++){
            double randomXOrRho = randXOrRho.nextDouble() * 3;
            double randomYOrTheta = randYOrTheta.nextDouble() * 10;
            PointCP2(randomXOrRho, randomYOrTheta);
        }
        long end = System.nanoTime();
        return (end - start) *100000000;
    }


}
