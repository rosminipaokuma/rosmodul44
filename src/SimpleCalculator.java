import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = getInput(scanner, "Masukkan angka pertama: ");
        double num2 = getInput(scanner, "Masukkan angka kedua: ");
        char operator = getOperator(scanner);

        double result = calculate(num1, num2, operator);
        displayResult(result);
    }

    private static double getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Input tidak valid. Silakan masukkan angka.");
            scanner.next(); // clear invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    private static char getOperator(Scanner scanner) {
        System.out.print("Masukkan operator (+, -, *, /): ");
        return scanner.next().charAt(0);
    }

    private static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Pembagian dengan nol tidak diperbolehkan.");
                    return Double.NaN; // return Not-a-Number
                }
                return num1 / num2;
            default:
                System.out.println("Operator tidak valid.");
                return Double.NaN; // return Not-a-Number
        }
    }

    private static void displayResult(double result) {
        if (!Double.isNaN(result)) {
            System.out.println("Hasil: " + result);
        }
    }
}
