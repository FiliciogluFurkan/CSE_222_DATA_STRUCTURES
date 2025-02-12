public class QuickSort extends SortAlgorithm {

	public QuickSort(int input_array[]) { //we are taking the array from main
		super(input_array);
	}
	
	//than pivot as index
	private int partition(int _first, int _last) {
	    int pivot = arr[_last];
	    int i=_first-1;
	    for(int j=_first;j<_last;j++) {
	    	comparison_counter++;
	    	if(arr[j]<pivot) {// if arr[i] is greater than the pivot, i stays the same
	    		i++;
	    		swap(i,j);
	    	}
	    }//if there is no number lesser than the pivot, then start is the new index of the pivot
	    swap(i+1,_last);
	    return i+1;
	    
	}

	private void sort(int first, int last) {
	    if (first < last) {
	    
	        int partitionIndex = partition(first, last);
	        sort(first, partitionIndex-1); //we are looking for two different place 
	        sort(partitionIndex+1, last);  //if it is smaller than partitionindex-1 and greater then partitionindex+1
	    }
	}

    @Override
    public void sort() {
    	sort(0,arr.length-1); //we are calling sort method from main and we are sending 0 and arr.length-1 as parameter
    }

    @Override
    public void print() {
    	System.out.print("Quick Sort\t=>\t");
    	super.print();//prints Quick sort and class the print method of Sortalgorithm class
    }
}
