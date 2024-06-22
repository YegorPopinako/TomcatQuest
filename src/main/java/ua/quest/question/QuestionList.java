package ua.quest.question;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class QuestionList {

    @Getter
    private static final List<Question> questions = new ArrayList();

    static{
        questions.add(new Question("What is the capital of Ukraine?", "Kiev", "London", 1));
        questions.add(new Question("What is the capital of Britain?", "Berlin", "London", 2));
        questions.add(new Question("What is the capital of France?", "Paris", "London", 1));
    }
}
