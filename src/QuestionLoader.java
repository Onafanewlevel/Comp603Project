import java.io.*;
import java.util.HashMap;

public class QuestionLoader {
    private BufferedReader buffer;
    private String question, a, b, c, d, hint, answer;

    public QuestionLoader() {
        try {
            FileReader file = new FileReader("src/resources/questions.txt"); // Initializes  the FileReader
            buffer = new BufferedReader(file); // Initializes the BufferedReader
        } catch (IOException e) {}
    }

    public boolean loadNextQuestion() {
        try {
            question = buffer.readLine(); // Read the question
            if (question == null) return false; // If end of file, return false
            a = buffer.readLine(); // Read option a
            b = buffer.readLine(); // Read option b
            c = buffer.readLine(); // Read option c
            d = buffer.readLine(); // Read option d
            answer = buffer.readLine(); // Read the correct answer
            hint = buffer.readLine(); // Read the hint
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String getQuestion() { return question; }
    public String getA() { return a; }
    public String getB() { return b; }
    public String getC() { return c; }
    public String getD() { return d; }
    public String getAnswer() { return answer; }
    public String getHint() { return hint; }
    
    public HashMap<Character, String> getOptions() {
        HashMap<Character, String> options = new HashMap<>();
        if (a != null) options.put('a', a);
        if (b != null) options.put('b', b);
        if (c != null) options.put('c', c);
        if (d != null) options.put('d', d);
        return options;
    }

    public void resetBuffer() {
        try {
            buffer.close(); // Closes the buffer
            FileReader file = new FileReader("/src/resources/questions.txt"); // Reinitializes the file
            buffer = new BufferedReader(file); // Reinitializes the buffer
        } catch (IOException e) {}
    }
}
