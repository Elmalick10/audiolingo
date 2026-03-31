import subprocess
import re

def run_cargo_check():
    result = subprocess.run(
        ["cargo", "check"],
        capture_output=True,
        text=True
    )
    return result.stderr


def suggest_fixes(errors):
    suggestions = []

    if "unresolved import" in errors:
        suggestions.append(
            "❗ Module introuvable.\n"
            "Solution : vérifier que le module est déclaré dans lib.rs ou mod.rs\n"
            "Exemple:\n"
            "pub mod modules;"
        )

    if "could not find `modules` in the crate root" in errors:
        suggestions.append(
            "❗ Rust ne trouve pas le dossier modules.\n"
            "Solution : ajouter dans lib.rs :\n"
            "pub mod modules;"
        )

    if "unexpected closing delimiter" in errors:
        suggestions.append(
            "❗ Parenthèses/accolades mal fermées.\n"
            "Solution : vérifier les blocs `{}` et `()` dans la fonction."
        )

    if "no method named `get_env`" in errors:
        suggestions.append(
            "❗ API JNI incorrecte.\n"
            "Solution : utiliser `env.with_env(|env| {...})` avec jni >= 0.22."
        )

    if "mismatched types" in errors:
        suggestions.append(
            "❗ Types incompatibles.\n"
            "Solution : vérifier Vec<i16>, i32, jshortArray."
        )

    return suggestions


def main():
    print("🔎 Analyse du projet Rust...\n")

    errors = run_cargo_check()

    if not errors.strip():
        print("✅ Aucun problème détecté.")
        return

    print("⚠️ Erreurs détectées :\n")
    print(errors)

    fixes = suggest_fixes(errors)

    if fixes:
        print("\n💡 Suggestions :\n")
        for fix in fixes:
            print("-", fix, "\n")
    else:
        print("\n🤖 Aucune solution automatique trouvée.")


if __name__ == "__main__":
    main()