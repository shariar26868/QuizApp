import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class takeQuiz {
    private static final String USERS_FILE_PATH = "./src/main/resources/user.json";
    private static final String QUIZ_FILE_PATH = "./src/main/resources/quiz.json";
    private static final int NUM_QUESTIONS = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get username and password
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Authenticate user
        JSONObject user = authenticateUser(username, password);
        if (user == null) {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        // Check user role
        String role = (String) user.get("role");
        if (role.equals("admin")) {
            System.out.println("Welcome admin! Please create new questions.");
            addQuestions(scanner);
        } else if (role.equals("student")) {
            System.out.println("Welcome " + username + "! Press 's' to start the quiz.");
            String input = scanner.nextLine();
            if (input.equals("s")) {
                List<JSONObject> quizQuestions = getQuizQuestions(NUM_QUESTIONS);
                int score = startQuiz(scanner, quizQuestions);
                displayResult(score);
            }
        } else {
            System.out.println("Unknown role. Exiting...");
        }

    }
    private static JSONObject authenticateUser(String username, String password) {
        try (FileReader reader = new FileReader(USERS_FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONArray users = (JSONArray) parser.parse(reader);

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                if (username.equals(user.get("username")) && password.equals(user.get("password"))) {
                    return user;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static void addQuestions(Scanner scanner) {
        JSONArray questions = new JSONArray();
        JSONParser parser = new JSONParser();

        try {
            questions = (JSONArray) parser.parse(new FileReader(QUIZ_FILE_PATH));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        while (true) {
            JSONObject question = new JSONObject();
            System.out.println("System:> Input your question");
            String questionText = scanner.nextLine();
            System.out.println("Admin:> Input option 1:");
            String option1 = scanner.nextLine();
            System.out.println("Admin:> Input option 2:");
            String option2 = scanner.nextLine();
            System.out.println("Admin:> Input option 3:");
            String option3 = scanner.nextLine();
            System.out.println("Admin:> Input option 4:");
            String option4 = scanner.nextLine();
            System.out.println("System:> What is the answer key?");
            int answerKey = scanner.nextInt();

            question.put("question", questionText);
            question.put("option 1", option1);
            question.put("option 2", option2);
            question.put("option 3", option3);
            question.put("option 4", option4);
            question.put("answerkey", answerKey);

            questions.add(question);

            System.out.println("System:> Saved successfully! Do you want to add more questions? (press 's' for start and 'q' for quit)");
            scanner.nextLine();
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
        }
        try (FileWriter fileWriter = new FileWriter(QUIZ_FILE_PATH)) {
            fileWriter.write(questions.toJSONString());
            System.out.println("System:> Questions saved to " + QUIZ_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<JSONObject> getQuizQuestions(int numQuestions) {
        List<JSONObject> quizQuestions = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            JSONArray questions = (JSONArray) parser.parse(new FileReader(QUIZ_FILE_PATH));
            int totalQuestions = questions.size();

            if (totalQuestions < numQuestions) {
                System.out.println("System:> Insufficient questions in the quiz bank. Please add more questions.");
                return quizQuestions;
            }

            Random random = new Random();
            Set<Integer> selectedQuestionIndices = new HashSet<>();

            while (selectedQuestionIndices.size() < numQuestions) {
                int randomIndex = random.nextInt(totalQuestions);
                if (selectedQuestionIndices.add(randomIndex)) {  // Using add() to check uniqueness
                    quizQuestions.add((JSONObject) questions.get(randomIndex));
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return quizQuestions;
    }
    private static int startQuiz(Scanner scanner, List<JSONObject> quizQuestions) {
        int score = 0;

        for (int questionNum = 0; questionNum < quizQuestions.size(); questionNum++) {
            JSONObject question = quizQuestions.get(questionNum);
            System.out.println("[Question " + (questionNum + 1) + "] " + question.get("question"));
            System.out.println("1. " + question.get("option 1"));
            System.out.println("2. " + question.get("option 2"));
            System.out.println("3. " + question.get("option 3"));
            System.out.println("4. " + question.get("option 4"));

            System.out.print("Student:> ");
            int userAnswer = scanner.nextInt();
            int answerKey = ((Long) question.get("answerkey")).intValue();

            if (userAnswer == answerKey) {
                score++;
            }
        }

        return score;
    }

    private static void displayResult(int score) {
        System.out.println("Quiz has been completed successfully!");
        String feedback;

        if (score >= 8) {
            feedback = "Excellent! You have scored ";
        } else if (score >= 5) {
            feedback = "Good. You have scored ";
        } else if (score >= 2) {
            feedback = "Very poor! You have scored ";
        } else {
            feedback = "Very sorry you are failed. You have scored ";
        }

        System.out.println(feedback + score + " out of " + NUM_QUESTIONS);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to start again? Press 's' for start or 'q' for quit");
        String input = scanner.nextLine();
        if (input.equals("s")) {
            System.out.println();
            main(null);
        }
    }
}
