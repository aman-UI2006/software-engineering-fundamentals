#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

int main() {
    std::vector<std::string> languages{"Java", "C++", "Python"};
    std::sort(languages.begin(), languages.end());

    for (const auto& language : languages) {
        std::cout << language << ' ';
    }
    std::cout << '\n';

    const std::unordered_map<std::string, int> counts{
        {"arrays", 12},
        {"graphs", 7}
    };
    const auto found = counts.find("arrays");
    std::cout << "Array problems: "
              << (found == counts.end() ? 0 : found->second) << '\n';
}
