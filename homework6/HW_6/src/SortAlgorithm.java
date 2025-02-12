public class SortAlgorithm {
	static int arr[];
	static int comparison_counter;
	static int swap_counter;

	public SortAlgorithm(int input_array[]) {
		arr = input_array.clone(); 
		comparison_counter = 0;
		swap_counter = 0;
	}
	
	public void sort() {
		
	}//this method will be overrided by subclass's sort funciton
	
	protected static void swap(int index_1, int index_2) {
		int temp = arr[index_1];
		arr[index_1] = arr[index_2];
		arr[index_2] = temp;
		swap_counter +=1; ///increase swap counter value by one
	}//it swaps the value of index1 and index2
	
	public void print() {
		System.out.print("Comparison Counter: " + comparison_counter);
		System.out.print("   \t Swap Counter: " + swap_counter);
		System.out.print("   \t Sorted Array: ");
		for(int e: arr)
			System.out.print(e + " ");
		System.out.println();		
	}//it prints the array element one by one
	
	public void sort_and_print() {
		sort();//every object calls this method in main.then this method calls the other necessary method inside in
		print();
	}
}