import pygame
import random
import sys

# -------------------
# Pygame Setup
# -------------------
pygame.init()
width, height = 800, 600
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Arcade Pong: Chaos Mode")
clock = pygame.time.Clock()
font = pygame.font.SysFont("Arial", 30)

# Colors
white = (255, 255, 255)
black = (0, 0, 0)
red = (255, 0, 0)
green = (0, 255, 0)
blue = (0, 0, 255)
yellow = (255, 255, 0)

# Paddle
paddle_width, paddle_height = 20, 100
player_speed = 7
ai_speed = 4

# Ball
ball_size = 20
ball_count = 3

# Score
player_score = 0
comp_score = 0
win_score = 5

# Power-ups
powerups = []
POWERUP_SIZE = 20
POWERUP_TYPES = ["grow", "shrink_ball", "fast_paddle"]
powerup_timer = 0

# -------------------
# Helper functions
# -------------------
def reset_ball(ball):
    ball["x"] = width // 2
    ball["y"] = height // 2
    ball["speedx"] *= random.choice([-1, 1])
    ball["speedy"] = random.choice([-3, -2, 2, 3])

def spawn_powerup():
    return {
        "x": random.randint(100, width-100),
        "y": random.randint(50, height-50),
        "type": random.choice(POWERUP_TYPES),
        "active": True
    }

# -------------------
# Start Screen
# -------------------
def start_screen():
    while True:
        screen.fill(black)
        title_text = font.render("Arcade Pong: Chaos Mode", True, white)
        instruction_text = font.render("Press SPACE to Start", True, white)
        screen.blit(title_text, (width//2 - title_text.get_width()//2, height//2 - 80))
        screen.blit(instruction_text, (width//2 - instruction_text.get_width()//2, height//2))
        pygame.display.flip()
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    return

# -------------------
# Game Over Screen
# -------------------
def game_over(winner):
    while True:
        screen.fill(black)
        over_text = font.render(f"{winner} Wins!", True, white)
        restart_text = font.render("Press R to Restart or Q to Quit", True, white)
        screen.blit(over_text, (width//2 - over_text.get_width()//2, height//2 - 50))
        screen.blit(restart_text, (width//2 - restart_text.get_width()//2, height//2 + 20))
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

# -------------------
# Main Game Loop
# -------------------
def main_game():
    global player_speed
    global player_score, comp_score, powerups, powerup_timer, paddle_height

    # Player and AI paddles
    player_y = height // 2 - paddle_height // 2
    comp_y = height // 2 - paddle_height // 2

    # Balls
    balls = [{"x": width//2, "y": height//2, "speedx": 3, "speedy": 3} for _ in range(ball_count)]

    running = True
    powerups = []

    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

        # Keyboard input
        keys = pygame.key.get_pressed()
        if keys[pygame.K_UP]:
            player_y -= player_speed
        if keys[pygame.K_DOWN]:
            player_y += player_speed
        player_y = max(0, min(height - paddle_height, player_y))

        # AI paddle
        target_ball = min(balls, key=lambda b: abs(b["x"] - (width - paddle_width)))
        if comp_y + paddle_height // 2 < target_ball["y"]:
            comp_y += ai_speed
        elif comp_y + paddle_height // 2 > target_ball["y"]:
            comp_y -= ai_speed
        comp_y = max(0, min(height - paddle_height, comp_y))

        # Move balls
        for ball in balls:
            ball["x"] += ball["speedx"]
            ball["y"] += ball["speedy"]

            # Collisions with top/bottom
            if ball["y"] <= 0 or ball["y"] >= height - ball_size:
                ball["speedy"] *= -1

            # Collisions with paddles
            if (ball["x"] <= paddle_width and player_y < ball["y"] < player_y + paddle_height) or \
               (ball["x"] >= width - paddle_width - ball_size and comp_y < ball["y"] < comp_y + paddle_height):
                ball["speedx"] *= -1

            # Out of bounds (score)
            if ball["x"] < 0:
                comp_score += 1
                reset_ball(ball)
            elif ball["x"] > width:
                player_score += 1
                reset_ball(ball)

        # Spawn power-ups occasionally
        powerup_timer += 1
        if powerup_timer > 600:  # ~10 seconds at 60 FPS
            powerups.append(spawn_powerup())
            powerup_timer = 0

        # Check power-up collisions
        for pu in powerups:
            if pu["active"] and player_y < pu["y"] < player_y + paddle_height and paddle_width > 0:
                if pu["type"] == "grow":
                    paddle_height = min(paddle_height + 50, 200)
                elif pu["type"] == "shrink_ball":
                    for ball in balls:
                        ball["speedx"] *= 0.8
                        ball["speedy"] *= 0.8
                elif pu["type"] == "fast_paddle":
                    
                    player_speed += 3
                pu["active"] = False

        # Draw everything
        screen.fill(black)
        pygame.draw.rect(screen, white, (0, player_y, paddle_width, paddle_height))
        pygame.draw.rect(screen, white, (width - paddle_width, comp_y, paddle_width, paddle_height))

        for ball in balls:
            pygame.draw.circle(screen, red, (int(ball["x"]), int(ball["y"])), ball_size // 2)

        # Draw power-ups
        for pu in powerups:
            if pu["active"]:
                color = green if pu["type"] == "grow" else yellow if pu["type"] == "fast_paddle" else blue
                pygame.draw.rect(screen, color, (pu["x"], pu["y"], POWERUP_SIZE, POWERUP_SIZE))

        # Draw middle line
        pygame.draw.aaline(screen, white, (width//2, 0), (width//2, height))

        # Draw scores
        player_text = font.render(str(player_score), True, white)
        comp_text = font.render(str(comp_score), True, white)
        screen.blit(player_text, (width//4 - player_text.get_width()//2, 20))
        screen.blit(comp_text, (3*width//4 - comp_text.get_width()//2, 20))

        pygame.display.flip()
        clock.tick(60)

        # Check win condition
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

# -------------------
# Run the game
# -------------------
start_screen()
while True:
    main_game()
