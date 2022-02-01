import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateIndex {
    public GenerateIndex() throws IOException {
        File doc = new File("C:\\Users\\thiba\\IdeaProjects\\MSPR\\src\\main\\resources\\staff.txt");
        Scanner sc = new Scanner(doc);
        sc.useDelimiter(System.getProperty("line.separator"));

        List<String> info = new ArrayList<String>();

        while (sc.hasNext()) {
            info.add(sc.next());
        }
        sc.close();

        List<String> listeNom = new ArrayList<>();
        for (String nom : info) {
            listeNom.add(nom.substring(1, 2).toUpperCase() + nom.substring(2));
        }
        java.util.Collections.sort(listeNom);

        List<String> listeUrl = new ArrayList<>();
        for (String nom : listeNom) {
            for (String url : info) {
                if (nom.equals(url.substring(1, 2).toUpperCase() + url.substring(2))) {
                    listeUrl.add(url);
                }
            }
        }

        String li = "<ul>";
        int index = 0;
        for (String nom : listeNom) {
            li = li + "<li><a href=\"" + listeUrl.get(index) + ".html\">" + nom + "</a></li>";
            index++;
        }
        li = li + "</ul>";

        File doc2 = new File("C:\\Users\\thiba\\IdeaProjects\\MSPR\\src\\main\\resources\\templateIndex.html");
        Scanner sc2 = new Scanner(doc2);
        sc2.useDelimiter(System.getProperty("line.separator"));

        String docHtml = "";

        while (sc2.hasNext()) {
            docHtml = docHtml + sc2.next();
        }
        sc2.close();

        docHtml = docHtml.replace("[[liste]]", li);

        File f = new File("index.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(docHtml);
        bw.close();
    }
}
