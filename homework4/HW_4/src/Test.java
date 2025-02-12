import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
	
Scanner input=new Scanner(System.in);
int choice;
FileSystem object1=new FileSystem();
Directory currentpath;

try {
	
do {
System.out.println("===== File System Management Menu =====");	
System.out.println("1. Change directory");	
System.out.println("2. List directory contents");	
System.out.println("3. Create file/directory");	
System.out.println("4. Delete file/directory");	
System.out.println("5. Move file/directory");	
System.out.println("6. Search file/directory");	
System.out.println("7. Print directory tree");	
System.out.println("8. Sort contents by date created");	
System.out.println("9. Exit");	
System.out.println("Please select an option:");

do {
choice=input.nextInt();	
if(choice<0 || choice>9) {
System.out.println("Please enter valid number");
choice=input.nextInt();
}	
}while(choice<1 || choice>9);
input.nextLine();	
if(choice==1) {
object1.PrintCurrentPath();
System.out.println("Enter new directory path: ");
String pathname=input.nextLine().trim();
object1.changeDirectory(pathname);
}
	
else if(choice==2) {
	object1.PrintCurrentPathcontent();
}
else if(choice == 3) {
    System.out.print("Current Directory: ");
    object1.PrintCurrentPath();
    System.out.println("Create file or directory (f/d): ");
    String character = input.nextLine().trim();
    if(character.equals("d")) {
        System.out.println("Enter name for new directory: ");
        String name = input.nextLine().trim();
        currentpath = object1.getCurrentpath();
        object1.CreateDirectory(name, currentpath);

    } else if(character.equals("f")) {
        System.out.println("Please enter a name: ");
        String name = input.nextLine().trim();
        currentpath = object1.getCurrentpath();
        object1.CreateFile(name, currentpath);
    } else {
        System.out.println("Invalid input entered");
    }
}

else if(choice==4) {
	System.out.print("Current Directory: ");
    object1.PrintCurrentPath();
    System.out.println("Enter name of file/directory to delete: ");
    String name = input.nextLine().trim();
    currentpath = object1.getCurrentpath();
    object1.DeleteFileDirectory(name,object1.getRoot());

}
else if(choice==5) {
object1.PrintCurrentPath();
System.out.println("enter the name of file/directory to move :  ");
String name=input.nextLine().trim();
System.out.println("Enter new directory path: ");
String pathname=input.nextLine().trim();
object1.MoveDirectories(name,pathname);
}
			
else if(choice==6) {
	
System.out.println("Search querry: ");
String name=input.nextLine().trim();
currentpath = object1.getCurrentpath();
object1.Search(name);
}
		
else if(choice==7) {
System.out.println("Path to currentDirectory from root");
currentpath=object1.getCurrentpath();
object1.PrintTree(currentpath,object1.pathlength);
}
		
else if(choice==8) {
System.out.print("Sorted Content of ");
object1.PrintCurrentPath();
System.out.println("by date created: ");
currentpath = object1.getCurrentpath();
object1.sortcontent(currentpath);
}
		
	
	
	
}while(choice!=9);
		
}catch(Exception e) {	
System.out.println("Exception occured .Invalid input Entered");
	}

}
}
