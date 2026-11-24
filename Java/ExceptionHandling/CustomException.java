/**
 * Demonstrates a domain-specific unchecked exception.
 */
public class CustomException {
    static final class InsufficientBalanceException extends RuntimeException {
        InsufficientBalanceException(String message) {
            super(message);
        }
    }

    static void transfer(long balance, long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        System.out.println("Transfer accepted");
    }

    public static void main(String[] args) {
        try {
            transfer(500, 700);
        } catch (InsufficientBalanceException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
