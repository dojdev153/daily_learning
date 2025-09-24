import pygame
import serial
import time

# -------------------
# Arduino Setup
# -------------------
arduino_port = 'COM3'  # change to your correct port
baud_rate = 9600
ser = serial.Serial(arduino_port, baud_rate)
time.sleep(2)  # wait for Arduino to reset
ser.reset_input_buffer()

# -------------------
# Pygame Setup
# -------------------
pygame.init()
win_width, win_height = 800, 600
win = pygame.display.set_mode((win_width, win_height))
pygame.display.set_caption("Gravity Sensor Game")

character_size = 50
character_color = (0, 255, 0)
character_x, character_y = win_width // 2, win_height // 2

# Maximum speed
max_speed = 8

running = True

# -------------------
# Game Loop
# -------------------
clock = pygame.time.Clock()
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Read serial data
    if ser.in_waiting > 0:
        line = ser.readline().decode('ascii', errors='ignore').strip()
        data = line.split(',')
        if len(data) == 3:
            try:
                acc_x, acc_y, acc_z = map(int, data)

                # Scale accelerometer values
                sensitivity = 5000  # adjust this until movement feels right
                dx = int(acc_x / sensitivity * max_speed)
                dy = int(acc_y / sensitivity * max_speed)

                # Update character position
                character_x += dx
                character_y -= dy  # invert Y to feel natural

                # Clamp inside window
                character_x = max(character_size // 2, min(win_width - character_size // 2, character_x))
                character_y = max(character_size // 2, min(win_height - character_size // 2, character_y))

            except ValueError:
                pass  # ignore bad data

    # Draw
    win.fill((255, 255, 255))
    pygame.draw.circle(win, character_color, (character_x, character_y), character_size // 2)
    pygame.display.flip()

    clock.tick(60)  # 60 FPS

# -------------------
# Cleanup
# -------------------
ser.close()
pygame.quit()
