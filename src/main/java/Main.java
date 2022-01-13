import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("resources/cberthier.csv"));
        sc.useDelimiter(";");
        List<String> tabStr = new ArrayList<String>();
        while (sc.hasNext()) {
            tabStr.add(sc.next());
        }
        sc.close();
        System.out.println(tabStr);
    }
}
