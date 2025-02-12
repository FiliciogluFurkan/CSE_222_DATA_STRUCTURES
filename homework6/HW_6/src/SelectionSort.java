public class SelectionSort extends SortAlgorithm {

	public SelectionSort(int input_array[]) { //we are taking the array from main
		super(input_array);
	}
    @Override
    public void sort() {
	int size=arr.length;//we are keeping the size of array
  //in this algorithm,we are finding the smallest  array element.	
			for(int i=0;i<size-1;i++) {
			int index=i;//also we are keeping the index element which is equal to i value
			for(int j=i+1;j<size;j++) { //in the second loop,
				comparison_counter++; //increase the comparision counter
				if(arr[j]<arr[index]) { //if there is an element which is less than arr[index] value,it finds that element.
					//it makes until smallest element is found,than it changes with the i. value with index. value
					//we know index value is smaller than i value(ass arr[]);
			     index=j;	
				}
			}
			super.swap(index,i);	//then swap the array elements
					}
    }

    @Override
    public void print() {
    	System.out.print("Selection Sort\t=>\t");
    	super.print();//it prints selecton sort then calls the print method of Sorthedalgorithm class
    }
}
