import random

def analyze():

    # simulation API stats
    return {
        "views": random.randint(100, 10000),
        "likes": random.randint(10, 1000),
        "watch_time": random.uniform(1, 10)
    }