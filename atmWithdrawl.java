import java.util.Scanner;

public class atmWithdrawl {
    private static double balance = 1000.0;
    private static final String CORRECT_PIN = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.nextLine();
            validatePin(enteredPin);

            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            withdraw(amount);

            System.out.println("Withdrawal successful.");
        } catch (InvalidPinException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Remaining balance: " + balance);
            scanner.close();
        }
    }

    private static void validatePin(String pin) throws InvalidPinException {
        if (!pin.equals(CORRECT_PIN)) {
            throw new InvalidPinException("Invalid PIN entered.");
        }
    }

    private static void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
    }
}

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}