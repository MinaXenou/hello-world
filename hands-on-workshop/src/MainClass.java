import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MainClass {

	public static void main(String[] args) throws IOException {
		
		String text; 
		String logFile = args[0];
		BufferedReader reader = new BufferedReader( new InputStreamReader(
                new FileInputStream(logFile), "UTF8"));
		HashMap<String,String> hp = new HashMap<String,String>();
		HashMap<String,String> hpNew = new HashMap<String,String>();
		 while((text = reader.readLine()) != null)
		 {
			 hp.put(text, text);
		 }
		 reader.close();
		 
		 logFile = args[1];
		 reader = new BufferedReader( new InputStreamReader(
	                new FileInputStream(logFile), "UTF8"));
		 while((text = reader.readLine()) != null)
		 {
			 if(hp.containsKey(text))
			 {
				 hpNew.put(text, text);
			 }
		 }
		 File file = new File(args[2]);
		 BufferedWriter output = new BufferedWriter(new FileWriter(file));
		 
         Collection<String> col = hpNew.values();
         
         ArrayList<String> list = new ArrayList<String>(col);
         Collections.sort(list);
         Iterator<String> it = list.iterator();
		 while(it.hasNext())
		 {
			 
			 output.write(it.next());
			 output.newLine();
		 }
		 
		 output.close();
	
		

	}

}
