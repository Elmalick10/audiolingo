const express = require("express");
const stripe = require("stripe")("TA_CLE_STRIPE");

const app = express();
app.use(express.json());

app.post("/pay", async (req, res) => {

    const paymentIntent = await stripe.paymentIntents.create({
        amount: 500, // 5€
        currency: "eur",
    });

    res.send({
        clientSecret: paymentIntent.client_secret,
    });
});

app.listen(3000);