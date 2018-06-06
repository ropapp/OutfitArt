package data;

import business.Article;
import business.ArticleList;
import static gui.Home.AL;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class FileManager {

    public FileManager() throws Exception {
        saveList(AL, "list.txt");

        AL = loadList("list.txt");
    }

    public static void saveList(ArticleList list, String file) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(file), true);

        for (int i = 0; list.get(i) != null; i++) {
            String personString = Integer.toString(list.get(i).getType()) + ":" + list.get(i).getColor() + ":" + list.get(i).getOcassion() + ":" + list.get(i).getDescription();
            out.println(personString);
        }
        out.close();
    }

    public static ArticleList loadList(String file) throws IOException, ParseException {
        ArticleList list = new ArticleList();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String buf;
        while ((buf = in.readLine()) != null) {
            String[] artParts = buf.split(":");
            Article art = new Article();
            art.setType(Integer.parseInt(artParts[0]));
            art.setColor(Color.getColor(artParts[1]));
            art.setOcassion(artParts[2]);
            art.setDescription(artParts[2]);
            list.insertAtEnd(art);
        }
        return list;
    }
}
