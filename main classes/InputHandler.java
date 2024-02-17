import java.util.Scanner;

public class InputHandler {
     private static Scanner input = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.println(prompt);
        return input.next();
    }

    public static int getIntInput(String prompt) {
        System.out.println(prompt);
        return input.nextInt();
    }

    public static double getDoubleInput(String prompt) {
        System.out.println(prompt);
        return input.nextDouble();
    }

    public static void closeScanner() {
        input.close();
    }
}
