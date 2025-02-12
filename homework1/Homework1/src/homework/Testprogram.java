package homework;
import java.io.File;
import java.util.Scanner;
//necessary imports 
public class Testprogram {
    public static void main(String[] args) {
        int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0;
        Retail_customer[] customer1 = new Retail_customer[100];
        for (int i = 0; i < 100; i++) {
            customer1[i] = new Retail_customer();
        }
        Corporate_customer[] customer2 = new Corporate_customer[100];
        for (int i = 0; i < 100; i++) {
            customer2[i] = new Corporate_customer();
        }
        Order[] orderer = new Order[100];
        for (int i = 0; i < 100; i++) {
            orderer[i] = new Order();
        }
        Operator[] operator1 = new Operator[100];
        for (int i = 0; i < 100; i++) {
            operator1[i] = new Operator();
        }
        //until here i created new array and assigned the initial value with empty constructors 
        File file = new File("content.txt");
        String[] stringarray;
//i created new file to read the text
        if (file.exists() && file.isFile()) { //controls file is valid and exists
        	try {
        	    Scanner scanner = new Scanner(file);
        	    while (scanner.hasNextLine()) {
        	        String line = scanner.nextLine();
        	        stringarray = line.split(";");//it reads the file line by line and splits the words
        	        if (stringarray[0].equals("order")) {//if  first word is order
        	        	 try {
        	                    if (stringarray.length == 6 && stringarray[1].length() > 0 && Integer.parseInt(stringarray[2]) > 0 && Integer.parseInt(stringarray[2])<100000 && Integer.parseInt(stringarray[3]) > 0 && Integer.parseInt(stringarray[3])<100000 && Integer.parseInt(stringarray[4]) >= 0 && Integer.parseInt(stringarray[4]) < 4 && Integer.parseInt(stringarray[5]) > 0 && Integer.parseInt(stringarray[5])<100000) {
        	                    	orderer[counter1++] = new Order(stringarray[1], Integer.parseInt(stringarray[2]), Integer.parseInt(stringarray[3]), Integer.parseInt(stringarray[4]), Integer.parseInt(stringarray[5]));
        	                    }
        	                } catch (NumberFormatException e) {
        	                    // Eğer bir hata oluşursa, ilgili satırın işlenmesini geçersiz kıl
        	                    continue; // Bir sonraki satıra geç
        	                } 
        	        } else if (stringarray[0].equals("retail_customer")) {//if second word this
        	            try {
        	            	if (stringarray.length==7 && stringarray[1].length() > 0 && stringarray[2].length() > 0 && stringarray[3].length() > 0 && stringarray[4].length() > 0  && Integer.parseInt(stringarray[5]) > 0 && Integer.parseInt(stringarray[5])<100000 && Integer.parseInt(stringarray[6]) > 0 && Integer.parseInt(stringarray[6])<100000) {
        	            		  int flag=0;
          	                    for(int k=0;k<customer1.length;k++) {
          	                    	if(customer1[k].ID==Integer.parseInt(stringarray[5]))
          	                    		flag=1;
          	                    }
          	                  for(int k=0;k<customer2.length;k++) {
       	                    	if(customer2[k].ID==Integer.parseInt(stringarray[5]))
       	                    		flag=1;
       	                    }
        	            		if(flag==0)
        	            		customer1[counter2++] = new Retail_customer(stringarray[1], stringarray[2], stringarray[3], stringarray[4], Integer.parseInt(stringarray[5]), Integer.parseInt(stringarray[6]));
            	            } 
        	            }catch(NumberFormatException e) {
        	            	 continue; // Bir sonraki satıra geç
        	            }
        	        } else if (stringarray[0].equals("corporate_customer")) {//if second word this
        	           try {
        	        	   if (stringarray.length==8 && stringarray[1].length() > 0 && stringarray[2].length() > 0 && stringarray[3].length() > 0 && stringarray[4].length() > 0 && Integer.parseInt(stringarray[5]) > 0 && Integer.parseInt(stringarray[5])<100000 && Integer.parseInt(stringarray[6]) > 0 && Integer.parseInt(stringarray[6])<100000 && stringarray[7].length() > 0) {
        	        		   int flag=0;
         	                    for(int k=0;k<customer2.length;k++) {
         	                    	if(customer2[k].ID==Integer.parseInt(stringarray[5]))
         	                    		flag=1;
         	                    }
         	                   for(int k=0;k<customer1.length;k++) {
        	                    	if(customer1[k].ID==Integer.parseInt(stringarray[5]))
        	                    		flag=1;
        	                    }
                               if(flag==0) 
        	        		   customer2[counter3++] = new Corporate_customer(stringarray[1], stringarray[2], stringarray[3], stringarray[4], Integer.parseInt(stringarray[5]), Integer.parseInt(stringarray[6]), stringarray[7]);
           	            }
        	           }catch(NumberFormatException e) {
        	        	   continue; // Bir sonraki satıra geç
        	           }
        	        } else if (stringarray[0].equals("operator")) {//if first word is operator
        	           try {
        	        	   if ( stringarray.length==7 && stringarray[1].length() > 0 && stringarray[2].length() > 0 && stringarray[3].length() > 0 && stringarray[4].length() > 0  && Integer.parseInt(stringarray[5]) > 0 && Integer.parseInt(stringarray[5])<100000 && Integer.parseInt(stringarray[6]) > 0 && Integer.parseInt(stringarray[6])<100000) {
        	        		   int flag=0;
         	                    for(int k=0;k<operator1.length;k++) {
         	                    	if(operator1[k].ID==Integer.parseInt(stringarray[5]))
         	                    		flag=1;
         	                    }
        	        		   if(flag==0)
        	        		   operator1[counter4++] = new Operator(stringarray[1], stringarray[2], stringarray[3], stringarray[4], Integer.parseInt(stringarray[5]), Integer.parseInt(stringarray[6]));
           	            } 
        	           }catch(NumberFormatException e) {
        	        	   continue; // Bir sonraki satıra geç	   
        	           }
        	        }
        	    }
        	    scanner.close();
        	} catch (Throwable e) {
        	    e.printStackTrace();
        	}
//you see some if conditions this means that line from the text have to provide these conditisions if not that line will be ignored

        } else {
          System.out.println("Dosya bulunamadı veya erişilemez.");
        }
     
        for(int i = 0; i < operator1.length; i++) {
            operator1[i].define_customers(customer1);
            operator1[i].define_customers(customer2);
        }//defines the costomer for operator
      
        System.out.println("Please enter your ID... ");//takes input from user
        Scanner value = new Scanner(System.in);
        int Id_number;
        try {
             Id_number = value.nextInt();

            if (Id_number < 0 || Id_number > 100000) {
                System.out.println("Invalid Id");
                return;
            }
            // ID geçerli olduğunda devam edebiliriz
        } catch (Exception ignored) {
            return;
        }
     int flag=0,flag2=0;   
     for(int i=0;i<operator1.length;i++) {
    	 if(operator1[i].ID==Id_number) {
    	 operator1[i].print_operator(); 
    	 operator1[i].print_customers();
    	 flag=1;
    	 }
     }//operator varsa onu printler ve customerlerini printler
     if(flag==0) {
    	 if(flag2!=0)
    	  System.out.println("*** Customer Screen ***");//if operator does not exist,
    	  for(int i=0;i<customer1.length;i++) {
          	customer1[i].define_orders(orderer);
          }
          for(int i=0;i<customer2.length;i++) {
          	customer2[i].define_orders(orderer);
         }
          for(int i=0;i<100;i++) {
        	  if(customer1[i].ID==Id_number) {
        		 customer1[i].print_customer();
        		 customer1[i].print_orders();
        		 flag2=1;
        	  }//again i defined the customer for customers
        	  else if(customer2[i].ID==Id_number) {
         		 customer2[i].print_customer();
         		 customer2[i].print_orders();
         	  flag2=1;
        	  }
          }
     }
     if(flag==0 && flag2==0) {
    	 System.out.printf("No operator/customer was found with ID %d. Please try again.",Id_number);
     }

         
    }

	
}
