#include <exception>
#include <iostream>
#include <stdexcept>

class InsufficientBalance : public std::exception {
public:
    const char* what() const noexcept override {
        return "Insufficient balance";
    }
};

void transfer(long long balance, long long amount) {
    if (amount <= 0) {
        throw std::invalid_argument("Amount must be positive");
    }
    if (amount > balance) {
        throw InsufficientBalance{};
    }
    std::cout << "Transfer accepted\n";
}

int main() {
    try {
        transfer(500, 700);
    } catch (const InsufficientBalance& error) {
        std::cerr << error.what() << '\n';
    } catch (const std::exception& error) {
        std::cerr << error.what() << '\n';
    }
}
