def calculate_mrr(payments):
    monthly = sum(p.amount for p in payments)
    return monthly