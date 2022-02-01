import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateDetails {
    String fichier;

    public GenerateDetails(String fichier) throws IOException {
        this.fichier = fichier;
        File doc = new File("C:\\Users\\thiba\\IdeaProjects\\MSPR\\src\\main\\resources\\"+this.fichier+".txt");
        Scanner sc = new Scanner(doc);
        sc.useDelimiter(System.getProperty("line.separator"));

        List<String> info = new ArrayList<String>();

        while (sc.hasNext()) {
            info.add(sc.next());
        }
        sc.close();

        String name = info.get(0);
        String surname = info.get(1);
        String ident_card = (surname.charAt(0)+name).toLowerCase();

        String li = "<ul>";
        for (int i = 5; i < info.size() ; i++){
            li = li + "<li>" + info.get(i) + "</li>";
        }
        li = li + "</ul>";

        File doc2 = new File("C:\\Users\\thiba\\IdeaProjects\\MSPR\\src\\main\\resources\\templateDesc.html");
        Scanner sc2 = new Scanner(doc2);
        sc2.useDelimiter(System.getProperty("line.separator"));

        String docHtml = "";

        while (sc2.hasNext()) {
            docHtml = docHtml + sc2.next();
        }
        sc2.close();

        docHtml = docHtml.replace("[[NAME]]",name);
        docHtml = docHtml.replace("[[SURNAME]]",surname);
        docHtml = docHtml.replace("[[IDENT_CARD]]",ident_card+".jpg");
        docHtml = docHtml.replace("[[MATERIAL]]",li);

        File f = new File(ident_card+".html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(docHtml);
        bw.close();
    }
}
