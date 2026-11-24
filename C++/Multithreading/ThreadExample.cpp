#include <iostream>
#include <thread>
#include <vector>

void print_task(int id) {
    std::cout << "Task " << id << " running\n";
}

int main() {
    std::vector<std::thread> workers;
    for (int id = 1; id <= 3; ++id) {
        workers.emplace_back(print_task, id);
    }

    for (auto& worker : workers) {
        worker.join();
    }
}
