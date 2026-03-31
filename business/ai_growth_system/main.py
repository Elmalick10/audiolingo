from brain import choose_topic, save_result
from generator import generate_video
from publisher import post_everywhere
from analyzer import analyze
from optimizer import optimize

while True:

    topic = choose_topic()

    video = generate_video(topic)

    post_everywhere(video)

    stats = analyze()

    decision = optimize(stats)

    save_result({
        "topic": topic,
        "stats": stats,
        "decision": decision
    })

    print("🚀 boucle terminée")