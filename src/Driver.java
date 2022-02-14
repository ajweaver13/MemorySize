import java.util.Scanner;

public class Driver {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        MemorySize ms = new MemorySize();
        System.out.println("---------------------------------------------------------");
        System.out.println("|                         Hello!                        |");
        System.out.println("| Type in a memory you want to allocate into the driver |");
        System.out.println("|  Make sure to add GB or MB at the end of your size.   |");
        System.out.println("|              Enter * to exit the program.             |");
        System.out.println("---------------------------------------------------------\n");
        System.out.print("Enter the memory size: ");
        String input = scan.nextLine();
        while(!input.equals("*")) {
            input = check(input);
            System.out.println("Actual memory size: "+ms.actualMemorySize(input));
            System.out.print("\nEnter the memory size: ");
            input = scan.nextLine();
        }
    }

    private static String check(String input) {
        String type;
        String number;
        String result = null;
        try {
            if (input != null && input.length() >= 3) {
                type = input.substring(input.length() - 2);
                number = input.substring(0, input.length() - 2);
            } else {
                throw new Exception();
            }
            type = type.toUpperCase();
            if (!type.equals("GB") && !type.equals("MB")) {
                throw new Exception();
            }
            Integer.parseInt(number);
            result = number+type;

        } catch (Exception e) {
            System.out.println("Incorrect input.");
            System.out.print("Enter the memory size: ");
            String temp = scan.nextLine();
            result = check(temp);
        }
        return result;
    }
}
