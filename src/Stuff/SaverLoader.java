package Stuff;

import java.io.*;
import java.util.Scanner;

public class SaverLoader {

    public void save(String score) throws IOException{ // salvestab tulemus faili
        File file = new File("leaderboard.txt");
        PrintWriter pw = new PrintWriter(file);

        pw.write(score);
        pw.close();
    }

    public String load() throws IOException{ // saame tulemust failist
        File file = new File("leaderboard.txt");
        Scanner sc = new Scanner(file);
        String score = sc.nextLine();
        sc.close();

        return score;
    }
}
