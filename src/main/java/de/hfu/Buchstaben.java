package de.hfu;
import java.util.*;
/**
 * Hello world!
 *@author jonas
 *@version 1.0
 */
public class Buchstaben 
{
    public static void main( String[] args )
    {
		Scanner eingabe = new Scanner(System.in);
		String input;
        System.out.print( "Text eingeben: " );
		input = eingabe.nextLine();
		input = input.toUpperCase();
		System.out.println("Großbuchstaben: " + input);
    }
}
