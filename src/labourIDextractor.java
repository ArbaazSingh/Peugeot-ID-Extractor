import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
public class labourIDextractor {

public static void main(String[] args) {

try {
	File input = new File("C:/Users/asidhu/Desktop/aaaaa.htm");

  Document doc = Jsoup.parse(input, "UTF-8", "http://public.servicebox.peugeot.com/docapv/rechercheIdol.do");
 
  Element D=doc.getElementById("divListDoc");

  Element table = D.select("table").get(0);
  
  Elements rows=table.select("tr");
 for (int i = 1; i < rows.size(); i++) {
	  Element row = rows.get(i);
  Elements cols = row.select("td");
  String idtemp=cols.toString().split("-")[0];
if(idtemp.length()!=0){
  String id = idtemp.substring(11,24).replaceAll("\\s+", "");
  System.out.println(id);
 }
 }
}
catch (IOException ex) {
  Logger.getLogger(labourIDextractor.class.getName())
        .log(Level.SEVERE, null, ex);
   }
  }
}
