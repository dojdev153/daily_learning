import serial, time

PORT = "COM5"   # change if needed
BAUD = 115200

ser = serial.Serial(PORT, BAUD, timeout=1)
time.sleep(2)

print("Reading data from Arduino...")

while True:
    line = ser.readline().decode(errors="ignore").strip()
    if line:
        print("Received:", line)
