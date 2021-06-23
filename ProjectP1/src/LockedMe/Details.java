package LockedMe;

import java.util.*;
import java.io.*;

//class for Business-level operations: add, delete, search 
public class Details { 
	
	String dir_path = "C:\\LockedMe" ; // path of LockedMe
	File theDir = new File(dir_path);
	
	
	public void opreationdel() { // method to do more options
		
		System.out.println("Here you can add/delete/search for files");
		System.out.println("Some Notes:");
		System.out.println("In add file please write the extension of the file after the name");
		System.out.println("otherwise folder will be created");
		System.out.println("In delete/search file please write the name of the file with extension");
		
		System.out.println("");
		
		while(true) {
			
			String fname = "" ; // for file name
			String path = "" ; // for the path of the file
			boolean finds = false ; // result of searching
			
			System.out.println("Please choose what you want to do:");
			System.out.println("1- Add File");
			System.out.println("2- Delete File");
			System.out.println("3- Search for File");
			System.out.println("4- Go Back  To Home");
			System.out.print("Enter your choice: ");
			
			Scanner input = new Scanner(System.in);
			
            try {
            	
            	int ch = input.nextInt(); // user choice // catch InputMismatchException
                System.out.println("");
                
    			switch (ch) {
    			
    			case 1 : // Add
    				
    				System.out.print("Enter file name/extension to be Added: ");
    				fname = input.next(); 
    				
    				path = dir_path + "\\" + fname ;
    				File add_file = new File(path);

					// if folder does not exists and have no extension // create new folder
    				if ((!add_file.exists()) && (!fname.contains("."))){ 
						add_file.mkdirs();
					    System.out.println("The folder added");
					}
    				// if file does not exists // create new file
					else if (add_file.createNewFile()) { // catch IOException
						System.out.println("The file added");
					}
					else {
						System.out.println("The file exists");
					}
    				
    				System.out.println("");
    				break;
    				
    			case 2 : // Delete
    				
    				System.out.print("Enter file name/extension to be Deleted: ");
    				fname = input.next(); 
    				
    				path = dir_path + "\\" + fname ;
    				
    				finds = this.toFind(fname);
    				
    				if (finds) 
    					this.fileDelete(path) ;
    				
    				else 
    					System.out.println("File not found");
    				
    				
    				System.out.println("");
    				break;
    				
    			case 3 : //Search
    				
    				System.out.print("Enter file name/extension to Search: ");
    				fname = input.next(); 
    				
    				finds = this.toFind(fname);
    				
    				if (finds) 
    					System.out.println("The file found");
    				
    				else 
    					System.out.println("File not found");
    				
  
    				System.out.println("");
    				break ;
    				
    			case 4 :
    				ch = 4 ;
    				break ;
    				
    			default :
    				System.out.println("Please enter number from the options");
    				System.out.println("");
    				break ;
    			
    			}
    			
    			if (ch == 4) {
    				System.out.println("You returned to home");
    				break ;
    			}
    			
            	
            }
            
            catch (InputMismatchException e) { // catch if user enter String instead of integer
				String bad_input = input.nextLine(); // to handle the wrong input and continue the loop
                System.out.println("\nError! Please Enter a Number");
                System.out.println("");
                continue;
            } 
            
            catch (IOException e) { // for using createNewFile
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	public boolean toFind (String s) { // method to search for files
		
		File[] fileList = theDir.listFiles();
		
        if(fileList != null) 
        {
        	for (File file : fileList) 
        		if (s.equals(file.getName())) 
                    return true ;
        }
		
		return false ;
		
	}
	
	
	public void fileDelete (String p) { // method to delete file
		
		String fpath = p ;
		File delete_file = new File(fpath);
		
		if(delete_file.delete()) 
			System.out.println("The file deleted");
		
		else
			System.out.println("File found but not deleted");
		
	}
	

}
