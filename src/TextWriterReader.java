import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TextWriterReader {
    public static void main(String[] args) {
        TextWriterReader textWriterReader = new TextWriterReader();
        Map map = textWriterReader.readFromTsvMap();
        //System.out.println(map.get("101O10-1.0001.100"));

    }

    public Map readFromTsvMap() {

        String track = trackToFiles(); // Stiezka do faila gdzie liezy program
        final String TEXT = track + "cadastral_parcels.tsv";

        BufferedReader br;
        Map<String, String> map = new HashMap();
        String[] array = {};
        String line = null;

        try {
            br = new BufferedReader(new FileReader(TEXT));

            while ((line = br.readLine()) != null) {
                array = line.split("\t");
                map.put(array[0], line);

            }
            System.out.println("---------------");
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File Not Found  ");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return map;
    }



    public static String trackToFiles() {
        String track = new File(".").getAbsolutePath();

        String[] splitTrack = track.split("");
        track = "";

        for (int i = 0; i < splitTrack.length - 1; i++) {
            track += splitTrack[i];
        }

        System.out.println(track);
        return track;

    }
}
//Iloveyou