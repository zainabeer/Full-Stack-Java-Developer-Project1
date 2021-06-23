package LockedMe;

import java.util.*;
import java.io.*;

// class for retrieving the file names in an ascending order
public class OrderNames {
	
	public void ascendingOrder () {
		
		
        String dir_path = "C:\\LockedMe" ; // path of LockedMe

        File theDir = new File(dir_path);
        
        File[] fileList = theDir.listFiles(); // create list of files

        Arrays.sort(fileList); // sort the files name in ascending order

        if (fileList.length > 0) { // if LockedMe contain files
        	
        	System.out.println("Number of files: " + fileList.length );
        	System.out.println("Files name in ascending Order:");
        	
        	for(File file:fileList) // go file by file and print the name
            {
                System.out.println(file.getName());
            }
        	
        }
        
        else { // if LockedMe contain no files
        	System.out.println("There are no files");
        }
        
        
	}

}
