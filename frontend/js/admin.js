async function getUsers(){

  const res = await fetch("http://localhost:5000/users")
  const users = await res.json()

  const list = document.getElementById("users")
  list.innerHTML = ""

  users.forEach(u=>{
    const li = document.createElement("li")
    li.innerText = u.email
    list.appendChild(li)
  })
}