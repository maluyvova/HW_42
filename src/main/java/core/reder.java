package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class reder {


public static void read() {
	String csvFile = "/users/maluy/Desktop/file.txt";

	BufferedReader br = null;
	 String line = null;
	try {
		br = new BufferedReader (new FileReader (csvFile));}
	catch ( FileNotFoundException fnfex) {
		System.out.println("file not found");
	}
	try {
		while ((line=br.readLine())  !=null) {
			System.out.println(line);
		}	}
		catch (IOException ioex) {
			System.out.println(ioex.getMessage());
		}
	finally {System.exit(0);}
	ArrayList<String> al = new ArrayList<String>();	
		al.add(line);
		System.out.println(al);
	}


}


	
	//return al.iterator();}}
