package ua.quest.question;

public class Question {

    private String question;
    private String option1;
    private String option2;
    private int answer;
    private String wrongOptionResult;

    public Question(String question, String option1, String option2, int answer, String wrongOptionResult) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.answer = answer;
        this.wrongOptionResult = wrongOptionResult;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public int getAnswer() {
        return answer;
    }

    public String getWrongOptionResult() {
        return wrongOptionResult;
    }
}