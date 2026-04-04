import redis

r = redis.Redis(host='localhost', port=6379)

def cache_set(key, value):
    r.set(key, value)

def cache_get(key):
    return r.get(key)