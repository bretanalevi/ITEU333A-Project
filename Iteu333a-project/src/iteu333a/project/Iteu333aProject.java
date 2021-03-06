package Iteu333a.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Iteu333aProject {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));

        
        int lineCount = 0;
        //reads the file "input.txt"
        PrintWriter writer = new PrintWriter("Test.java", "UTF-8");

        while (sc.hasNext()) 
        {
            String str = sc.nextLine();
            //replaces kung with if
            str = str.replaceAll("kung", "if");
            str = str.replaceAll("labas", "out");
            str = str.replaceAll("iprint", "println");
            
            //Pattern p = Pattern.compile("a*b");
            //Matcher m = p.matcher("aaaaab");
            
            lineCount++;
            
            
              if(Pattern.matches(".^int(.*\\w*.)=(.*\\d*)", "") && str.trim().endsWith(";") )
              {
                  
                  
              }
              /*
              if (str.trim().endsWith(";")||str.trim().endsWith("{")||str.trim().endsWith("}")||str.trim().isEmpty())
                {

                }
              if(str.trim().startsWith("int")&&str.trim().endsWith(";"))
                {

                }
              if(str.trim().startsWith("String")&&str.trim().endsWith(";"))
                {

                }
              */
              
              else
                {
                    System.out.println("Error at line" + " " + lineCount);                   
                }   
                writer.println(str);
                
            
            // string length
            String leng = "(ISukat\\(.*\\);)";
            Pattern length = Pattern.compile(leng);
            Matcher lengthmatch = length.matcher(str);
            if(lengthmatch.find()){
                String keep = lengthmatch.group(0).substring(9);
                System.out.println("embrace = " + keep);
                String lenpat = "([a-z0-9A-Z]*[+][a-z0-9A-Z]*)";
                Pattern solvelen = Pattern.compile(lenpat);
                Matcher solvematch = solvelen.matcher(keep);
                    if(solvematch.find()){
                        String[] holdarr = solvematch.group(0).split("[+]");
                        str = str.replaceAll("MakeSukat\\(.*\\);", "System.out.println(" + holdarr[0] + ".length()+" + holdarr[1] + ".length());");
                    }
            }   

                // Comment 
                String comments = "(////.*)";
            Pattern comment = Pattern.compile(comments);
            Matcher comm = comment.matcher(str);
            continue;
            
            
            
        }
        writer.close();
        List cmdAndArgs = Arrays.asList("cmd", "/c", "run.bat");
        File dir = new File(System.getProperty("user.dir"));

        ProcessBuilder pb = new ProcessBuilder(cmdAndArgs);
        pb.directory(dir);
        Process p = pb.start();
    }
}
