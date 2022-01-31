import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File doc = new File("C:\\Users\\thiba\\IdeaProjects\\MSPR\\src\\main\\resources\\cberthier.txt");
        Scanner sc = new Scanner(doc);
        sc.useDelimiter(System.getProperty("line.separator"));

        List<String> Info = new ArrayList<String>();

        while (sc.hasNext()) {
            Info.add(sc.next());
        }
        sc.close();

        System.out.println(Info);

        String name = Info.get(0);
        String surname = Info.get(1);
        String ident_card = (surname.charAt(0)+name+".jpg").toLowerCase();

        String li = "<ul>";
        for (int i = 5; i < Info.size() ; i++){
            li = li + "<li>" + Info.get(i) + "</li>";
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

        System.out.println(docHtml);
        System.out.println("\n --------------------------------------------------- \n");

        docHtml = docHtml.replace("[[NAME]]",name);
        docHtml = docHtml.replace("[[SURNAME]]",surname);
        docHtml = docHtml.replace("[[IDENT_CARD]]",ident_card);
        docHtml = docHtml.replace("[[MATERIAL]]",li);

        System.out.println(docHtml);

        File f = new File("index.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(docHtml);
        bw.close();

    }
}