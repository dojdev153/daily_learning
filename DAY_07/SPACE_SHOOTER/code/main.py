import pygame
import random

#general setup
pygame.init()
w,h = 1280,720
screen = pygame.display.set_mode((w,h))
pygame.display.set_caption("space shooter")
icon = pygame.image.load("../images/logo.png")
pygame.display.set_icon(icon)
running = True

#plain surface
surface = pygame.Surface((100,200))
surface.fill("orange")
ship_x= 100

#importing an image
img = pygame.image.load("../images/space.png").convert_alpha()
img = pygame.transform.scale(img,(80,80))

#importing the star
star = pygame.image.load("../images/star.png").convert_alpha()
star = pygame.transform.scale(star,(100,100))
star.set_alpha(100)

#generate random star positions
stars=[]
for i in range(20):
    x = random.randint(0,w)
    y = random.randint(0,h)
    alpha = random.randint(50,200)
    star_copy = star.copy()
    star_copy.set_alpha(alpha)
    stars.append((x,y,star_copy))

while running:
    #event loop
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

#draw the game
    #background
    screen.fill("black")
    #stars
    for(x,y,s) in stars:
        screen.blit(s,(x,y))
    #ship
    ship_x +=0.1
    screen.blit(img,(ship_x,200))
    pygame.display.flip()

pygame.quit()
