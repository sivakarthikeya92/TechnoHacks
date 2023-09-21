import java.util.Scanner;

class Calculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select operation:");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");

		System.out.print("Enter choice (1/2/3/4): ");
		int choice = scanner.nextInt();

		System.out.print("Enter first number: ");
		double num1 = scanner.nextDouble();

		System.out.print("Enter second number: ");
		double num2 = scanner.nextDouble();

		double result;

		switch (choice) {
		case 1:
			result = add(num1, num2);
			System.out.println("Result: " + result);
			break;
		case 2:
			result = subtract(num1, num2);
			System.out.println("Result: " + result);
			break;
		case 3:
			result = multiply(num1, num2);
			System.out.println("Result: " + result);
			break;
		case 4:
			result = divide(num1, num2);
			if (Double.isNaN(result)) {
				System.out.println("Division by zero is not allowed");
			} else {
				System.out.println("Result: " + result);
			}
			break;
		default:
			System.out.println("Invalid input");
		}
	}

	// Function to perform addition
	public static double add(double x, double y) {
		return x + y;
	}

	// Function to perform subtraction
	public static double subtract(double x, double y) {
		return x - y;
	}

	// Function to perform multiplication
	public static double multiply(double x, double y) {
		return x * y;
	}

	// Function to perform division
	public static double divide(double x, double y) {
		if (y == 0) {
			return Double.NaN; // Not-a-Number (NaN) for division by zero
		}
		return x / y;
	}
}
