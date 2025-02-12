import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    //to get time from user
    private static Date date;
    private static Date date2;

    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        Scanner scanner = new Scanner(System.in);
        //scanner and network which produced from SocialNetwork class

        int choice;
     /*  
        List<String>list=new ArrayList<String>();
        
        list.add("swimming");
        list.add("tennis");
        list.add("football");
        Person person1=new Person("lionel",34,list);	
        list.clear();
        list.add("football");
        list.add("guitar");
        list.add("books");
        Person person2=new Person("cristiano",38,list);	
        list.clear();
        list.add("watching tv");
        list.add("eating");
        Person person3=new Person("paul",35,list);	
        list.clear();
        list.add("swimming");
        list.add("tennis");
        list.add("football");
        Person person4=new Person("dries",33,list);	
        list.clear();
        list.add("walking");
        list.add("sleeping");
        Person person5=new Person("mauro",30,list);	
        list.clear();
        list.add("basketball");
        Person person6=new Person("sacha",34,list);	
        list.clear();
        list.add("eating");
        list.add("sleeping");
        list.add("football");
        list.add("reading");
        Person person7=new Person("victor",22,list);	
        list.clear();
        network.addPerson(person1.getName(), person1.getAge(), person1.getHobbies());
        network.addPerson(person2.getName(), person2.getAge(), person2.getHobbies());
        network.addPerson(person3.getName(), person3.getAge(), person3.getHobbies());
        network.addPerson(person4.getName(), person4.getAge(), person4.getHobbies());
        network.addPerson(person5.getName(), person5.getAge(), person5.getHobbies());
        network.addPerson(person6.getName(), person6.getAge(), person6.getHobbies());
        network.addPerson(person7.getName(), person7.getAge(), person7.getHobbies());
        network.addFriendship(person1.getName(), person4.getName(), person1.getTimestamp(), person4.getTimestamp());
        network.addFriendship(person1.getName(), person5.getName(), person1.getTimestamp(), person5.getTimestamp());
        network.addFriendship(person2.getName(), person6.getName(), person2.getTimestamp(), person6.getTimestamp());
        network.addFriendship(person2.getName(), person7.getName(), person2.getTimestamp(), person7.getTimestamp());
        network.addFriendship(person2.getName(), person3.getName(), person2.getTimestamp(), person3.getTimestamp());
        network.addFriendship(person3.getName(), person4.getName(), person3.getTimestamp(), person4.getTimestamp());
        network.addFriendship(person3.getName(), person6.getName(), person3.getTimestamp(), person6.getTimestamp());
        network.addFriendship(person4.getName(), person7.getName(), person4.getTimestamp(), person7.getTimestamp());
        network.addFriendship(person5.getName(), person6.getName(), person5.getTimestamp(), person6.getTimestamp());
        
        
        //remaining operations
        network.findShortestPath(person1.getName(), person7.getName(), person1.getTimestamp(), person1.getTimestamp());//lionel-victor path
        network.findShortestPath(person2.getName(), person5.getName(), person2.getTimestamp(), person5.getTimestamp());//cristiano-mauro path
        network.findShortestPath(person5.getName(), person4.getName(), person5.getTimestamp(), person4.getTimestamp());//mauro-dries
        network.removeFriendship(person2.getName(), person6.getName(), person2.getTimestamp(), person6.getTimestamp());//remove friendships between ronaldo and sacha
        network.removeFriendship(person5.getName(), person6.getName(), person5.getTimestamp(), person6.getTimestamp());//remove friendships between mauro and sacha
        network.findShortestPath(person2.getName(), person5.getName(), person2.getTimestamp(), person5.getTimestamp());//cristiano-mauro path without sacha
        network.suggestFriends("lionel", 2, person1.getTimestamp());
        network.suggestFriends("mauro", 2, person1.getTimestamp());
        network.CountClusters();
        */
        
        do {//this is menu which shows some operations and untill user press 8,it will continue
            System.out.println("===== Social Network Analysis Menu =====");  
            System.out.println("1. Add person"); 
            System.out.println("2. Remove person");  
            System.out.println("3. Add friendship");    
            System.out.println("4. Remove friendship"); 
            System.out.println("5. Find shortest path");    
            System.out.println("6. Suggest friends");   
            System.out.println("7. Count clusters");    
            System.out.println("8. Exit\r\n"); 
            System.out.println("Please select an option: "); 
            String name = "", name1 = "";
            int age;
            String hobbyOfPerson;
            List<String> hobbies = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //my variables to take names,age and hobbies
            do {//untill user enter valid number,continue taking number
                choice = scanner.nextInt();   
                if (choice < 1 || choice > 8)
                    System.out.println("Please enter a valid number");
            } while (choice < 1 || choice > 8);  
           
            scanner.nextLine(); // Consume newline
           
            switch (choice) {
                case 1://if user select 1
                    System.out.println("Enter name: ");
                    try {
                        name = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter hobbies (comma-separated): ");
                    hobbyOfPerson = scanner.nextLine().trim();
                    String[] splittedHobbies = hobbyOfPerson.split(",");
                    for (String hobby : splittedHobbies) {
                        hobbies.add(hobby.trim());
                    }
                    network.addPerson(name, age, hobbies);
                    //takes name,age and hobbies
                    hobbies.clear(); // Clear the list for next use
                    break;
                case 2:
                    //to remove person from network
                    System.out.println("Enter name: ");
                    try {
                        name = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                System.out.println("Enter person's timestamp (yyyy-MM-dd HH:mm:ss): ");
                String timeofperson = scanner.nextLine().trim();
                SimpleDateFormat formattype = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				date=formattype.parse(timeofperson);
			} catch (ParseException e) {
				e.printStackTrace();
			}


                    network.removePerson(name,date);
                    break;
                case 3:
                    //to make frinedsiphs
                    System.out.println("Enter first person's name: ");
                    try {
                        name = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter first person's timestamp (yyyy-MM-dd HH:mm:ss): ");
                    String dateInput1 = scanner.nextLine().trim();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					date =formatter.parse(dateInput1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    if (date == null) {
                        System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd HH:mm:ss format.");
                        break;
                    }
                    System.out.println("Enter second person’s name: ");
                    try {
                        name1 = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter second person’s timestamp (yyyy-MM-dd HH:mm:ss): ");
                    String dateInput2 = scanner.nextLine().trim();
                    SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					date2=formatter1.parse(dateInput2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    if (date2 == null) {
                        System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd HH:mm:ss format.");
                        break;
                    }
                    network.addFriendship(name, name1, new java.sql.Date(date.getTime()), new java.sql.Date(date2.getTime()));
                    break;
                case 4:
                    //to remove friendship
                    System.out.println("Enter first person's name: ");
                    try {
                        name = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter second person’s name: ");
                    try {
                        name1 = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
            
                    System.out.println("Enter first person's timestamp (yyyy-MM-dd HH:mm:ss): ");
                    String input1 = scanner.nextLine().trim();
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					date=format1.parse(input1);
				} catch (ParseException e) {
					e.printStackTrace();
				}
                  
		        System.out.println("Enter second person's timestamp (yyyy-MM-dd HH:mm:ss): ");
                String input2 = scanner.nextLine().trim();
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				date2=format2.parse(input2);
			} catch (ParseException e) {
				e.printStackTrace();
			}
             
                    
                    network.removeFriendship(name, name1,date,date2);
                    break;
                case 5:
                    //to  find shortest path
                    System.out.println("Enter first person's name: ");
                    try {
                        name = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter second person's name: ");
                    try {
                        name1 = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                    System.out.println("Enter first person's timestamp (yyyy-MM-dd HH:mm:ss): ");
                    String time1 = scanner.nextLine().trim();
                    SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					date=formatter3.parse(time1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		        System.out.println("Enter second person's timestamp (yyyy-MM-dd HH:mm:ss): ");
                String time2 = scanner.nextLine().trim();
                SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				date2=formatter4.parse(time2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                   
                    network.findShortestPath(name, name1,date,date2);
                    break;
                case 6:
                    //to suggest friends
                    System.out.println("Enter person's name: ");
                    try {
                        name = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter person's timestamp (yyyy-MM-dd HH:mm:ss): ");
                    String dateInput = scanner.nextLine().trim();
                    SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					date=formatter5.parse(dateInput);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 int number;
                    System.out.println("Enter maximum number of friends to suggest: "); //gets max number of friends
                    number = scanner.nextInt();
                    network.suggestFriends(name, number,date);
                    break;
                case 7:
                    //to count clusters
                    network.CountClusters();
                    break;
            }
        } while (choice != 8);
   }

}


