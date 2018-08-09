import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*try {
            Odometer.generateWellOrdered();
            //or
            Odometer.generateAllFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        int number=789, n=2, numberOfDigits=3;
        Odometer odometer = new Odometer(numberOfDigits);
        //System.out.println(odometer.getValidNumArray());
        System.out.println("Number: "+number);
        System.out.println("Next number: "+odometer.nthReading(number, 1));
        System.out.println("Next "+n+"th reading: "+odometer.nthReading(number,n));
        System.out.println("Previous: "+ odometer.nthReading(number,-1));
        System.out.println("Previous "+n+"th reading: "+odometer.nthReading(number, -n));
    }
}
