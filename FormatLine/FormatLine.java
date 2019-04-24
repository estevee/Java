import java.util.Scanner;

/**
FormatLine.java
@author Steve Ellermann
@version 2014.04.29
 */

public class FormatLine {

    public static void main(String[] args) {
        final int LINE_LEN = 60;
        System.out.print("input: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        while (i + LINE_LEN < sb.length()
                && (i = sb.lastIndexOf(" ", i + LINE_LEN)) != -1) {
            sb.replace(i, i + 1, "\n");
        }
        System.out.println(sb.toString());
    }

}
