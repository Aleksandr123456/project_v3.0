import java.io.*;
import java.util.Scanner;

public class SaverLoader {

    public void save(String score) throws IOException{
        File file = new File("leaderboard.txt");
        PrintWriter pw = new PrintWriter(file);

        pw.write(score);
        pw.close();
    }

    public String load() throws IOException{
        File file = new File("leaderboard.txt");
        Scanner sc = new Scanner(file);
        String score = sc.nextLine();
        sc.close();

        return score;
    }
}
