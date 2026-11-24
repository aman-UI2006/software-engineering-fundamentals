#include <iostream>
#include <unordered_map>
#include <utility>
#include <vector>

// Returns indices of two distinct values adding to target.
// Expected O(n) time and O(n) auxiliary space.
std::pair<int, int> two_sum(const std::vector<int>& nums, int target) {
    std::unordered_map<int, int> index_by_value;

    for (int i = 0; i < static_cast<int>(nums.size()); ++i) {
        const int complement = target - nums[i];
        const auto found = index_by_value.find(complement);
        if (found != index_by_value.end()) {
            return {found->second, i};
        }
        index_by_value.emplace(nums[i], i);
    }
    return {-1, -1};
}

int main() {
    const auto result = two_sum({2, 7, 11, 15}, 9);
    std::cout << result.first << ", " << result.second << '\n';
}
