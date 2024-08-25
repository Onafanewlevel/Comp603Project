import java.util.Scanner;

public class MillionaireGame {

    public static void main(String[] args) {
        Messages message = new Messages();
        message.banner();
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name contestant!: ");
        String playerName = scan.nextLine();

        Player player = new Player(playerName);
        QuestionLoader questions = new QuestionLoader();
        Lifeline lifeline = new Lifeline();
        
        // Initialize and start the game engine
        GameLogic game = new GameLogic(player, questions, lifeline);
        game.startGame();  // Start the game
        
        scan.close();
    }
}
