#include <Servo.h>

// --- Joystick pins ---
#define VRx A2
#define VRy A3
#define JOY_VCC 7   // Digital pin supplying 5V to joystick
#define JOY_GND 6   // Digital pin acting as GND for joystick

// --- Servo and buzzer pins ---
#define SERVO_PIN 9
#define BUZZER_PIN 11

Servo myservo;

// --- Joystick calibration values ---
// (Adjust these after testing with Serial Monitor)
const int JOY_MIN = 100;   // Minimum analog value (joystick fully left)
const int JOY_MAX = 920;   // Maximum analog value (joystick fully right)

void setup() {
  Serial.begin(9600);

  // --- Power the joystick using digital pins ---
  pinMode(JOY_VCC, OUTPUT);
  pinMode(JOY_GND, OUTPUT);
  digitalWrite(JOY_VCC, HIGH); // A "software" 5V
  digitalWrite(JOY_GND, LOW);  // A "software" GND

  // --- Setup servo ---
  myservo.attach(SERVO_PIN);

  // --- Setup buzzer ---
  pinMode(BUZZER_PIN, OUTPUT);
  digitalWrite(BUZZER_PIN, LOW);
}

void loop() {
  // --- Read joystick values ---
  int x_val = analogRead(VRx);
  int y_val = analogRead(VRy);

  // --- Map X-axis to servo angle using calibration values ---
  int angle = map(x_val, JOY_MIN, JOY_MAX, 0, 180);

  // --- Limit angle to safe range ---
  angle = constrain(angle, 0, 180);

  // --- Move servo ---
  myservo.write(angle);

  // --- Buzzer feedback: warn near ends ---
  if (angle < 15 || angle > 165) {
    tone(BUZZER_PIN, 1000);  // 1 kHz tone
  } else {
    noTone(BUZZER_PIN);
  }

  // --- Debug info ---
  Serial.print("X: "); Serial.print(x_val);
  Serial.print("\tY: "); Serial.print(y_val);
  Serial.print("\tServo: "); Serial.print(angle);
  Serial.print("\tBuzzer: ");
  Serial.println((angle < 15 || angle > 165) ? "ON" : "OFF");

  delay(50);  // Slight delay for stability
}
