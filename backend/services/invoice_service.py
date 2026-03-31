from reportlab.platypus import SimpleDocTemplate, Paragraph

def generate_invoice(user_id, amount):

    file = f"C:\\audiolingo\\invoices\\invoice_{user_id}.pdf"

    doc = SimpleDocTemplate(file)

    content = [
        Paragraph(f"Facture utilisateur {user_id}"),
        Paragraph(f"Montant: {amount} €")
    ]

    doc.build(content)

    return file