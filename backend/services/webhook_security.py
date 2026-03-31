ALLOWED_IPS = [
    "52.0.0.0",  # exemple PayPal
    "197.159.0.0"  # exemple CinetPay
]

def check_ip(ip):

    return ip in ALLOWED_IPS
