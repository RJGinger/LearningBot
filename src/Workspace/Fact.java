/**
* The Fact class is to store a single a word 
* and some way of describing it
*
* @author  Reese Jones
* @version 1.1
* @since   2015-06-06 
*/
package Workspace;

public class Fact implements Comparable<Fact>
{
	private String Described; // Concept Described
	private String Description;//Describing the concept
	private boolean is_a;//relationship between concept and the description Ex. the sky IS blue
	private boolean has_a;//relationship between concept and the description Ex. the sky HAS birds
	private int Sureness;//An integer value that describes how likely that the description is true

	
	//Constructor
	public Fact(String word,String desc,boolean is, boolean has)
	{
		this.Described = word;
		this.Description = desc;
		this.is_a = is;
		this.has_a = has;
		this.Sureness = 1;
	}
	
	
	/**
	 * The compareTo method Overwrites the previous method that all 
	 * classes already contain.This method takes in another fact and 
	 * compared it to this one.If this fact's sureness is larger then
	 * the code returns -1. If the the other fact's sureness is larger
	 * then the code returns a 1. If neither of these happens, then 
	 * the sureness must be equal and the code returns 0
	 * 
	 * @param AllInfoarg0
	 */
	@Override
	public int compareTo(Fact arg0) {
		if(arg0.getSureness() < this.Sureness)
			return -1;
		
		if(arg0.getSureness() > this.Sureness)
			return 1;
		
		return 0;
	}
	
	public void divideSureness(int sure)
	{this.Sureness /= sure;}
	
	public void addSureness(int sure)
	{this.Sureness += sure;}
	
	public void removeSureness(int sure)
	{this.Sureness -= sure;}
	
	public int getSureness()
	{return this.Sureness;}
	
	public String getDescribed()
	{return Described;}
	public void setDescribed(String word)
	{this.Described = word;}
	
	public String getDescription()
	{return Description;}
	public void setDescription(String desc)
	{this.Described = desc;}
	
	public boolean getis_a()
	{return is_a;}
	public void setis_a(boolean is)
	{this.is_a = is;}
	
	public boolean gethas_a()
	{return has_a;}
	public void sethas_a(boolean has)
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
		return " F|四" + Described + "|四" + Description + 
				"|四" + Sureness + "|四" + is_a + "|四" + has_a;
	}
	
	public String toString()
	{
		return "Described: " + Described +
				"\nDescription: " + Description +
				"\nSureness: " + Sureness +
				"\nIs-A relationship: " + is_a + 
				"\nHas-A relationship: " + has_a +"\n";
	}
}
