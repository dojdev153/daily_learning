import pygame

#general setup
pygame.init()
w,h = 1280,720
screen = pygame.display.set_mode((w,h))
running = True

while running:
    #event loop
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    #draw the game
    screen.fill("red")
    pygame.display.flip()

pygame.quit()
