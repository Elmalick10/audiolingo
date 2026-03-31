def generate_user_content(user_id, prompt):

    # charger préférences utilisateur
    preferences = get_user_preferences(user_id)

    full_prompt = f"""
Style: {preferences['style']}
Langue: {preferences['language']}

Contenu: {prompt}
"""

    return generate_content(full_prompt)