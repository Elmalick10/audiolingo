def validate_content(text):

    banned_words = [
        "haine", "violence", "racisme", "religion mauvaise"
    ]

    for word in banned_words:
        if word in text.lower():
            return False

    return True