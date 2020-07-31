
/**
 * Write a description of weather here.
 * 
 * @Shayantan (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class weather {
    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord smallest=null;
        for(CSVRecord currentrow : parser)
        {
            if(smallest==null)
            {
                smallest=currentrow;
            }
            else
            
            {
                
                double currtemp=Double.parseDouble(currentrow.get("TemperatureF"));
                double lowesttemp=Double.parseDouble(smallest.get("TemperatureF"));
                if(currtemp<lowesttemp && currtemp!=-9999 && lowesttemp!=-9999 )
                {
                    smallest=currentrow;
                }
            }
            
        }return smallest;

     }
    public void testColdestHourInFile(String fname)
   {
    FileResource fr=new FileResource("data/2013/"+fname);
    CSVRecord smallest=coldestHourInFile(fr.getCSVParser());
    System.out.println("lowest temperature was:"+smallest.get("TemperatureF")+" at "+smallest.get("TimeEST"));
   }
   public String fileWithColdestTemperature()
   {
       CSVRecord smallest=null;
      DirectoryResource dr=new DirectoryResource();
      String fname="";
      for(File f : dr.selectedFiles())
      {
          FileResource fr=new FileResource(f);
          CSVRecord current=coldestHourInFile(fr.getCSVParser());
          if(smallest==null)
            {
                smallest=current;
            }
            else
            {
               // if(currtemp!=-9999 && lowesttemp!=-9999){
                double currtemp=Double.parseDouble(current.get("TemperatureF"));
                double lowesttemp=Double.parseDouble(smallest.get("TemperatureF"));
                if(currtemp<lowesttemp && currtemp!=-9999 && lowesttemp!=-9999 )
                {
                    smallest=current;
                    fname=f.getName();
                }//}
            }
          
        }
     return fname;  
    }
    public void testFileWithColdestTemperature()
    {
        String f=fileWithColdestTemperature();
        System.out.println("Coldest day was in file:"+f);
        testColdestHourInFile(f);
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord lowest=null;
        for(CSVRecord currentrow : parser)
        {
            if(lowest==null)
            {
                lowest=currentrow;
            }
            else
            {
                int currhumid=Integer.parseInt(currentrow.get("Humidity"));
                int lowhumid=Integer.parseInt(lowest.get("Humidity"));
                if(currhumid<lowhumid)
                {
                    lowest=currentrow;
                }
                else if(lowhumid==currhumid)
                {
                    currentrow=lowest;
                }
            }
            
            
        }
        
        return lowest;
    }
    public void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("lowest humidity was: "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
   
    }
     public CSVRecord lowestHumidityInManyFiles()
   {
       CSVRecord smallest=null;
      DirectoryResource dr=new DirectoryResource();
      //String fname="";
      for(File f : dr.selectedFiles())
      {
          FileResource fr=new FileResource(f);
          CSVRecord current=lowestHumidityInFile(fr.getCSVParser());
          if(smallest==null)
            {
                smallest=current;
            }
            else if(current.get("Humidity").contains("N/A") || smallest.get("Humidity").contains("N/A"))
            {
            }
            else
            {
                int currhumid=Integer.parseInt(current.get("Humidity"));
                int lowhumid=Integer.parseInt(smallest.get("Humidity"));
                if(currhumid<lowhumid)
                {
                    smallest=current;
                   // fname=f.getName();
                }
                else if(lowhumid==currhumid)
                {
                    current=smallest;
                }
            }
          
        }
     return smallest;  
    }
    public void testLowestHumidityInManyFiles()
    {
        CSVRecord csv=lowestHumidityInManyFiles();
        System.out.println("lowest humidity was: "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
   
        
    }
    public double averageTemperatureInFile(CSVParser parser)
    {
        int count=0;
        double sum=0.0;
        for(CSVRecord currentrow : parser)
        {
            double temp=Double.parseDouble(currentrow.get("TemperatureF"));
            sum=sum+temp;
            count=count+1;
            
        }
        double avg = (double)sum/count;
        return avg;
        
    }
    public void testAverageTemperatureInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average=averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is "+average);
        
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value)
    {
        int count=0;
        double sum=0.0;
       for(CSVRecord currentrow : parser)
       {
          int humid=Integer.parseInt(currentrow.get("Humidity"));
          System.out.println(humid);
          if(humid>=value)
          {
             double temp=Double.parseDouble(currentrow.get("TemperatureF"));
             sum=sum+temp;
             count=count+1;
           }
           
       }
       double avg = (double)sum/count;
       return avg;
    }
    public void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average=averageTemperatureWithHighHumidityInFile(parser,80);
        System.out.println("Average temperature in file is "+average);
        
    }
}
