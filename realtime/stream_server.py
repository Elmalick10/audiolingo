from flask import Flask, Response
import cv2

app = Flask(__name__)

def generate_stream():
    cap = cv2.VideoCapture("C:\\audiolingo\\output\\live.mp4")

    while True:
        success, frame = cap.read()
        if not success:
            break

        _, buffer = cv2.imencode('.jpg', frame)
        frame = buffer.tobytes()

        yield (b'--frame\r\n'
               b'Content-Type: image/jpeg\r\n\r\n' + frame + b'\r\n')

@app.route('/live')
def live():
    return Response(generate_stream(),
                    mimetype='multipart/x-mixed-replace; boundary=frame')

app.run(host="0.0.0.0", port=5000)