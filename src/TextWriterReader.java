
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextWriterReader {
    public static void main(String[] args) {
        TextWriterReader tx = new TextWriterReader();
        List list = tx.readFromTsvList();
    }

    //  The path to failure where the program lies
    public static String trackToFiles() {
        String track = new File(".").getAbsolutePath();

        String[] splitTrack = track.split("");
        track = "";

        for (int i = 0; i < splitTrack.length - 1; i++) {
            track += splitTrack[i];
        }

        // System.out.println(track);
        return track;

    }

    //reads data from a file and creates a map, where the first text element is a key.
    public List readFromTsvList() {

        String track = trackToFiles(); // Stiezka do faila gdzie liezy program
        final String TEXT = track + "cad.tsv";

        BufferedReader br;
        List<String> list = new ArrayList<>();
        //String array;
        String line = null;

        try {
            br = new BufferedReader(new FileReader(TEXT));

            while ((line = br.readLine()) != null) {
                String line2 =line;
                System.out.println(line2+" :  "+regexWithoutLetters(line));
                list.add(line);

            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Not Found  ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private List regexWithoutLetters(String line) {
        String[] a = {};
        List listB = new ArrayList();
        Pattern pattern = Pattern.compile("[0-9oO\\\\\\/.,]");  // убираем все буквы
        Matcher matcher = pattern.matcher(line);
        String s = "";
        while (matcher.find()) {
            s += matcher.group();
        }
        s = s.replaceAll("[oO]", "0");
        s = s.replaceAll("\\\\\\\\", "/");  //  " // "
        s = s.replaceAll("\\\\", "/");   //   "/"
        s = s.replaceAll(",", ".");
        String[] s2=s.split("\\.");
        a = s.split("");
        if (a.length > 1) {
            listB.add(a[0] + a[1]);
            listB.add(a[2] + a[3]);
            listB.add(a[4] + a[5]);
            listB.add(a[6]);
            if (s2.length>1) {
                listB.add(s2[1].replaceAll("0", ""));
                listB.add(s2[2]);
            }

        }
        // System.out.println(listB);
        return listB;
    }
}