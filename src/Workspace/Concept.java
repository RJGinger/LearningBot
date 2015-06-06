/**
* The Concept class is a collection of facts that all
* describe the same thing.
*
* @author  Reese Jones
* @version 1.1
* @since   2015-06-06 
*/
package Workspace;

import java.util.TreeSet;

public class Concept 
{
	private String Word;//The thing described
	private TreeSet<Fact> is_a = new TreeSet<Fact>();//An ordered set of facts that have the is_a boolean true and is ordered by sureness
	private TreeSet<Fact> has_a = new TreeSet<Fact>();//An ordered set of facts that have the has_a boolean true and is ordered by sureness
	private String Type;//This String describes what type of thing the word described is. Ex. noun,verb,determiner,adverb etc.
	
	//constructor
	public Concept(String word)
	{
		this.Word = word;
	}
	
	//constructor
	public Concept(String word, String type)
	{
		this.Word = word;
		this.Type = type;
	}
	
	/**
	 * The addFact method takes in a fact and adds it to is_a and has_a
	 * Treesets if the is_a and has_a booleans are true. The code outputs 
	 * a boolean with the successes of addinj the elements. If the element 
	 * was already in the set then it returns a false otherwise it returns true.
	 * 
	 * @param info
	 * @return Output
	 */
	public boolean[] addFact(Fact info)
	{
		boolean[] Output = new boolean[2];
		
		if(info.getis_a() && is_a.add(info))
			Output[0] = true;
		else
			Output[0] = false;
		
		if(info.gethas_a() && has_a.add(info))
			Output[1] = true;
		else
			Output[1] = false;
		
		return Output;
	}
	
	/**
	 * the getFat method takes in the desc String and 
	 * returns the fact that matches the description
	 * 
	 * @param desc
	 * @return
	 */
	public Fact getFact(String desc)
	{
		for(Fact x: is_a)
			if(x.getDescription().equals(desc))
				return x;
		
		for(Fact x: has_a)
			if(x.getDescription().equals(desc))
				return x;
		
		return null;
	}
	
	/**
	 * The checkSureness method checks the integer value of all 
	 * of the facts in the concept.It checks at the end of each
	 * array, until it reaches a fact with 1 or greater sureness
	 * If the sureness is  less than or equal to 0 then the code 
	 * removes the fact.
	 */
	public void checkSureness()
	{
		
		while(is_a.last().getSureness() <= 0)
			is_a.remove(is_a.last());
		
		while(has_a.last().getSureness() <= 0)
			has_a.remove(has_a.last());
	}
	
	public String getWord()
	{return Word;}
	public void setWord(String word)
	{this.Word = word;}
	
	public String getType()
	{return Type;}
	public void setType(String type)
	{this.Type = type;}
	
	public TreeSet<Fact> getis_a()
	{return is_a;}
	public void setis_a(TreeSet<Fact> is)
	{this.is_a = is;}
	
	public TreeSet<Fact> gethas_a()
	{return has_a;}
	public void sethas_a(TreeSet<Fact> has)
	{this.has_a = has;}
	
	/**
	 * The quickToString is the method used to store 
	 * the data in the datapool. It's more condensed 
	 * than the information in the toString method.
	 * 
	 * @return
	 */
	public String quickToString()
	{
		String is_aString = "";
		String has_aString = "";
		
		for(Fact x: is_a)
			is_aString += x.quickToString() + "\n";
		
		for(Fact x: has_a)
			has_aString += x.quickToString() + "\n";
		
		return "C|¥|" + Word + "|¥|" + Type + "\n" +
				 is_aString + has_aString;
	}
	
	public String toString()
	{
		String is_aString = "";
		String has_aString = "";
		
		for(Fact x: is_a)
			is_aString += "-is-a Relationships-\n	" + x.toString() + "\n";
		
		for(Fact x: has_a)
			has_aString += "-has-a Relationships-\n	" + x.toString() + "\n";
		
		return "Word: " + Word +
				"\nType: " + Type +
				"\n" + is_aString + has_aString;
	}
}
