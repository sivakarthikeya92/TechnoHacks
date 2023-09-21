import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Question {
	private String question;
	private List<String> options;
	private int answer;

	public Question(String question, List<String> options, int answer) {
		this.question = question;
		this.options = options;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public List<String> getOptions() {
		return options;
	}

	public int getAnswer() {
		return answer;
	}
}

class Timer {
	private long startTime;
	private int Seconds;

	public Timer(int seconds) {
		this.Seconds = seconds;
	}

	public void startTimer() {
		startTime = System.currentTimeMillis();
	}

	public boolean timeOver() {
		long presentTime = System.currentTimeMillis();
		return (presentTime - startTime) / 1000 >= Seconds;
	}
}

class Quiz {
	private List<Question> questions;
	private int score;

	public Quiz() {
		questions = new ArrayList<>();
		score = 0;
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public void questionDisplay(Question question) {
		System.out.println(question.getQuestion());
		List<String> options = question.getOptions();

		for (int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}
	}

	public void Submission(int optionSelected, Question question) {
		if (optionSelected == question.getAnswer() + 1) {
			score++;
			System.out.println("Your Answer is Correct..!");
		} else {
			System.out.println("Your Answer is Incorrect");
		}
	}

	public void resultScreen() {
		System.out.println("Your Score is : " + score);
	}

	public List<Question> getQuestions() {
		return questions;
	}
}

public class QuizApplicationWithTimer {
	public static void main(String[] args) {
		Quiz quiz = new Quiz();
		Timer time = new Timer(10);
		Scanner sc = new Scanner(System.in);

		// google questions
		List<String> options1 = new ArrayList<>(Arrays.asList("North America", "Asia", "Africa", "Australia"));
		Question Q1 = new Question("Q1. Which is the biggest continent in the world?", options1, 2);
		quiz.addQuestion(Q1);

		List<String> options2 = new ArrayList<>(Arrays.asList("Great Ganga", "Niger", "Amazon", "Nile"));
		Question Q2 = new Question("Q2. Which is the longest river in the world?", options2, 4);
		quiz.addQuestion(Q2);

		List<String> options3 = new ArrayList<>(
				Arrays.asList("Indian Ocean", "Pacific Ocean", "Arctic Ocean", "Atlantic Ocean"));
		Question Q3 = new Question("Q3. Which is the largest ocean in the world?", options3, 2);
		quiz.addQuestion(Q3);

		List<String> options4 = new ArrayList<>(Arrays.asList("Param8000", "param80000", "param800", "param8"));
		Question Q4 = new Question("Q4. Which is India’s first super computer?", options4, 1);
		quiz.addQuestion(Q4);

		List<String> options5 = new ArrayList<>(
				Arrays.asList("Punjab National Bank", "State Bank of India", "Reserve Bank of India", "ICICI Bank"));
		Question Q5 = new Question("Q5. Which bank is called bankers Bank of India?", options5, 3);
		quiz.addQuestion(Q5);

		for (Question question : quiz.getQuestions()) {
			quiz.questionDisplay(question);
			time.startTimer();

			while (!time.timeOver()) {
				System.out.print("Enter Your Answer : ");
				int optionSelected = sc.nextInt();

				int correctAnswerIndex = question.getAnswer();
				int userAnswerIndex = optionSelected - 1;

				if (userAnswerIndex == correctAnswerIndex) {
					System.out.println("Your Answer is Correct!");
					quiz.Submission(optionSelected, question);
				} else {
					System.out.println("Your Answer is Incorrect");
				}
				break;
			}
		}
		quiz.resultScreen();
		sc.close();
	}
}
