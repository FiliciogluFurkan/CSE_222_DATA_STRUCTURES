
import java.util.Map;

public class encrpytor {
private Map<Character,Map<Character,Character>> map;
private String key;
private String Keystream="";
private String Plain_text;
private String cipher_text="";
	
public encrpytor( Map<Character,Map<Character,Character>> _map,String _key,String _text) {
key=_key;
Plain_text=_text;
map=_map;
}//initializing the values
public void encrypt() {
    generate_key_stream();
	generate_cipher_text();
	//calls the methods
}

private void generate_key_stream() { //if text is shorter than key
int size;	
if(Plain_text.length()<key.length()) {
	size=Plain_text.length(); 
	char[] array=new char[size+1]; //it creates an new char array
   for(int i=0;i<size;i++) {
	array[i]=key.charAt(i); //it adds the sizes of text size
   }
Keystream=new String(array);	//creates the keystream
	
}
else if (Plain_text.length() > key.length()) {
    int index = 0; 
    size = Plain_text.length(); 
    char[] array = new char[size];  //creates an another char array

    for (int i = 0; i < size; i++) {
        array[i] = key.charAt(index); 
        index++; 
        if (index == key.length()) 
            index = 0;//it provides null exception.when reaches,it reduces index as 0.So char array filled correctly
    }

    Keystream = new String(array);//it creates the keystream
}

else if(Plain_text.length()==key.length()) { //if equal
	Keystream=key; //it directly equal to key
}
	
}

private void generate_cipher_text() {
    int size = Plain_text.length();
    char[] array = new char[size]; //it creates an char array
    int index = 0;//to control keystream letters

    for (int i=0;i<size;i++) {
        Map<Character, Character> cipherMap = map.get(Plain_text.charAt(i));//it gets the plain text letters one by one.so we obtain map values
        char encryptedChar = cipherMap.get(Keystream.charAt(index)); //then  //for the map values,it gets values according to keystream letters 
        array[index++] = encryptedChar;
    }

    cipher_text = new String(array);//creates cipher text
}

public String getkeystream() {
	return Keystream; //it returns Keystream
	
}
	public String get_cipher_text() {
		return cipher_text; //it returns cipher text
		
	}
	
	
	
}
