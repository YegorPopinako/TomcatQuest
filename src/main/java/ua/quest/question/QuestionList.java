package ua.quest.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class QuestionList {

    private static Logger logger = Logger.getLogger(QuestionList.class.getName());
    private static List<Question> questions = new ArrayList<>();

    private static final int QUESTION_INDEX = 0;
    private static final int OPTION1_INDEX = 1;
    private static final int OPTION2_INDEX = 2;
    private static final int ANSWER_INDEX = 3;
    private static final int WRONG_OPTION_RESULT_INDEX = 4;

    public static final String DELIMITER = "\\|";

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(QuestionList.class.getClassLoader().getResourceAsStream("questions"))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                questions.add(new Question(
                        parts[QUESTION_INDEX],
                        parts[OPTION1_INDEX],
                        parts[OPTION2_INDEX],
                        Integer.parseInt(parts[ANSWER_INDEX]),
                        parts[WRONG_OPTION_RESULT_INDEX]
                ));
            }
        } catch (IOException e) {
            logger.warning("Error reading questions file");
        }
    }

    public static List<Question> getQuestions() {
        return questions;
    }

    public static void setQuestions(List<Question> questions) {
        QuestionList.questions = questions;
    }
}
