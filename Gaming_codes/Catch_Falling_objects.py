import pygame
import random
import sys

# Initialize Pygame
pygame.init()

# Constants
SCREEN_WIDTH = 800
SCREEN_HEIGHT = 600
FPS = 60
PLAYER_WIDTH = 50
PLAYER_HEIGHT = 50
APPLE_WIDTH = 30
APPLE_HEIGHT = 30
BOMB_WIDTH = 30
BOMB_HEIGHT = 30
APPLE_COLOR = (255, 0, 0)  # Red for apples
BOMB_COLOR = (0, 0, 0)  # Black for bombs
PLAYER_COLOR = (0, 255, 0)  # Green for player

# Set up the screen
screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
pygame.display.set_caption("Catch the Falling Objects")

# Player settings
player_x = SCREEN_WIDTH // 2
player_y = SCREEN_HEIGHT - PLAYER_HEIGHT - 10
player_speed = 7

# Game objects
apples = []
bombs = []
score = 0

# Function to create a new falling object
def create_object():
    if random.randint(0, 1) == 0:  # 50% chance to create an apple or a bomb
        x = random.randint(0, SCREEN_WIDTH - APPLE_WIDTH)
        apples.append(pygame.Rect(x, 0, APPLE_WIDTH, APPLE_HEIGHT))
    else:
        x = random.randint(0, SCREEN_WIDTH - BOMB_WIDTH)
        bombs.append(pygame.Rect(x, 0, BOMB_WIDTH, BOMB_HEIGHT))

# Game loop
clock = pygame.time.Clock()
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    # Get keys pressed
    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT] and player_x > 0:
        player_x -= player_speed
    if keys[pygame.K_RIGHT] and player_x < SCREEN_WIDTH - PLAYER_WIDTH:
        player_x += player_speed

    # Create new objects
    if random.randint(0, 30) == 0:  # Adjust frequency of new objects
        create_object()

    # Move objects down
    for apple in apples:
        apple.y += 5  # Falling speed
        if apple.y > SCREEN_HEIGHT:
            apples.remove(apple)
        if apple.colliderect(pygame.Rect(player_x, player_y, PLAYER_WIDTH, PLAYER_HEIGHT)):
            score += 1
            apples.remove(apple)  # Remove apple when caught

    for bomb in bombs:
        bomb.y += 5  # Falling speed
        if bomb.y > SCREEN_HEIGHT:
            bombs.remove(bomb)
        if bomb.colliderect(pygame.Rect(player_x, player_y, PLAYER_WIDTH, PLAYER_HEIGHT)):
            print("Game Over! Final Score:", score)
            pygame.quit()
            sys.exit()

    # Fill the background
    screen.fill((135, 206, 250))  # Sky blue color

    # Draw the player
    pygame.draw.rect(screen, PLAYER_COLOR, (player_x, player_y, PLAYER_WIDTH, PLAYER_HEIGHT))

    # Draw apples
    for apple in apples:
        pygame.draw.rect(screen, APPLE_COLOR, apple)

    # Draw bombs
    for bomb in bombs:
        pygame.draw.rect(screen, BOMB_COLOR, bomb)

    # Draw score
    font = pygame.font.Font(None, 36)
    score_text = font.render(f'Score: {score}', True, (0, 0, 0))
    screen.blit(score_text, (10, 10))

    # Update the display
    pygame.display.flip()

    # Cap the frame rate
    clock.tick(FPS)