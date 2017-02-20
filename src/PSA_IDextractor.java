import java.io.File;
import java.io.IOException;
import java.util.logging.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
public class PSA_IDextractor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		switch(args[1]){
		case "Parts":parts(args); break; 
		case "Labour_Time":labour(args);;break;
		case "Repair":repair(args);;break;
		case "Special_Tools":special(args);;break;
		case "Accessories":accessories(args);;break;
		}
	
	}


	public static void parts(String[] args) {

	try {
		File input = new File(args[0]);

	  Document doc = Jsoup.parse(input, "UTF-8", "http://public.servicebox.peugeot.com/docapv/rechercheIdol.do");
	 
	  Element D=doc.getElementById("divListDoc");
	  
	  Element table = D.select("table").get(1);
	  
	  Elements rows=table.select("tr");
	 for (int i = 1; i < rows.size(); i++) {
		  Element row = rows.get(i);
	  Elements cols = row.select("td");
	 
	  String idtemp=cols.toString().split("-")[0];
	if(idtemp.length()!=0){
	  String id = idtemp.substring(11,23).replaceAll("\\s+", "");
	  System.out.println(id);
	 }
	 }
	}
	catch (IOException ex) {
	  Logger.getLogger(partsIDextractor.class.getName())
	        .log(Level.SEVERE, null, ex);
	   }
	  }
	
	

public static void labour(String[] args) {

try {
	File input = new File(args[0]);

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
	
public static void repair(String[] args) {

try {
	File input = new File(args[0]);

  Document doc = Jsoup.parse(input, "UTF-8", "http://public.servicebox.peugeot.com/docapv/rechercheIdol.do");
 
  Element D=doc.getElementById("divListDoc");

  Element table = D.select("table").get(0);
  
  Elements rows=table.select("tr");
 for (int i = 1; i < rows.size(); i++) {
	  Element row = rows.get(i);
  Elements cols = row.select("td");
  String idtemp=cols.toString().split("-")[0];
if(idtemp.length()!=0){
  String id = idtemp.substring(11);
  System.out.println(id.replaceAll("\\s+", ""));
 }
 }
}
catch (IOException ex) {
  Logger.getLogger(repairIDextractor.class.getName())
        .log(Level.SEVERE, null, ex);
   }
  }
	

public static void special(String[] args) {

try {
	File input = new File(args[0]);

  Document doc = Jsoup.parse(input, "UTF-8", "http://public.servicebox.peugeot.com/docapv/rechercheIdol.do");
 
  Element D=doc.getElementById("divListDoc");

  Element table = D.select("table").get(0);
  
  Elements rows=table.select("tr");
 for (int i = 1; i < rows.size(); i++) {
	  Element row = rows.get(i);
	  String temp= row.toString().split("callActionRecherche")[1];
  System.out.println(temp.substring(2,12).replaceAll("\\s+", ""));
 }
 
}
catch (IOException ex) {
  Logger.getLogger(specialIDextractor.class.getName())
        .log(Level.SEVERE, null, ex);
   }
  }	



public static void accessories(String[] args) {

try {
	File input = new File(args[0]);

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



