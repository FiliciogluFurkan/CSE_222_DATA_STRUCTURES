import java.util.Map;
import java.util.Iterator;


public class Decryptor {

	private Map<Character,Map<Character,Character>> map;
	private String key;
	private String Keystream="";
	private String Plain_text="";
	private String cipher_text;
	
	public Decryptor( Map<Character,Map<Character,Character>> _map,String _key,String _text) {
		key=_key;
		cipher_text=_text;
		map=_map;

	}//initializing the values
	public void deccrypt() {
		generate_key_stream();
		generate_plain_text();	
	}//calls the methods

	private void generate_key_stream() {//same as the encryptor.it is explained there
		int size;	
		if(cipher_text.length()<key.length()) {
			size=cipher_text.length();
			char[] array=new char[size+1];
		   for(int i=0;i<size;i++) {
			array[i]=key.charAt(i);
		   }
		Keystream=new String(array);	
			
		}
		else if (cipher_text.length() > key.length()) {
		    int index = 0; 
		    size = cipher_text.length(); 
		    char[] array = new char[size]; 

		    for (int i = 0; i < size; i++) {
		        array[i] = key.charAt(index); 
		        index++; 
		        if (index == key.length()) 
		            index = 0;
		    }

		    Keystream = new String(array);
		}

		else if(cipher_text.length()==key.length()) {
			Keystream=key;
		}

	}
	private void generate_plain_text() {//it is similar to encryptor algorithm but a little bit different
	    int size = Keystream.length();
	    char[] array = new char[size];//it creates an new char array
	int index=0;
	  
	    for(int i=0;i<size;i++) { //it lops as the size of Keystream Length
	        Map<Character, Character> cipherMap = map.get(Keystream.charAt(i));//we obtain the key values according to the Keystream letter
	        //this gives an a map.
	        if (cipherMap == null) {
	            continue;//if map is null,go on
	        }
	        char decryptedChar = '\0'; //char valu.it will keep the letter.İnitialized to \0;
	        
	        Iterator<Character> keyIterator = cipherMap.keySet().iterator();//this one will give use the key values which is char
	        while (keyIterator.hasNext()) {
	            char key = keyIterator.next();
	            if (cipherMap.get(key) == cipher_text.charAt(index)) {//if it is equal to cipher text value,
	                decryptedChar = key;//we gets the char values and adds to the array
	                break;
	            }
	        }
	        array[index++] = decryptedChar;
	    }

	    Plain_text = new String(array);//creates plain text
	}

	public String getkeystream() {
		return Keystream;
		
	}
		public String get_plain_text() {
			return Plain_text;
			
		}
		
	
}
