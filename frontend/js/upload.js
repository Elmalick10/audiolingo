async function uploadImage(file){

  const form = new FormData()
  form.append("image", file)

  await fetch("http://localhost:5000/upload", {
    method: "POST",
    body: form
  })

  alert("Avatar prêt 🎤")
}