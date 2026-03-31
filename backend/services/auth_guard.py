from services.subscription_service import get_active_subscription

def check_access(user_id):

    sub = get_active_subscription(user_id)

    if not sub:
        return False

    return True