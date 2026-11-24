#include <iostream>
#include <limits>
#include <stdexcept>
#include <string>
#include <utility>

class BankAccount {
public:
    BankAccount(std::string holder, long long opening_balance)
        : holder_(std::move(holder)), balance_(opening_balance) {
        if (holder_.empty() || opening_balance < 0) {
            throw std::invalid_argument("Invalid account details");
        }
    }

    void deposit(long long amount) {
        if (amount <= 0) {
            throw std::invalid_argument("Deposit must be positive");
        }
        if (amount > std::numeric_limits<long long>::max() - balance_) {
            throw std::overflow_error("Balance would overflow");
        }
        balance_ += amount;
    }

    long long balance() const noexcept {
        return balance_;
    }

    const std::string& holder() const noexcept {
        return holder_;
    }

private:
    std::string holder_;
    long long balance_;
};

int main() {
    BankAccount account("Asha", 10000);
    account.deposit(2500);
    std::cout << account.holder() << " balance: " << account.balance() << '\n';
}
