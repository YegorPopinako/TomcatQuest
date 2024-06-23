package ua.quest.question;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {

    @Getter
    @Setter
    private static List<Question> questions = new ArrayList();

    static{
        questions.add(new Question("You must decide which path to take", "The left path, which is shrouded in mist", "The right path, which is well-trodden and appears safe", 1, "The well-trodden path leads you into a hidden pit trap. With no way to climb out and no one around to help."));
        questions.add(new Question("You carefully navigate the misty path until you reach a hidden waterfall. Behind the waterfall, you discover a cave entrance. " +
                "Inside the cave, you find yourself in a large chamber. There are two tunnels: one on the left, illuminated by glowing crystals, " +
                "and one on the right, covered in thick cobwebs.\n", "The left tunnel with glowing crystals", "The right tunnel covered in cobwebs", 1, "The cobweb-covered tunnel is filled with giant spiders. You are quickly overwhelmed and become their prey."));
        questions.add(new Question("The tunnel with glowing crystals leads you to a magical library filled with ancient books. You go to a mystical gates where a guardian stands. " +
                "The guardian presents you with a riddle: \"I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What is it?\"\n", "An Echo", "A Whisper", 1, "The guardian frowns and shakes his head. \"That is not the correct answer,\" he says as the clearing begins to close in around you, trapping you forever."));
        questions.add(new Question("The guardian smiles and steps aside, revealing a hidden staircase leading underground. You find yourself in an underground maze. Which path do you take?", "The left path towards the sound of water", "The right path towards the flickering torchlight", 1, "The flickering torchlight leads you to a room filled with traps. As you enter, you trigger a mechanism that seals the exit and the room fills with poisonous gas."));
        questions.add(new Question("You follow the sound of water and find an underground river. The underground river takes you to a grand chamber filled with treasure. " +
                "However, there is a final challenge: a pedestal with two levers, one made of gold and one made of silver. A sign reads: \"Choose wisely to claim your prize.\"\n Which lever do you pull?" , "The gold lever", "The silver lever", 2, "The gold lever triggers a trap, causing the chamber to collapse. You are buried under the rubble along with the treasure. Your adventure ends here."));
    }
}
