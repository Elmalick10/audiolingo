const API = "http://localhost:5000"

async function generateVideo(prompt){

  const token = localStorage.getItem("token")

  const res = await fetch(API + "/video", {
    method: "POST",
    headers: {
      "Content-Type":"application/json",
      "Authorization": token
    },
    body: JSON.stringify({prompt})
  })

  return await res.json()
}