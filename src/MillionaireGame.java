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
        
        // Initialize and start the game engine
        GameLogic gameEngine = new GameLogic(player, questions);
        gameEngine.startGame();  // Start the game
        
        scan.close();
    }
}
