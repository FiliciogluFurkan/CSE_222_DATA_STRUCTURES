public class MergeSort extends SortAlgorithm {
	
	public MergeSort(int input_array[]) { //we are taking the array from main
		super(input_array);
	}
	
	private void merge(int first, int middle, int last) {
        int size1 = middle - first + 1;//the size of first array
        int size2 = last - middle;//the size of second array
        int[] array1 = new int[size1];//creating new array with the size of size1
        int[] array2 = new int[size2];//creating new another array with the size of size2
        
        for (int i = 0; i < size1; i++) {
        	array1[i] = arr[first + i]; //we are copying the the element to first array
        }
        
        for (int j = 0; j < size2; j++) {
        	array2[j] = arr[middle + 1 + j]; //we are copying the remaining element to second array
        }
        
        int Array1Counter = 0; //first array counter to merge the array
        int Array2Counter = 0; //second array counter to merge the array
        int arrcounter = first; //to keep index value of merged array.In this code,it is 0
        
        while (Array1Counter < size1 && Array2Counter < size2) { 
        	comparison_counter++; //increase the counter
        	if (array1[Array1Counter] <= array2[Array2Counter]) {
        		arr[arrcounter] = array1[Array1Counter];
        		Array1Counter++;
        	} else {
        		arr[arrcounter] = array2[Array2Counter];
        		Array2Counter++;
        	}//this method works like that.İt looks the first array element and looks the second array first element.İf it is smaller insert to arr
        	//then increases own counter.Then again compare the elements which one is smaller.For example second array is smaller.Then insert
        	//to arr array2[Array2Counter] then increases it
        	arrcounter++; //increases the arr counter by one
        }
        // the remaining elements of the left array are added to the array, if there is any
        while (Array1Counter < size1) {
        	arr[arrcounter] = array1[Array1Counter];
        	Array1Counter++;
        	arrcounter++;
        }
        // the remaining elements of the left array are added to the array, if there is any
        //it means the size of the elements are not the same.At the top while loop,one array will be finish.Then another array will not be finished
        //here,we are preventing this condition
        while (Array2Counter < size2) {
        	arr[arrcounter] = array2[Array2Counter];
        	Array2Counter++;
        	arrcounter++;
        }
    }

    private void sort(int first, int last) {
       if (first < last) {
    	   int middle = (first + last) / 2;//we are trying to find middle of the array.Then we will have two seperate array
    	   sort(first, middle);//first seperate array to examine
    	   sort(middle + 1, last); //second array to determine
    	   merge(first, middle, last); //at the end,we are going to merge two seperate array
       }
    }
    
    @Override
    public void sort() {
    	sort(0, arr.length - 1);//we are sending as parameter
    }
    
    @Override
    public void print() {
    	System.out.print("Merge Sort\t=>\t");
    	super.print(); //print Merge sort then calls print method of SortAlgorithm clas
    }
}
