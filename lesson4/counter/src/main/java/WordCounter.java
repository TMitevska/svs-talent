import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;


import org.apache.commons.lang3.*;
public class WordCounter {
    public static void main(String[] argc) {
        Hashtable<String,Integer> table=new Hashtable<String,Integer>();
        try {
            File file = new File(argc[0]);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line=scanner.nextLine().replace(',',' ').replace('.',' ').replace('!',' ').replace('(',' ').replace(')',' ').replace(':',' ');
                line= StringUtils.lowerCase(line);

                String[] words=line.split(" ");

                for(String word:words)
                {
                    if(table.containsKey(word)){table.put(word,table.get(word)+1);}
                    else{table.put(word,1);}
                }


            }


        } catch (IOException e) {
            System.out.println("File " + argc[0] + " can't be open!");
        }
        for(String word:table.keySet())
        {
            System.out.println("Word "+word+" is repeated "+table.get(word).toString()+" times");
        }

    }
}
