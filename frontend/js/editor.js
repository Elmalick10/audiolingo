let timeline = []

function addClip(){

  const clip = {
    id: Date.now(),
    duration: 5
  }

  timeline.push(clip)
  renderTimeline()
}

function renderTimeline(){

  const el = document.getElementById("timeline")
  el.innerHTML = ""

  timeline.forEach(c=>{
    const div = document.createElement("div")
    div.className = "bg-blue-500 p-2"
    div.innerText = "Clip " + c.id
    el.appendChild(div)
  })
}