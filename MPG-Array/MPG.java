import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: A program that collects miles driven and gallons
 *
 * @author Steve Ellermann
 * @version 2018.05.04
 */
 
public class MPG {

    private static Scanner stdin = new Scanner(System.in);
    private static int weeks;
    private static double[] miles;      // Stores miles for each week
    private static double[] gallons;    // Stores gallons for each week
    private static double[] mpg;        // Stores the MPG for each week

    public static void main(String[] args) {

        weeks = getWeeks();
        System.out.println("weeks: " + weeks);
        miles = new double[weeks];
        getMiles(miles);
        gallons = new double[weeks];
        getGallons(gallons);
        mpg = new double[weeks];
        calcMPG();
        displayResults();

    }
    
    /**
     * calculate miles per gallon and update the mpg array.
     */
    public static void calcMPG() {
        for (int i = 0; i < weeks; i++) {
            mpg[i] = miles[i] / gallons[i];
        }
    }

    /**
     * display the results of miles, gallons and mpg.
     */
    public static void displayResults() {
        int count = miles.length;
        double sumMiles = Arrays.stream(miles).sum();
        double sumGallons = Arrays.stream(gallons).sum();
        double sumMPG = sumMiles / sumGallons;

        System.out.printf(
                "%1$-10s %2$-10s %3$-10s %4$-10s\n",
                "",
                "Miles",
                "Gallons",
                "MPG"
        );
        
        System.out.printf(
                "%1$-10s %2$-10s %3$-10s %4$-10s\n",
                "",
                "--------",
                "--------",
                "--------"
        );

        for (int i = 0; i < count; i++) {
            System.out.printf(
                    "%1$-10s %2$-10s %3$-10s %4$-10.1f\n",
                    "Week " + (i + 1),
                    miles[i],
                    gallons[i],
                    miles[i] / gallons[i]
            );
        }
        
        System.out.printf(
                "%1$-10s %2$-10s %3$-10s %4$-10.1f\n",
                "Total", 
                sumMiles, 
                sumGallons, 
                sumMPG
        );
    }

    /**
     * getWeeks asks the user for the number of weeks
     *
     * @return
     */
    public static int getWeeks() {
        System.out.print("Enter the number of weeks: ");
        weeks = stdin.nextInt();
        return weeks;
    }

    /**
     * getMiles asks the user for miles for each week and stores it in the 
     * miles array
     *
     * @param miles array of miles driven
     */
    public static void getMiles(double[] miles) {
        System.out.println("Enter the miles for each week: ");
        for (int i = 0; i < miles.length; i++) {
            System.out.print("Enter miles for week " + (i + 1)
                    + ": ");
            miles[i] = stdin.nextDouble();
        }
    }

    /**
     * getGallons asks the user for miles for each week and stores it in the
     * gallons array
     *
     * @param gallons array of gallons used
     */
    public static void getGallons(double[] gallons) {
        System.out.println("Enter the gallons for each week: ");
        for (int i = 0; i < gallons.length; i++) {
            System.out.print("Enter gallons for week " + (i + 1)
                    + ": ");
            gallons[i] = stdin.nextDouble();
        }
    }
}
