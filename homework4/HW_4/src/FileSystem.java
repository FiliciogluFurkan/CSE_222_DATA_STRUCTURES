import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;


public class FileSystem {

private Directory root;
private Directory currentDirectory;
public int pathlength=1;


public FileSystem() {
	this.root=new Directory("home",null);
	 this.currentDirectory = root;
}
public void CreateDirectory(String name,Directory parent) {//parent is the currentDirectory which is sended from main
	for(FileSystemElement element:parent.children) {
		if(element.getname().equals(name)) {
			System.out.println("This directory have already added!");
			return;
		}
	}
	Directory newDirectory = new Directory(name, currentDirectory);
    currentDirectory.addElement(newDirectory);
    System.out.println("Directory Created:"+name+"/");
}

public void CreateFile(String name,Directory parent) {//parent is the currentDirectory which is sended from main
	for(FileSystemElement element:parent.children) {
		if(element.getname().equals(name)) {
			System.out.println("This file have already added!");
			return;
		}
	}
       File newFile = new File(name, parent);//if not works,change this one with the currentDirectory
       currentDirectory.addElement(newFile);//it adds to currentDirectory's children 
       System.out.println("File Created: "+name);
	   
}

 public void changeDirectory(String path) {
	
    String[] directories = path.split("/");
    int number=directories.length-1;
        boolean found = false;
        
        if(!directories[1].equals("home")) {
        	System.out.println("Invalid path entered!!!!");
        	return;
        }
        
        for (FileSystemElement element : currentDirectory.children) {
        	if(element instanceof Directory && directories[number].equals(element.getname())) {
        	System.out.println("Directory changed to "+path);
        	found=true;
        	currentDirectory=(Directory)element;
        	pathlength++;//to keep path length.Because ı am sending this while printing tree as counter
            return;
        	}
               	
        }
        //if user does not want to change its directory from current directory,For example it wants to go home or 
        // /home/user/projects/homeworks is the current path.If user go to want /home/user it should allow,if user want to go /home/projects,
        // it should not allow
        Directory temp=root;
        int counter=1;
        if(directories[number].equals("home")) {
        	System.out.println("Directory changed to /home");
        	currentDirectory=temp;
        	return;
        }
         for(String directoryname:directories) {
        	 
        	 for(FileSystemElement element:temp.children) {
        	   if(element instanceof Directory && directoryname.equals(element.getname())) {
        		   counter++;
        		   temp=(Directory)element;
        	   } 
        	   if(directoryname.equals(directories[number]) && counter==directories.length-1) {
        		   System.out.println("Directory changed to "+path);
        		   currentDirectory=(Directory)element;
        		   return;
        	   }
        	 }
        	  
         }
        System.out.println("Directory not found");

}  
 
 public void DeleteFileDirectory(String name, Directory parent) {//this gets root of system from main and calls itself as recursive
	    if (parent == null) {
	        return;
	    }

	    for (FileSystemElement element : parent.children) {
	        if (element.getname().equals(name) && parent.equals(currentDirectory)) {//if current directory's children has element with the name of name which user entered,
	            if (element instanceof Directory) { // if it is Directory
	                System.out.println("Directory deleted: " + name + "/");
	                parent.removeElement(element); //removes from children
	                element.parent=null;
	            } else if (element instanceof File) { //if it is file
	                System.out.println("File deleted: " + name);
	                parent.removeElement(element); //removes from children and 
	                element.parent=null;  //assign this element's parent as null
	            }
	            return; 
	        }
	    }

	    for (FileSystemElement element : parent.children) { //if this children is not taht directory
	        if (element instanceof Directory) { //go to other directory and controll
	            DeleteFileDirectory(name, (Directory) element);  //sends the directory element as parameter and recursive calling
	        }
	    }
	}

public void PrintCurrentPath() {
    PrintPathRecursive(currentDirectory); //sends the currentdirectory as parameter
    System.out.println(); 
}

private void PrintPathRecursive(Directory directory) {
    if (directory == null) { //if directory is null,returns nothing
        return;
    }
    PrintPathRecursive((Directory) directory.getparent());//if not,it sends its parent as parameter and 
    System.out.print("/"+directory.getname()); //every step has this print line
    
}

public void PrintCurrentPathcontent() { //it prints the pathcontent of current directory.Recursive is unmeaningfull but it can be.
	
     System.out.print("Listing content of ");
   PrintCurrentPath(); //first,prints currentpath
    for (FileSystemElement elem : currentDirectory.children) { 
        if(elem instanceof Directory)
        	System.out.println("* " + elem.getname()+"/"); //if elem is the type of Directory,prints like this
        else
        	System.out.println("" + elem.getname()); //else,prints like that
    }
}
public void PrintTree(Directory directory,int counter) {
	 if (directory == null) {
	        return;
	    }
	  PrintTree((Directory)directory.getparent(),counter-1); //recursive calling.Also counter is used to give enough space.Counter represents 
	  //current path's length.for example, home/user/projects/homeworks; this is 4  
	  if(directory.equals(currentDirectory))
	  System.out.println("*"+directory.getname()+"/"+ "(Current Directory)");  
	  else
		  System.out.println("*"+directory.getname()+"/");    
		  
	  if(directory.equals(currentDirectory)) {//if directory equals current Directory,it prints its childer.if not,just prints Directory names until reaching root
		  for(FileSystemElement elem:currentDirectory.children) {
			  for(int i=0;i<counter;i++) {
				  System.out.print(" ");//it gives spaces as counter.Counter decreases while going to root
			  }
			  if(elem instanceof Directory)
		        	System.out.println("* " + elem.getname()+"/");
		        else
		        	System.out.println(elem.getname());
		  }
	  }
	 
	  for(int i=0;i<counter;i++) {
		  System.out.print(" ");
	  }//also give space 
	    
}
public Directory getCurrentpath() {  //returns the current path
	  return currentDirectory;
}

public void Search(String name) {  //recursively,it searchs files or directorys
    System.out.println("Searching from root...");

    SearchRecursive(root, name, new LinkedList<>());//ı am sending LinkedList to keep whole path.
}
private void SearchRecursive(Directory directory, String name, LinkedList<String> path) {
    if (directory == null) {
        return; //if directory is null,returns nothing
    }
    
    path.add(directory.getname()); //adds to linked list first path
    for (FileSystemElement elem : directory.children) {  //it looks currentdirectory's children
        if (elem.getname().equals(name)) {  //if finds in this directory
 
            for (String dir : path) {
                System.out.print("/" + dir); //prints whole path
            }
            if(elem instanceof Directory)
            System.out.println("/" + name+"/"); //then prints directory name
            else
            	 System.out.println("/" + name);
            
        } else if (elem instanceof Directory) {
            SearchRecursive((Directory) elem, name, new LinkedList<>(path)); //itsend the new path 
        }
    }
   
}

public void MoveDirectories(String name, String pathname) {
    String directories[] = pathname.split("/");
    int number = directories.length - 1;//it is the index of last path which user's entered
    Directory temp = root;

    boolean found = false;
    for (FileSystemElement element : currentDirectory.children) {
        if (element.getname().equals(name)) {
            found = true;
            break;
        }
    }//controls there is file or directory to copy
    if (!found) {
        System.out.println("No file or directory could be found in this directory");
        return;
    }//if not,returns

    if(directories[number].equals("home")) {
    	 temp=root;//temp becomes root
    }//if user enter home as directory
    else { //if it is not write home,
    	boolean found2=false;
    	//Also user enter valid path
    	for(String directoryname:directories) {
         int counter=1; 	 
          	 for(FileSystemElement element:temp.children) {
          	   if(element instanceof Directory && directoryname.equals(element.getname())) {
          		   counter++;
          		   temp=(Directory)element;
          	   } //it means,we are in the same path which user choice
          	   if(directoryname.equals(directories[number]) && counter==directories.length-1) {
          		   found2=true;
          	   }
          	 }
          	  
           }//controls the path is valid or not
    	if(!found2) {
    		System.out.println("No Valid Path Entered"); //if not,warns the user
    	}
    }
    
    for(FileSystemElement element:temp.children) {
		if(element.getname().equals(name)) {
			System.out.println("This file have already been added.You cannot move!");
			return;
		}
	}
    
    FileSystemElement toCopy = null;//create new object to copy 
    for (FileSystemElement element : currentDirectory.children) {
        if (element.getname().equals(name)) {
            toCopy = element; //copies the element which is in currentDirectory
            break;
        }
    }//after copying
    if (toCopy != null) {//if not null
    	temp.addElement(toCopy);//it adds to its children
        toCopy.parent = temp;//it sets to under parent
       
    }
for(FileSystemElement element:currentDirectory.children) {
	if(element.getname().equals(name)) {
		 element.parent=null;
         currentDirectory.removeElement(element);
	}
}

}

public void sortcontent(Directory directory) { //it sorts the file elements also shows the created times
    Collections.sort(directory.children, new Comparator<FileSystemElement>() { //it compares the current directory childrens
        @Override
        public int compare(FileSystemElement o1, FileSystemElement o2) {
            return o1.gettime().compareTo(o2.gettime());
        }
    });

    for (FileSystemElement element : directory.children) {
        System.out.println("* " + element.getname() + " (" + element.gettime() + ")"); //also prints whole elements
    }
}
public Directory getRoot() { //return current root
	return root;
}
}