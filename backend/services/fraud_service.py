def detect_fraud(user):

    # 🚨 trop de requêtes
    if user.usage > 1000:
        return True

    # 🚨 plan free abuse
    if user.plan == "free" and user.usage > 5:
        return True

    return False