
/**
 * Write a description of csv here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*; 
public class csv {
    public void tester()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
       //countryinfo(parser,"Nauru");
        //listExportersTwoProducts(parser,"cotton","flowers");
        //numberOfExporters(parser,"cocoa");
        bigExporters(parser,"$999,999,999,999");
        
    }
    public void countryinfo(CSVParser parser, String country)
    {
        //parser = fr.getCSVParser();
        for(CSVRecord record : parser)
        {
        String export=record.get("Exports");
        String cou=record.get("Country");
        if(export.isEmpty())
        {
            System.out.println("NOT FOUND"); 
           
        }
        else if(cou.contains(country))
        {
             System.out.print(record.get("Country")+": ");
            System.out.print(record.get("Exports")+": ");
            System.out.print(record.get("Value (dollars)"));
        }
    }
        
    }
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
    {
        for(CSVRecord record : parser)
        {
            //String cou=record.get("Country");
            String export=record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }
    public void numberOfExporters(CSVParser parser,String exportitem)
    {
        int count=0;
        for(CSVRecord record : parser)
        {
            
            String export=record.get("Exports");
            if(export.contains(exportitem))
            {
                count=count+1;
               // System.out.println(count);
            }
        }
        System.out.println(count);
        
    }
    public void bigExporters(CSVParser parser,String amount)
    {
        int len=amount.length();
       for(CSVRecord record : parser)
       {
           
           String test=record.get("Value (dollars)");
           int testlen=test.length();
           if(testlen>len)
           {
               System.out.print(record.get("Country")+":");
               System.out.print(record.get("Value (dollars)")+"\n");
            }
           
        }
    }

}
