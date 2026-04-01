fetch("http://localhost:8000/analytics")
.then(res => res.json())
.then(data => {
    document.getElementById("stats").innerHTML = `
        Users: ${data.users} <br>
        Revenue: $${data.revenue}
    `;
});