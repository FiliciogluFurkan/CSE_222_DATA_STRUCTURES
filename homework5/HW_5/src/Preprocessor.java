
public class Preprocessor {
private String initial_string;
private String preprocessed_string;

public Preprocessor(String str) {
	initial_string=str;
	preprocessed_string="";
}//initializing the values

public void preprocess() {
	capitalize();
	clean();
}//calling the methods

private void clean() {
	
char c;
for(int i=0;i<initial_string.length();i++) {
	c=initial_string.charAt(i);
	if((c>='A' && c<='Z')) {//if letter is not a alphabet value,it ignores the other values whatever it is.
		preprocessed_string=preprocessed_string+c; 
	}
}
    
}

private void capitalize() {
    char[] array = new char[initial_string.length()]; //it creaetes an char array to keep the letter which is maken Capital letter
    int index = 0;
    char c;
    for (int i=0;i<initial_string.length();i++) {
        c=initial_string.charAt(i);
    	if (c >= 'a' && c <= 'z') { //if letter is small
            array[index++] = Character.toUpperCase(c); //it makes upperCase and adds the array
        } else {
            array[index++] = c;
        }
    }
    
    initial_string = new String(array); //it changes the initial_string with the capital letters
 
}
	
public String get_preprocessed_string() {
	if(preprocessed_string==null) //if preprocessed string is null
    return ""; //return this
    else
    return preprocessed_string; //else return this
}

}
