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

    public void showNextQuestion(QuestionLoader questions, Lifeline lifeline) {
        Utils.pause(2000);
        int money = PrizeMoney.getPrizeByQuestionNumber(qCount);
        System.out.println("\n\nQuestion " + (qCount) + "\n");
        System.out.print("For $" + money + ": ");
        Utils.pause(2000);
        if (questions.loadNextQuestion()) {
            System.out.println(questions.getQuestion());
            System.out.println(questions.getA());
            System.out.println(questions.getB());
            System.out.println(questions.getC());
            System.out.println(questions.getD());
            if (lifeline.isHasFiftyfity() || lifeline.isHasHint()) {
                System.out.println("\ne) Use Lifeline");
            }
            System.out.println("f) Walk Away!");
            qCount++;  // Increment the question counter
        } else {
            System.out.println("No more questions available.");
        }
    }
    
    public int getQCount(){
        return this.qCount - 2; 
    }
}
