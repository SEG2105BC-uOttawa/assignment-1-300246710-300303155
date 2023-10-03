package design1;
import java.util.Random;
public class Performance {
    PointCP test;
    
    public void time(){
        int i;
        char C;
        char P;
        C = "C".charAt(0);
        P = "P".charAt(0);
        Random randXOrRho = new Random();
        Random randYOrTheta = new Random();
        long start = System.nanoTime();
        for(i = 0; i < 1000; i++){
            double randomXOrRho = randXOrRho.nextDouble() * 3;
            double randomYOrTheta = randYOrTheta.nextDouble() * 3;
            test = new PointCP(C, randomXOrRho, randomYOrTheta);
            System.out.println(test);
        }
        for(i = 0; i < 1000; i++){
            double randomXOrRho = randXOrRho.nextDouble() * 3;
            double randomYOrTheta = randYOrTheta.nextDouble() * 10;
            test = new PointCP(P, randomXOrRho, randomYOrTheta);
            System.out.println(test);
        }
        long end = System.nanoTime();
        System.out.println((end - start) *100000000);
    }

}