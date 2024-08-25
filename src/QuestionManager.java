/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Onafanewlevel
 */
public class QuestionManager {

    private int qCount = 1;  // To track question numbers
    
    public void showCurrentQuestion(QuestionLoader questions){
        
    }

    public void showNextQuestion(QuestionLoader questions) {
        Utils.pause(2000);
        System.out.println("\n\nQuestion " + qCount + "\n\n");
        Utils.pause(2000);

        if (questions.loadNextQuestion()) {
            System.out.println(questions.getQuestion());
            System.out.println(questions.getA());
            System.out.println(questions.getB());
            System.out.println(questions.getC());
            System.out.println(questions.getD());
            qCount++;  // Increment the question counter
        } else {
            System.out.println("No more questions available.");
        }
    }
}

