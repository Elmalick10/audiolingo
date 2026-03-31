#pragma once
#include <queue>
#include <vector>
#include <mutex>
#include <condition_variable>

class AudioQueue {

private:
    std::queue<std::vector<int16_t>> queue;
    std::mutex mutex;
    std::condition_variable cv;

public:

    void push(std::vector<int16_t>&& buffer) {
        {
            std::lock_guard<std::mutex> lock(mutex);
            queue.push(std::move(buffer));
        }
        cv.notify_one();
    }

    std::vector<int16_t> pop() {

        std::unique_lock<std::mutex> lock(mutex);

        cv.wait(lock, [&]{ return !queue.empty(); });

        auto buffer = std::move(queue.front());
        queue.pop();

        return buffer;
    }
};