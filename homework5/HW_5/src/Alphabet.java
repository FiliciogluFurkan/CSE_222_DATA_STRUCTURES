import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class Alphabet {
	
private Set<Character> english_alphabet=new LinkedHashSet<Character>();	
private Map<Character,Map<Character,Character>> map=new HashMap<Character,Map<Character,Character>>();
	
public Alphabet() {
	fiil_english_alphabet();
    fill_map();
}
private void fiil_english_alphabet() {
for(char c:"ABCDEFGHIJKLMNOPQRSTUVYXWYZ".toCharArray()) {
	english_alphabet.add(c);
}
	
}

private void fill_map() {//filling the map
    Iterator<Character> iterator = english_alphabet.iterator();//iterator keeps the beginning value of the set
    while (iterator.hasNext()) {
        char currentLetter = iterator.next();
        Map<Character, Character> map2 = new HashMap<>();//this map is the for values of the key's
        
        char tempLetter = currentLetter;//templetter keeps the current letter in the alphabet
        for (int i = 0; i < 26; i++) {//there is 26 letter in the alphabet.
            map2.put((char) ('A' + i), tempLetter);//for example,for a values,it creates an map2 and adds a=a,b=b,c=c for the letter b,it adds letters
            //b=a,c=b
            tempLetter = (char) (((tempLetter - 'A' + 1) % 26) + 'A'); //it updates the values
        }
        
        map.put(currentLetter,map2);//it adds the Main map
    }
}


public void print_map() {
	//do not edit this method
	System.out.println("*** Viegenere Alphabet ***\n\n");
	System.out.println("    "+english_alphabet);
	System.out.println("   -----------------------------------------------------------------------");
	for(char k:map.keySet()) {
		System.out.print("\n"+k+" | ");
		System.out.print(map.get(k).values());//it prints the map values as map
	}
	
	System.out.println("\n");
}//printing statement


public Map getmap() {
	return map;
}
//returns map
}
