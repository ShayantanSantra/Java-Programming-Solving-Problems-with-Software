
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class part1 {
   
    public int findStopCodon(String dna, int startindex, String stopCodon){
       int curindex = dna.indexOf(stopCodon,startindex+3);
       while (curindex!=-1){
           int diff = curindex-startindex;
           if(diff%3==0)
           {
               return curindex;
           
           }
           else
           {
               curindex=dna.indexOf(stopCodon,curindex+1);
            }
          // System.out.println("index " + index);
        }
          return dna.length();
        


          /* String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+3);
           System.out.println("index after updating " + index);*/
       }
   

   public String findGene(String dna, int where){
       int startindex=dna.indexOf("atg",where);
       if(startindex==-1)
       {
           return "";
        }
        int taa=findStopCodon(dna,startindex,"taa");
        int tag=findStopCodon(dna,startindex,"tag");
        int tga=findStopCodon(dna,startindex,"tga");
        //int min==Math.min(taa,Math.min(tag,tga));
        int min=0;
        if(taa==-1||(tga!=-1&&tga<taa))
        {
            min=tga;
        }
        else
        {
            min=taa;
        }
        if(min==-1||(tag!=-1&&tag<min))
        {
            min=tag;
        }
        if(min==-1)
        {
            return "";
        }
        return dna.substring(startindex,min+3);
        
       //findAbc("abcd");
       //findAbc("abcabcabcabca");
   }
   public void printAllGene(String dna)
   {
       int count=0;
       int startindex=0;
       while(true)
       {
           
           String currgene=findGene(dna,startindex);
           if(currgene.isEmpty())
           {
               break;
            }
            count++;
            System.out.println(currgene);
            startindex=dna.indexOf(currgene,startindex)+currgene.length();
           
        }
        System.out.println(count);
    }
    public void teston(String dna)
    {
        System.out.println("Testing done on: "+dna);
        printAllGene(dna);
    }
    public void test()
    {
       // teston("atgatctaatttatgctgcaacggtgaaga");
       FileResource fr = new FileResource("brca1line.fa");
       String dna = fr.asString();
       teston(dna);
    }
}

