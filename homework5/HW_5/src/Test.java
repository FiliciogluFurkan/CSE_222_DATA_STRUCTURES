
import java.util.Scanner;
import java.util.Map;

//it is same with the Teacher's code
public class Test {
	
	public static void main(String[] args) {
		
		Alphabet a=new Alphabet();
		a.print_map();
		Map<Character,Map<Character,Character>> map=a.getmap();
		
		Scanner reader=new Scanner(System.in);
		System.out.println("Text: ");
		String text=reader.nextLine();
		System.out.println("Key:  ");
		String key=reader.nextLine();
		reader.close();
		
		
		Preprocessor prep=new Preprocessor(text);
		prep.preprocess();
		text=prep.get_preprocessed_string();
		
		prep=new Preprocessor(key);
		prep.preprocess();
		key=prep.get_preprocessed_string();
		
		if(text.length()==0 || key.length()==0) {
			System.out.println("Given input is not proper.Please try again.");
		}else {
			System.out.println("\n\n*************************\nPreprocessed Text:"+text);
			System.out.println("Preprocessed Key: "+key);
			
			//enryption
			encrpytor e=new encrpytor(map, key, text);
			e.encrypt();
			System.out.println("\n\n*************************\nENCRYPTİON");
			System.out.println("Plaintext: "+text);
			System.out.println("Keystream: "+e.getkeystream());
			System.out.println("Ciphertext: "+e.get_cipher_text());
			
			//decryption
			Decryptor d=new Decryptor(map, key, text);
			d.deccrypt();
			System.out.println("\n\n***********\nDECRYPTİON");
			System.out.println("Plaintext: "+text);
			System.out.println("Keystream: "+d.getkeystream());
			System.out.println("Ciphertext: "+d.get_plain_text());
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	

}
