import pygame
import random
import sys
import serial

pygame.init()
w, h = 800, 600
screen = pygame.display.set_mode((w, h))
pygame.display.set_caption("Arcade Pong: Chaos Mode (Arduino Joystick)")
clock = pygame.time.Clock()
font = pygame.font.SysFont("Arial", 30)

# Arduino Setup
arduino = serial.Serial('COM3', 9600, timeout=0.1)

# Colors
white = (255, 255, 255)
black = (0, 0, 0)
red = (255, 0, 0)
green = (0, 255, 0)
blue = (0, 0, 255)
yellow = (255, 255, 0)
trail_color = (255, 100, 100)

# Game Settings
paddle_w, paddle_h = 20, 100
player_speed = 7
ai_speed = 4
ball_size = 20
ball_count = 3
player_score = 0
comp_score = 0
win_score = 5

powerups = []
POWERUP_SIZE = 20
POWERUP_TYPES = ["grow", "shrink_ball", "fast_paddle"]
powerup_timer = 0

# Audio
pygame.mixer.init()
hit_sound = pygame.mixer.Sound("hit.wav")
score_sound = pygame.mixer.Sound("score.wav")
powerup_sound = pygame.mixer.Sound("powerup.wav")

# Helper Functions
def reset_ball(ball):
    ball["x"] = w // 2
    ball["y"] = h // 2
    ball["speedx"] *= random.choice([-1, 1])
    ball["speedy"] = random.choice([-3, -2, 2, 3])
    ball["trail"] = []

def spawn_powerup():
    return {
        "x": random.randint(100, w-100),
        "y": random.randint(50, h-50),
        "type": random.choice(POWERUP_TYPES),
        "active": True
    }

def start_screen():
    while True:
        screen.fill(black)
        title_text = font.render("Arcade Pong: Chaos Mode", True, white)
        instruction_text = font.render("Press SPACE to Start", True, white)
        screen.blit(title_text, (w//2 - title_text.get_width()//2, h//2 - 80))
        screen.blit(instruction_text, (w//2 - instruction_text.get_width()//2, h//2))
        pygame.display.flip()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    return

def game_over(winner):
    while True:
        screen.fill(black)
        over_text = font.render(f"{winner} Wins!", True, white)
        restart_text = font.render("Press R to Restart or Q to Quit", True, white)
        screen.blit(over_text, (w//2 - over_text.get_width()//2, h//2 - 50))
        screen.blit(restart_text, (w//2 - restart_text.get_width()//2, h//2 + 20))
        pygame.display.flip()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_r:
                    return True
                if event.key == pygame.K_q:
                    pygame.quit()
                    sys.exit()

# Main Game Loop
def main_game():
    global player_speed, player_score, comp_score, powerups, powerup_timer, paddle_h

    player_y = h // 2 - paddle_h // 2
    comp_y = h // 2 - paddle_h // 2
    balls = [{"x": w//2, "y": h//2, "speedx": 3, "speedy": 3, "trail": []} for _ in range(ball_count)]
    running = True
    powerups = []

    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

        # Arduino Joystick Input
        try:
            line = arduino.readline().decode().strip()
            if line != "":
                val, switch = map(int, line.split(","))
                player_y = int((val / 1023) * (h - paddle_h))

                if switch == 1:
                    for pu in powerups:
                        if pu["active"]:
                            if pu["type"] == "grow":
                                paddle_h = min(paddle_h + 50, 200)
                            elif pu["type"] == "shrink_ball":
                                for ball in balls:
                                    ball["speedx"] *= 0.8
                                    ball["speedy"] *= 0.8
                            elif pu["type"] == "fast_paddle":
                                player_speed += 3
                            pu["active"] = False
                            pygame.mixer.Sound.play(powerup_sound)
                            break
        except:
            pass

        # AI Paddle
        target_ball = min(balls, key=lambda b: abs(b["x"] - (w - paddle_w)))
        if comp_y + paddle_h // 2 < target_ball["y"] - 10:
            comp_y += ai_speed
        elif comp_y + paddle_h // 2 > target_ball["y"] + 10:
            comp_y -= ai_speed
        comp_y = max(0, min(h - paddle_h, comp_y))

        # Move Balls
        for ball in balls:
            ball["trail"].append((ball["x"], ball["y"]))
            if len(ball["trail"]) > 8:
                ball["trail"].pop(0)

            ball["x"] += ball["speedx"]
            ball["y"] += ball["speedy"]

            if ball["y"] <= 0 or ball["y"] >= h - ball_size:
                ball["speedy"] *= -1

            if (ball["x"] <= paddle_w and player_y < ball["y"] < player_y + paddle_h) or \
               (ball["x"] >= w - paddle_w - ball_size and comp_y < ball["y"] < comp_y + paddle_h):
                ball["speedx"] *= -1
                pygame.mixer.Sound.play(hit_sound)
                if random.random() < 0.2:
                    ball["speedy"] += random.choice([-1, 1])

            if ball["x"] < 0:
                comp_score += 1
                pygame.mixer.Sound.play(score_sound)
                reset_ball(ball)
            elif ball["x"] > w:
                player_score += 1
                pygame.mixer.Sound.play(score_sound)
                reset_ball(ball)

        # Power-ups
        powerup_timer += 1
        if powerup_timer > 600:
            powerups.append(spawn_powerup())
            powerup_timer = 0

        for pu in powerups:
            if pu["active"]:
                color = green if pu["type"] == "grow" else yellow if pu["type"] == "fast_paddle" else blue
                pygame.draw.rect(screen, color, (pu["x"], pu["y"], POWERUP_SIZE, POWERUP_SIZE))

        # Draw Everything
        screen.fill(black)
        pygame.draw.rect(screen, white, (0, player_y, paddle_w, paddle_h))
        pygame.draw.rect(screen, white, (w - paddle_w, comp_y, paddle_w, paddle_h))

        for ball in balls:
            for i, pos in enumerate(ball["trail"]):
                alpha = 255 - i * 30
                trail_surf = pygame.Surface((ball_size, ball_size), pygame.SRCALPHA)
                pygame.draw.circle(trail_surf, (*trail_color[:3], alpha), (ball_size//2, ball_size//2), ball_size // 2)
                screen.blit(trail_surf, pos)
            pygame.draw.circle(screen, red, (int(ball["x"]), int(ball["y"])), ball_size // 2)

        pygame.draw.aaline(screen, white, (w//2, 0), (w//2, h))

        player_text = font.render(str(player_score), True, white)
        comp_text = font.render(str(comp_score), True, white)
        screen.blit(player_text, (w//4 - player_text.get_width()//2, 20))
        screen.blit(comp_text, (3*w//4 - comp_text.get_width()//2, 20))

        pygame.display.flip()
        clock.tick(60)

        # Check Win Condition
        if player_score >= win_score:
            if game_over("Player"):
                player_score = 0
                comp_score = 0
                return
        elif comp_score >= win_score:
            if game_over("Computer"):
                player_score = 0
                comp_score = 0
                return

# Run the Game
start_screen()
while True:
    main_game()
