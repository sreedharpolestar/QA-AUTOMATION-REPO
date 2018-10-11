package com.ps.maven.screen;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.ps.maven.utils.BrowserTypes;


 
public class Practice extends BrowserTypes {
	static String imo;
 
	 public static void main(String[] args) throws Exception {
		 // This will load csv file 
		 CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\FileUploadData\\test_IMO.csv"));
		 
		 // this will load content into list
		  List<String[]> li=reader.readAll();
		  System.out.println("Total rows which we have is "+li.size());
		            
		 // create Iterator reference
		  Iterator<String[]>i1= li.iterator();
		    
		 // Iterate all values 
		 while(i1.hasNext()){
		     
		 String[] str=i1.next();
		   
		// System.out.print(" Values are ");
		 
		 for(int i=0;i<str.length;i++)
		{
		 
		   System.out.print(" IMO "+str[i]);
		 
		}
		 System.out.println("   ");
		 imo =  str[0];   
		 System.out.println("IMO" + imo);
		    
		}
		 
		
	 }
    
 }
		
		
		
		
		
		
		
		
	/*}
	
		sortRecordStatus();
	}

	private static void sortRecordStatus() {
		List<String> records = new ArrayList<String>();
		records.add("BAD");
		records.add("OK");
		records.add("WORST");
		records.add("OK");
		records.add("BAD");
		records.add("OK");
		records.add("WORST");

		System.out.println("Unsorted list:-"+records);

		records.sort(new Comparator<String>() {
			public int compare(String s1, String s2) {
				int statusValueS1 = RecordStatus.valueOf(s1).getStatus();
				int statusValueS2 = RecordStatus.valueOf(s2).getStatus();
				if (statusValueS1 == statusValueS2) {
					return 0;
				} else if (statusValueS1 > statusValueS2) {
					return 1;
				} else {
					return -1;
				}
			}
	

		System.out.println("Sorted list:-"+records);


	
}


public enum RecordStatus {
    OK(0),
    BAD(1),
    WORST(2);

    private final int status;

    RecordStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return  status;
    }

}*/