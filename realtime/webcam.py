import cv2

cap = cv2.VideoCapture(0)

while True:
    ret, frame = cap.read()

    cv2.imshow("LIVE", frame)

    # sauvegarde frame pour IA
    cv2.imwrite("C:\\audiolingo\\temp\\frame.jpg", frame)

    if cv2.waitKey(1) == 27:
        break

cap.release()
cv2.destroyAllWindows()