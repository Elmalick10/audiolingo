def approve(content):

    print("\n🧠 CONTENU GÉNÉRÉ :\n")
    print(content)

    choice = input("\nValider ? (oui/non): ")

    return choice.lower() == "oui"

stats = {
    "views": 12000,
    "likes": 2300,
    "revenu": 45
}