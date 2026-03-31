from flask import Flask, request

app = Flask(__name__)

@app.route("/payment-success")
def success():
    # activer premium auto
    user_id = request.args.get("user")
    
    # DB update ici
    print(f"User {user_id} premium activé")

    return "OK"