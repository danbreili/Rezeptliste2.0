import java.io.*;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Main {

    public static void main (String[]args) throws IOException, ParseException {


        String name = "";
        int kalorien = 0;

        Rezeptliste rl = new Rezeptliste();

        JSONObject rezept = new JSONObject();

        rl.rezeptErstellen(name, kalorien, rezept);

        JSONArray rezeptliste = new JSONArray();
        rezeptliste.add(rezept);

        File f = new File("Rezeptliste.json");

        if(f.exists()){
            FileWriter fw = new FileWriter("Rezeptliste.json", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(rezept.toJSONString());
            bw.close();
        }else {
            FileWriter fw = new FileWriter("Rezeptliste.json", true);
            fw.write(rezept.toJSONString());
            fw.close();
        }

        BufferedReader br = null;
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        try{
            String s;
            br = new BufferedReader(new FileReader("Rezeptliste.json"));

            while((s = br.readLine()) != null){
                Object obj;

                try{
                    obj = parser.parse(s);
                    jsonObject = (JSONObject) obj;
                    rezeptliste.add(jsonObject);
                }catch (ParseException e){
                    e.printStackTrace();
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if (br != null) br.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
            int menge = rezeptliste.size()-1;
            System.out.println("Menge der Rezepte in der Rezeptliste: " + menge);
        }
    }

    public static String input (String ausgabe){
        System.out.println(ausgabe);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        try{
            return br2.readLine();
        }catch (Exception e){
            return "";
        }
    }
}
