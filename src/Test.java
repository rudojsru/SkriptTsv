import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {

    TextWriterReader textWriterReader = new TextWriterReader();

    public static void main(String[] args) {
        TextWriterReader textWriterReader = new TextWriterReader();

        Map map = textWriterReader.readFromTsvMap();
        System.out.println("Please provide your search word");

        Set keys = map.keySet();

        String choise="101010_1.0001.100";
        Color c1 = new Color(255, 100, 100);
        System.out.println(choise);
    }
}
