import java.util.* ;

public class PerformanceTest {
    static long startConstruction ;
    static long endConstruction ;
    static long constructionTime ;
    static long startIteration ;
    static long endIteration ;
    static long iterationTime ;
    
    public static ArrayList<Integer> makeArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>() ;
        Integer integer ;
        for(int i = 0 ; i< 100580000 ; i++) {
            integer = (int) (Math.random() * (9 + 1));
            arrayList.add(integer) ;
        }
        return arrayList ;
    }

    public static int[] makeArray() {
        int[] array = new int[100580000] ;
        for (int i =0 ; i<100580000 ; i++) {
            array[i] = (int) (Math.random() * (9 + 1));
        }
        return array ;
    }

    public static Vector<Integer> makeVector() {
        Integer integer ;
        Vector<Integer> vector = new Vector(100580000);
        /*NOTE!
         * This version initializes vectors with a set index. Further testing was done with a value of 10058000.
         * This is due to the OutOfMemory error, which did not happen when the size was reduced to 10058000.
         *But, this version upholds the 10s construction of the arraylist.
         */
        for (int i = 0 ; i<100580000 ; i++) {
            integer = (int) (Math.random() * (9+1)) ;
            vector.add(integer) ;
        }
        return vector;
    }

    public static void main(String[] args) {
        int sum ;
        int number ;

        for (int i = 0 ; i<3 ; i++) {
            if(i == 0) {
                startConstruction = System.nanoTime() ;

                ArrayList<Integer> arrayList = makeArrayList() ;
                Iterator<Integer> iteratorL = arrayList.iterator() ;

                endConstruction = System.nanoTime() ;
                constructionTime = (endConstruction - startConstruction) ;

                System.out.println("ARRAYLIST___________________________________") ;
                sum = 0 ;

                startIteration = System.nanoTime() ;
                while (iteratorL.hasNext()) {
                    number = (int)iteratorL.next() ;
                    sum += number ;
                }
                endIteration = System.nanoTime() ;
                iterationTime = endIteration - startIteration ;
                System.out.println("Summation runtime: " + (iterationTime/1000000000)) ;

            } else if (i == 1) {
                startConstruction = System.nanoTime() ;

                int[] array = makeArray() ;

                endConstruction = System.nanoTime() ;
                constructionTime = (endConstruction - startConstruction) ;
                
                System.out.println("ARRAY___________________________________") ;
                sum = 0;
                
                startIteration = System.nanoTime();
                for (int j = 0 ; j<array.length ; j++) {
                    sum += array[j] ;
                }
                endIteration = System.nanoTime() ;
                iterationTime = endIteration - startIteration ;
                System.out.println("Summation runtime: " + (iterationTime/1000000000)) ;

            } else if (i == 2) {
                startConstruction = System.nanoTime() ;

                Vector<Integer> vector = makeVector() ;
                Iterator<Integer> iteratorV = vector.iterator() ;

                endConstruction = System.nanoTime() ;
                constructionTime = (endConstruction - startConstruction) ;

                System.out.println("VECTOR___________________________________") ;
                sum = 0 ;
                startIteration = System.nanoTime() ;
                while (iteratorV.hasNext()) {
                    number = iteratorV.next() ;
                    sum += number ;
                }
                endIteration = System.nanoTime() ;
                iterationTime = endIteration - startIteration ;
                System.out.println("Summation runtime: " + (iterationTime/1000000000)) ;
            }
        }
    }
}
