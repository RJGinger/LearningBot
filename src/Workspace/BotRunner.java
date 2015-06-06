/**
* The BotRunner class is the class with the main
* method, so this controls the whole ChatBot
*
* @author  Reese Jones
* @version 1.1
* @since   2015-06-06 
*/
package Workspace;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BotRunner 
{
	/**
	 * This ArrayList holds the list of concepts 
	 * that the computer is currently using
	 * (The words that were last inputed)
	 */
	public static ArrayList<Concept> Knowledge = new ArrayList<Concept>();
	
	/**
	 * The main method
	 */
	public static void main(String[] args)
	{
		Concept Test = new Concept("Blah");
		Fact TestFact1 = new Fact("Blah","stupid",true,false);
		Test.addFact(TestFact1);
		
		Fact TestFact2 = new Fact("Blah","smart",true,false);
		TestFact2.addSureness(4);
		Test.addFact(TestFact2);
		
		Fact TestFact3 = new Fact("Blah","crazy",true,false);
		TestFact3.addSureness(2);
		Test.addFact(TestFact3);
		
		System.out.println(Test.toString());
		System.out.println(Test.quickToString());
	}

	/**
	 *The addInformation method takes in a string variable which would be the
	 * .toString() output of a concept and adds it to the end of the current Data file
	 * @param AllInfo
	 * @throws IOException
	 */
	public static void addInformation(String AllInfo) throws IOException
	{
		FileWriter Writer = new FileWriter(System.getProperty("user.dir")
				+ "/KnowledgeDataBase.txt",true);
		Writer.write(AllInfo);
		Writer.close();
	}
	
	/**	INCOMPLETE
	 * The findData method is supposed to take in the word of an concept 
	 * find the concept in the datapool and then create a concept out of the info
	 * @param word
	 * @throws IOException
	 */
	public static Concept findData(String word) throws IOException
	{
		File file = new File("KnowledgeDataBase.txt");
		String path = file.getAbsolutePath();
		
		
        // The name of the file to open.
        String fileName = path;

        // This will reference one line at a time
        String line = null;

       
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            
            while((line = bufferedReader.readLine()) != null) 
            {
                System.out.println(line);
            }    

            bufferedReader.close();
            
            return null;
	}
}
