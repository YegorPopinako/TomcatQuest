package ua.quest.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class QuestionList {

    private static List<Question> questions = new ArrayList();

    static{
        try(BufferedReader reader = Files.newBufferedReader(Path.of("C:\\Java\\Projects\\QuestTomcat\\src\\main\\resources\\questions"))){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\|");
                questions.add(new Question(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Question> getQuestions() {
        return questions;
    }

    public static void setQuestions(List<Question> questions) {
        QuestionList.questions = questions;
    }
}
