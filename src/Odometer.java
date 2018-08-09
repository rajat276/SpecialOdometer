import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Odometer {
    private int numberOfDigits;
    private int maxReading;
    private int minReading;

    public Odometer(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
        this.maxReading= getMaxReading(numberOfDigits);
        this.minReading= getMinReading(numberOfDigits);
    }

    public static int getMaxReading(int numberOfDigits) {
        return Integer.parseInt("987654321".substring(9-numberOfDigits));
        /*String maxReading = "";
        for (int i = 0; i < numberOfDigits && i < 9; i++) {
            maxReading += String.valueOf((9 - i));
        }
        return Integer.parseInt(maxReading);*/
    }

    public static int getMinReading(int numberOfDigits) {
        return Integer.parseInt("123456789".substring(0,numberOfDigits));
        /*String minReading = "";
        for (int i = 0; i < numberOfDigits && i < 9; i++) {
            minReading += String.valueOf((i + 1));
        }
        return Integer.parseInt(minReading);*/
    }

    public ArrayList<String> getValidNumArray() throws FileNotFoundException {
        ArrayList<String> dictionaryArray = new ArrayList<>();
        String filePath= String.valueOf(numberOfDigits) + ".txt";
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            dictionaryArray.add(scanner.nextLine());
        }
        return dictionaryArray;
    }

    public String nthReading(int number, int n) throws FileNotFoundException {
        List<String> odometerNum = getValidNumArray();
        int position= search(odometerNum, number);
        int size=odometerNum.size();
        int pos;
        if(n>0)
            return odometerNum.get((position+n)%size);
        else
        {
            if((position+n) <0)
                pos= size + position+n;
            else
                pos=position+n;
            return odometerNum.get(pos);
        }
    }
    int search(List<String> odometerNum, int number){
       /* String num= Integer.toString(number);
        int size=odometerNum.size();
        for(int i=0;i<size;i++)
        {
            if(num.equals(odometerNum.get(i)))
                return i;
        }
        return -1;*/
       return odometerNum.indexOf(String.valueOf(number));
    }

    public static void generateFilesForDigit(Integer numDigits) throws IOException {

        String FILENAME = String.valueOf(numDigits) + ".txt";
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(FILENAME));

        for (Integer i = getMinReading(numDigits); i <= getMaxReading(numDigits); i += 1) {
            if (isValidNum(i)) {
                outputWriter.write(i.toString());
                outputWriter.newLine();
            }

        }
        outputWriter.flush();
        outputWriter.close();

    }

    public static void generateAllFiles() throws IOException{
        for (int i=1; i<=9; i++)
            generateFilesForDigit(i);
    }

    static boolean isValidNum(Integer inputNumber) {
        String number = String.valueOf(inputNumber);
        char current = number.charAt(0);
        for (int i = 1; i < number.length(); i++) {
            if (current - number.charAt(i) >= 0)
                return false;
            current = number.charAt(i);

        }
        return true;
    }

    /*private static void printWellOrdered(int number, int x, int k, List<String> generatedNumbers) {
        if (k == 0) {
            System.out.print(number + " ");
            generatedNumbers.add(String.valueOf(number));
            return;
        }
        for (int i = (x + 1); i < 10; i++)
            printWellOrdered(number * 10 + i, i, k - 1,generatedNumbers);
    }

    public static void generateWellOrdered() throws IOException {
        for (int i=1;i<10;i++) {
            List<String> generatedNumbers = new ArrayList<>();
            printWellOrdered(0, 0, i, generatedNumbers);
            write(String.valueOf(i) + ".txt", generatedNumbers);
        }
    }

    public static void write (String filename, List<String> x) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < x.size(); i++) {
            outputWriter.write(x.get(i)+"");
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }*/


}
