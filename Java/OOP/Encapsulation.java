/**
 * Demonstrates encapsulation: state is private and mutations are validated.
 */
public class Encapsulation {
    static final class BankAccount {
        private final String accountHolder;
        private long balanceInPaise;

        BankAccount(String accountHolder, long openingBalanceInPaise) {
            if (accountHolder == null || accountHolder.isBlank()) {
                throw new IllegalArgumentException("Account holder is required");
            }
            if (openingBalanceInPaise < 0) {
                throw new IllegalArgumentException("Opening balance cannot be negative");
            }
            this.accountHolder = accountHolder;
            this.balanceInPaise = openingBalanceInPaise;
        }

        public String getAccountHolder() {
            return accountHolder;
        }

        public long getBalanceInPaise() {
            return balanceInPaise;
        }

        public void deposit(long amountInPaise) {
            if (amountInPaise <= 0) {
                throw new IllegalArgumentException("Deposit must be positive");
            }
            balanceInPaise = Math.addExact(balanceInPaise, amountInPaise);
        }

        public void withdraw(long amountInPaise) {
            if (amountInPaise <= 0 || amountInPaise > balanceInPaise) {
                throw new IllegalArgumentException("Invalid withdrawal amount");
            }
            balanceInPaise -= amountInPaise;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Asha", 10_000);
        account.deposit(2_500);
        account.withdraw(1_000);
        System.out.println(account.getAccountHolder()
                + " balance (paise): " + account.getBalanceInPaise());
    }
}
