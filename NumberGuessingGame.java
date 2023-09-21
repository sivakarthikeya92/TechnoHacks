
import java.util.Random;
import java.util.Scanner;


class NumberGuessingGame {
	public static void main(String[] args)throws Exception {
		try{
		Scanner sc = new Scanner(System.in);
		
		boolean startNewGame = true;
		while (startNewGame) {
		Random RandomNumber =  new Random();
		int minimumNumber = 1;
		int maximumNumber = 100;
		int attempts = 0;
		int totalAttempts = 10;
		
		int systemGuess = RandomNumber.nextInt(maximumNumber - minimumNumber + 1) + minimumNumber;
		boolean correctGuess = false;
		
		
		while(attempts < totalAttempts) {
			System.out.print("Enter a number from "+minimumNumber+" to "+maximumNumber+" : ");
			int userGuess = sc.nextInt();
			attempts++;
			
			int score = attempts*10;
			if(userGuess < systemGuess) {
				System.out.println("Your Guess is too Low.");
			}
			else if(userGuess > systemGuess) {
				System.out.println("Your Guess is too High.");
			}
			else {
				System.out.println("Congratulations! You have guessed the number "+userGuess+" in "+attempts+" attempts.");
				correctGuess = true;
				System.out.println("Your Score is : "+score);
				
				break;
			}
		}
		if(!correctGuess) {
			System.out.println("You have reached the maximum attempts");
		}
		System.out.print("Do you want to play again? (yes/no) : ");
		String newGame = sc.next();
		startNewGame = newGame.equalsIgnoreCase("yes");
		
		}
		System.out.println("Thanks for Playing..!");
		sc.close();
	
	}catch (java.util.InputMismatchException e) {
		System.out.println("Enter valid Input");
	}
	}
}