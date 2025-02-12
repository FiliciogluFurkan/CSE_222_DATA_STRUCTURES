import java.util.*;
import java.util.ArrayList;
public class SocialNetwork {
    Map<String, Person> people = new HashMap<>();
    Map<Person, List<Person>> friendships = new HashMap<>();//list of the edges

    // Method to add a person
    public void addPerson(String name, int age, List<String> hobbies) {
        Person person = new Person(name, age, hobbies);
        people.put(name, person);
        friendships.put(person, new ArrayList<>());//than creates an list of people for that person to keep friendships
        System.out.println("Person added: " + person.getName() + " (Timestamp: "+person.getTimestamp()+" )" );//prints added person
        
    }
  //remove person
    public void removePerson(String name,Date date) {    	
    boolean value=people.containsKey(name);  //controls there is a person in the list
    Person person=people.get(name);
    if(value) {
    if(person.getTimestamp().equals(date)){
    people.remove(name); //if it is s,deletes that person from map
    System.out.println("People removed from network succesfully ");
    }
    else{
        System.out.println("Timestamps are not valid");
    }
    
    }
    else {
    	System.out.println("Person is not valid");
    }
    }
     
    
    // Method to add a friendship
    public void addFriendship(String name1, String name2,Date date1,Date date2) {
        Person person1 = people.get(name1);//takes persons from map with these names
        Person person2 = people.get(name2);
        
        if (person1 != null && person1.getTimestamp().equals(date1) && person2 != null && person2.getTimestamp().equals(date2)) {
        	//adds friendships to both person each other
            friendships.get(person1).add(person2);
            friendships.get(person2).add(person1);
            System.out.println("Friendship added between " + person1.getName() + " and " + person2.getName());
        
        } else {
            System.out.println("One or both persons not found in the network.");
        }
    }

	public void removeFriendship(String name1, String name2,Date date1,Date date2) {
		Person person1=people.get(name1); //takes persons from map with these names
		Person person2=people.get(name2);
		
		if(person1==null ||person2==null) {
		System.out.println("Person or persons not found");
		return;
		} //warns user if it is not valid user
        if(!person1.getTimestamp().equals(date1) || !person2.getTimestamp().equals(date2)) {
        	System.out.println("Timestamps are not valid");
        }//controls that time is valid or not
		
		boolean forperson1=friendships.get(person1).contains(person2);
	    if(forperson1) {
	    friendships.get(person1).remove(person2); //if they are friends,remove friendship
	    System.out.println("removed succesfully");
	    }else {
	    	System.out.println("First person does not friend with the second person");
	    }
	    
		boolean forperson2=friendships.get(person2).contains(person1);
	    if(forperson2) {
	    	  friendships.get(person2).remove(person1); //if they are friends,remove friendship
	    }else {
	    	System.out.println("Second person does not friend with the first person");
	    }
		
	}
    
    
   
    private void printPath(Person start, Person end, Map<Person, Person> prev) {//prints the map using bfs algorithm
        List<Person> path = new ArrayList<>();
        for (Person at = end; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println("Shortest path: " + path);
    }

    // Method to count clusters using BFS
    public void CountClusters() {  //finds the clusters
        Set<Person> visited = new HashSet<>();  //set of visited persons
        List<List<Person>> clusters = new ArrayList<>();

        for (Person person : people.values()) { //all persons are here
            if (!visited.contains(person)) { //if that person is not visited
                List<Person> cluster = new ArrayList<>();  //create new list of persons.We are going to keep clusters
                bfs(person, visited, cluster);//calls the bfs algorithm
                clusters.add(cluster); //clusters keeps the cluster as List
            }
        }

        System.out.println("Number of clusters found: " + clusters.size());
        int clusterNumber = 1;
        for (List<Person> cluster : clusters) {
            System.out.println("Cluster " + clusterNumber + ":");
            for (Person person : cluster) {
                System.out.println(person.getName());
            }
            clusterNumber++;
        }
    }

    private void bfs(Person start, Set<Person> visited, List<Person> cluster) {  //bfs algorithm.Teacher implemented this algorithm
        Queue<Person> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Person current = queue.poll(); //current keeps the first person in queue then deletes that person
            cluster.add(current);

            for (Person neighbor : friendships.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
    
    
    // Method to find the shortest path using BFS
    public void findShortestPath(String startName, String endName,Date date1,Date date2) { //takes names and time as parameter
        if (!people.containsKey(startName)) {
            System.out.println("There is no person with the name " + startName);
            return;
        }

        if (!people.containsKey(endName)) {
            System.out.println("There is no person with the name " + endName);
            return;//controls persons are valid
        }
       

        Person start = people.get(startName);//get the persons
        Person end = people.get(endName);

        
        if(!start.getTimestamp().equals(date1) || !end.getTimestamp().equals(date2)) {
        	System.out.println("Invalid timestamps entered");
        	return;
        }
        
        
        Set<Person> visited = new HashSet<>();
        List<Person> path = new LinkedList<>();

        bfs(start, visited, path, end);//ı defined another bfs algorithm.Almost the same which teacher implemented,ı am just sending second
        //person's name as parameter
    }

    private void bfs(Person start, Set<Person> visited, List<Person> path, Person end) {
        Queue<Person> queue = new LinkedList<>();
        Map<Person, Person> previous = new HashMap<>();
        //The main logic of the previous map is to hide the person from whom each person was reached.
        //This way, when we reach the end person, you can retrace the path from start to finish.
        /**
         * basically,queue persons's keyvalues are currentPerson
         */

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Person current = queue.poll();
            if (current.equals(end)) {//just controls whether we arrived at second person's name or not
                buildPath(end, previous, path);
                printPath(path);
                return;
            }

            for (Person neighbor : friendships.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    previous.put(neighbor, current);
                }
            }
        }

        System.out.println("No path found between " + start.getName() + " and " + end.getName());//if not found,print that message
    }

    private void buildPath(Person end, Map<Person, Person> previous, List<Person> path) { //it generates an path and we keep this as persons list
        for (Person at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);//we are starting from end,so we should reverse it
    }

    private void printPath(List<Person> path) {  //print the path
        for (Person person : path) {
            System.out.print(person.getName() + " --> ");
        }
        System.out.println("end");
    }

    public void suggestFriends(String name, int maxSuggestions, Date date) { // suggest friends
        if (!people.containsKey(name)) {
            System.out.println("No user found in network with the name " + name);
            return;
        } // if there is no people with that name

        Person currentPerson = people.get(name); // get the person
        Map<Person, Double> scores = new HashMap<>(); // scores are keeping as map. Each person has a score
        Map<Person, Integer> mutualFriendsMap = new HashMap<>();
        Map<Person, Integer> commonHobbiesMap = new HashMap<>();

        if (!currentPerson.getTimestamp().equals(date)) {
            System.out.println("Invalid time for that user");
            return;
        } // if time is not valid

        for (Person person : people.values()) {
            if (person.equals(currentPerson) || friendships.get(currentPerson).contains(person)) {
                continue; // if they are already friend, do not suggest
            }

            int mutualFriends = getMutualFriends(currentPerson, person).size(); // number of mutual friends
            int commonHobbies = getCommonHobbies(currentPerson, person).size(); // number of common hobbies
            double score = mutualFriends * 1.0 + commonHobbies * 0.5; // calculate the score
            scores.put(person, score);
            mutualFriendsMap.put(person, mutualFriends);
            commonHobbiesMap.put(person, commonHobbies);
        }

        List<Map.Entry<Person, Double>> sortedCandidates = new ArrayList<>(scores.entrySet()); // sort the scores
        sortedCandidates.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        System.out.println("Top " + maxSuggestions + " friend suggestions for " + name + ":"); // prints method
        for (int i = 0; i < Math.min(maxSuggestions, sortedCandidates.size()); i++) {
            Person candidate = sortedCandidates.get(i).getKey();
            double score = sortedCandidates.get(i).getValue();
            int mutualFriends = mutualFriendsMap.get(candidate);
            int commonHobbies = commonHobbiesMap.get(candidate);
            System.out.println(candidate.getName() + " - Score: " + score + " (Mutual Friends: " + mutualFriends + ", Common Hobbies: " + commonHobbies + ")");
        }
    }

    private List<Person> getMutualFriends(Person person1, Person person2) {
        List<Person> mutualFriends = new ArrayList<>(); //create list of mutual friends
        mutualFriends=friendships.get(person1);//this list will keep the current person's friend list
        mutualFriends.retainAll(friendships.get(person2)); //also list should be the same with the second person's friends
        return mutualFriends; //return list of mutual friends
    }

    private List<String> getCommonHobbies(Person person1, Person person2) {
        List<String> commonHobbies = new ArrayList<>();//create list of common friends
        commonHobbies=person1.getHobbies(); ////this list will keep the current person's hobbies list
        commonHobbies.retainAll(person2.getHobbies());//also list should be the same with the second person's hobbies
        return commonHobbies; //return list of common friends
    }



}


