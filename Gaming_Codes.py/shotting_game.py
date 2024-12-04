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
BULLET_WIDTH = 5
BULLET_HEIGHT = 10
TARGET_WIDTH = 50
TARGET_HEIGHT = 50
PLAYER_COLOR = (0, 255, 0)  # Green for player
BULLET_COLOR = (255, 0, 0)  # Red for bullets
TARGET_COLOR = (0, 0, 255)  # Blue for targets

# Set up the screen
screen = pygame.display.set_mode((SCREEN_WIDTH, SCREEN_HEIGHT))
pygame.display.set_caption("Shooting Game")

# Player settings
player_x = SCREEN_WIDTH // 2
player_y = SCREEN_HEIGHT - PLAYER_HEIGHT - 10
player_speed = 7

# Game objects
bullets = []
targets = []
score = 0

# Function to create a new target
def create_target():
    x = random.randint(0, SCREEN_WIDTH - TARGET_WIDTH)
    return pygame.Rect(x, 0, TARGET_WIDTH, TARGET_HEIGHT)

# Game loop
clock = pygame.time.Clock()
create_target_timer = 0

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
    if keys[pygame.K_SPACE]:
        # Shoot bullet
        bullet_rect = pygame.Rect(player_x + PLAYER_WIDTH // 2 - BULLET_WIDTH // 2, player_y, BULLET_WIDTH, BULLET_HEIGHT)
        bullets.append(bullet_rect)

    # Move bullets
    for bullet in bullets[:]:
        bullet.y -= 10  # Bullet speed
        if bullet.y < 0:
            bullets.remove(bullet)

    # Move targets and check for collisions
    for target in targets[:]:
        target.y += 5  # Target speed
        if target.y > SCREEN_HEIGHT:
            targets.remove(target)
        for bullet in bullets[:]:
            if bullet.colliderect(target):
                bullets.remove(bullet)  # Remove bullet
                targets.remove(target)  # Remove target
                score += 1  # Increase score
                break  # Exit the inner loop after collision

    # Create new targets at intervals
    create_target_timer += 1
    if create_target_timer >= 30:  # Create a new target every 30 frames
        targets.append(create_target())
        create_target_timer = 0

    # Fill the background
    screen.fill((135, 206, 250))  # Sky blue color

    # Draw the player
    pygame.draw.rect(screen, PLAYER_COLOR, (player_x, player_y, PLAYER_WIDTH, PLAYER_HEIGHT))

    # Draw bullets
    for bullet in bullets:
        pygame.draw.rect(screen, BULLET_COLOR, bullet)

    # Draw targets
    for target in targets:
        pygame.draw.rect(screen, TARGET_COLOR, target)

    # Draw score
    font = pygame.font.Font(None, 36)
    score_text = font.render(f'Score: {score}', True, (0, 0, 0))
    screen.blit(score_text, (10, 10))

    # Update the display
    pygame.display.flip()

    # Cap the frame rate
    clock.tick(FPS)