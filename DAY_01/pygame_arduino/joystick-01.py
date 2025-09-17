import pygame
import serial
import time

# -------------------
# Arduino Setup
# -------------------
arduino_port = 'COM3'  # change if needed
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
pygame.display.set_caption("Joystick Game")

character_size = 50
character_color = (0, 255, 0)
character_x, character_y = win_width // 2, win_height // 2

# Maximum speed in pixels per frame
max_speed = 8

running = True

# -------------------
# Helper function
# -------------------
def map_joystick(value):
    """
    Map joystick analog value (0-1023) to -max_speed to +max_speed
    Deadzone around center to avoid drift
    """
    deadzone = 50  # small zone around center where movement = 0
    center = 512
    if abs(value - center) < deadzone:
        return 0
    # scale linearly to max_speed
    return int((value - center) / (1023/2) * max_speed)

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
                joy_x, joy_y, button_state = map(int, data)

                # Map joystick values smoothly
                dx = map_joystick(joy_x)
                dy = map_joystick(joy_y)

                # Update character position
                character_x += dx
                character_y += dy

                # Clamp to window boundaries
                character_x = max(character_size // 2, min(win_width - character_size // 2, character_x))
                character_y = max(character_size // 2, min(win_height - character_size // 2, character_y))

                # Change color when button pressed
                character_color = (0, 0, 255) if button_state == 1 else (0, 255, 0)

            except ValueError:
                pass  # ignore malformed lines

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
