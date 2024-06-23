package ua.quest.question;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Question {

    private String question;
    private String option1;
    private String option2;
    private int answer;
    private String wrongOptionResult;
}