import java.io.*;

public class SaverLoader {

    public void save(String name, int score) throws IOException{
        BufferedWriter tekstVälja = new BufferedWriter
                (new OutputStreamWriter(new FileOutputStream("leaderboard.dat"), "UTF-8"));

        tekstVälja.write(name + " " + score);
    }

    public String[] load() throws IOException{
        String[] values = new String[2];
        DataInputStream dis = new DataInputStream(new FileInputStream("leaderboard.dat"));
        values[0] = dis.readUTF();
        values[1] = String.valueOf(dis.readInt());
        dis.close();
        return values;
    }
}
