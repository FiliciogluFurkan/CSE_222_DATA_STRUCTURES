import java.text.SimpleDateFormat;
import java.util.*;

public class Person {
    private String name;
    private int age;
    private List<String> hobbies;
    private Date timestamp;

    public Person(String name, int age, List<String> hobbies) { //constructor
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //creates and timestamp
        this.timestamp = new Date(); 
        String formattedTimestamp = formatter.format(this.timestamp);
        try {
            this.timestamp = formatter.parse(formattedTimestamp); //than person's timestamp is determined
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters 
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies); // Return a copy to maintain encapsulation
    }

    public Date getTimestamp() {
        return new Date(timestamp.getTime()); // Return a copy to maintain encapsulation
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = new ArrayList<>(hobbies); // Create a copy to maintain encapsulation
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = new Date(timestamp.getTime()); // Create a copy to maintain encapsulation
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Hobbies: " + hobbies + ")";
    }
}
