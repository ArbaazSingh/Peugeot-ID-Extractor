import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
public class accIDextractor {

public static void main(String[] args) {

try {
	File input = new File("C:/Users/asidhu/Desktop/aaaaa.htm");

  Document doc = Jsoup.parse(input, "UTF-8", "http://public.servicebox.peugeot.com/docapv/rechercheIdol.do");
 
  Element D=doc.getElementById("divListDoc");

  Element table = D.select("table").get(0);
  
  Elements rows=table.select("tr");
 for (int i = 1; i < rows.size(); i++) {
	  Element row = rows.get(i);
	  String temp= row.toString().split("callAction")[1];
  System.out.println(temp.substring(2,12).replaceAll("\\s+", ""));
 }
 
}
catch (IOException ex) {
  Logger.getLogger(accIDextractor.class.getName())
        .log(Level.SEVERE, null, ex);
   }
  }
}
