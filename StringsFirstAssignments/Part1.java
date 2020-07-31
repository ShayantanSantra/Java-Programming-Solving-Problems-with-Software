
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna,int startindex,int endindex){
        String result="";
        
        if(startindex==-1)
        {
            return "";
        }
        
        if(endindex==-1)
        {
            return "";
        }
        result=dna.substring(startindex,endindex+3);
        //return result;
        if((endindex-startindex)%3==0)
        {
            return result;
        }
        return "";
        
        
    }
    public void testSimpleGene()
    {
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        int startindex=dna.indexOf("ATG");
        int endindex=dna.indexOf("TAA",startindex+3);
        System.out.println("DNA strand : " +dna);
        String gene = findSimpleGene(dna,startindex,endindex);
        System.out.println("Gene is : " +gene);
        
       /* dna = "ATGAAAAA";
        System.out.println("DNA strand : " +dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " +gene);
        
        dna = "AGAAAAA";
        System.out.println("DNA strand : " +dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " +gene);
        
        dna = "ATGAAAAATAA";
        System.out.println("DNA strand : " +dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " +gene);
        
        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA strand : " +dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " +gene);*/
        
        
    }

}
