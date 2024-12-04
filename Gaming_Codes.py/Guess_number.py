import random

def guess_the_number():
    print("Welcome to the Guess the Number Game!")

    # Set the range for the random number
    lower_bound = 1
    upper_bound = 100
    secret_number = random.randint(lower_bound, upper_bound)
    attempts = 10  # Number of attempts allowed

    print(f"I'm thinking of a number between {lower_bound} and {upper_bound}.")
    print(f"You have {attempts} attempts to guess it.")

    for attempt in range(1, attempts + 1):
        guess = input(f"Attempt {attempt}: Enter your guess: ")

        # Validate input
        if not guess.isdigit():
            print("Please enter a valid number.")
            continue

        guess = int(guess)

        if guess < lower_bound or guess > upper_bound:
            print(f"Please guess a number between {lower_bound} and {upper_bound}.")
            continue

        if guess < secret_number:
            print("Too low! Try again.")
        elif guess > secret_number:
            print("Too high! Try again.")
        else:
            print(f"Congratulations! You've guessed the number {secret_number} in {attempt} attempts.")
            break
    else:
        print(f"Sorry, you've used all your attempts. The number was {secret_number}.")

if __name__ == "__main__":
    guess_the_number()