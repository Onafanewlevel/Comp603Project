
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * The QuestionFileReader class is responsible for reading quiz questions and
 * their corresponding answers, options, and hints from a text file. It allows
 * the game to load questions sequentially and provides methods to access the
 * current question's details.
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
 */
public class QuestionFileReader {

    private BufferedReader buffer; // Buffer to read lines from the file
    private String question, a, b, c, d, hint, answer; // Stores current question details

    /**
     * Constructor that initializes the file reader and buffer to read questions
     * from the specified text file.
     */
    public QuestionFileReader() {
        try {
            FileReader file = new FileReader("src/resources/questions.txt"); // Initialize the FileReader
            buffer = new BufferedReader(file); // Initialize the BufferedReader
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for any IO exceptions
        }
    }

    /**
     * Loads the next question and its details from the file. The details
     * include the question itself, four answer options, the correct answer, and
     * a hint.
     *
     * @return true if a question is successfully loaded, false if the end of
     * the file is reached.
     */
    public boolean loadNextQuestion() {
        try {
            question = buffer.readLine(); // Read the question
            if (question == null) {
                return false; // If end of file, return false
            }
            a = buffer.readLine(); // Read option a
            b = buffer.readLine(); // Read option b
            c = buffer.readLine(); // Read option c
            d = buffer.readLine(); // Read option d
            answer = buffer.readLine(); // Read the correct answer
            hint = buffer.readLine(); // Read the hint
            return true; // Question loaded successfully
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for any IO exceptions
            return false; // Return false if an IO exception occurs
        }
    }

    /**
     * Retrieves the current question's answer options as a HashMap. The keys
     * are 'a', 'b', 'c', and 'd', and the values are the option strings.
     * This method is used when the 50:50 Lifeline is invoked. 
     *
     * @return A HashMap containing the current question's options.
     */
    public HashMap<Character, String> getOptions() {
        HashMap<Character, String> options = new HashMap<>();
        if (a != null) {
            options.put('a', a);
        }
        if (b != null) {
            options.put('b', b);
        }
        if (c != null) {
            options.put('c', c);
        }
        if (d != null) {
            options.put('d', d);
        }
        return options;
    }

    public String getQuestion() {return question;} //Returns question
    public String getA() {return a;}//Returns option a
    public String getB() {return b;}//Returns option b
    public String getC() {return c;}//Return option c 
    public String getD() {return d;}//Returns option d
    public String getAnswer() {return answer;}//Returns answer
    public String getHint() { return hint;}//Returns hint

    /**
     * Resets the buffer to start reading from the beginning of the file again.
     * This method closes the current buffer and reopens it, allowing questions
     * to be reloaded from the start.
     */
    public void resetBuffer() {
        try {
            buffer.close(); // Close the existing buffer
            FileReader file = new FileReader("src/resources/questions.txt"); // Reinitialize the file reader
            buffer = new BufferedReader(file); // Reinitialize the buffer
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for any IO exceptions
        }
    }
}
