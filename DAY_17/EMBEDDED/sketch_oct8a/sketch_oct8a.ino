#include <Servo.h>

// Joystick pins
#define VRx A2
#define VRy A3
#define JOY_VCC 7   // Digital pin to supply 5V to joystick
#define JOY_GND 6   // Digital pin to GND joystick

// Servo and buzzer pins
#define SERVO_PIN 9
#define BUZZER_PIN 11

Servo myservo;

void setup() {
  Serial.begin(9600);

  // Hardcode joystick power
  pinMode(JOY_VCC, OUTPUT);
  pinMode(JOY_GND, OUTPUT);
  digitalWrite(JOY_VCC, HIGH); // Supply 5V
  digitalWrite(JOY_GND, LOW);  // Connect GND

  // Setup servo
  myservo.attach(SERVO_PIN);

  // Setup buzzer
  pinMode(BUZZER_PIN, OUTPUT);
  digitalWrite(BUZZER_PIN, LOW);
}

void loop() {
  int x_val = analogRead(VRx);
  int y_val = analogRead(VRy);

  // Map joystick X to servo angle
  int angle = map(x_val, 0, 1023, 0, 180);
  myservo.write(angle);

  // --- Buzzer control ---
  // Active if servo is near extreme angles
  if (angle < 15 || angle > 165) {
    tone(BUZZER_PIN, 1000); // 1 kHz sound
  } else {
    noTone(BUZZER_PIN);
  }

  // Debug info
  Serial.print("X: "); Serial.print(x_val);
  Serial.print("\tY: "); Serial.print(y_val);
  Serial.print("\tServo: "); Serial.print(angle);
  Serial.print("\tBuzzer: "); Serial.println(angle < 15 || angle > 165 ? "ON" : "OFF");

  delay(50);
}
