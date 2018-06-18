import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

public class Rezeptliste {

    String name = "";
    int kalorien = 0;

    public JSONObject rezeptErstellen (String name, int Kalorien, /*ArrayList zutaten,*/ JSONObject rezept) throws IOException {

        JSONObject jobj = new JSONObject();

        jobj.put("name","Apfelkuchen");

        Scanner input = new Scanner (System.in);

        System.out.println("Rezeptname: ");
        name = input.nextLine();

        System.out.println("Kalorien: ");
        kalorien = input.nextInt();

        /*System.out.println("Zutaten: ");
        zutaten.add(input.nextLine());*/


        rezept.put("name",name);
        rezept.put("kalorien",kalorien);

        return rezept;


    }
}