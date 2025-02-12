public class BubbleSort extends SortAlgorithm {

    public BubbleSort(int input_array[]) {//we are taking the array from main
        super(input_array);
    }

    @Override
    public void sort() {
        int flag=0;//flag to determine the remaining elements are the sorted or not

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {//this place is so important.we are carrying bigger elements to the ends.So we are 
            	//substracting i because last elements are the biggest.We should not control the all element in the second loop
                comparison_counter++; // increment comparisonCounter for each comparison
                if (arr[j] > arr[j + 1]) {//it compare j values the for the each i value.if this if conditin is valid
                super.swap(j + 1, j); // Swap the elements
                flag=1; //flag becomes 1.This means elements are not sorted yet.Go on
                }
            }
            if(flag==0) { //if flag 0,stop the comparing and return
            	return; //if no element changed for the first comparision,that means array is sorted.So you dont have to make remainings comparisions
            }
            flag=0; //flag becomes 0 again.Because array element can be 0,2,1,3,4,5,6
            //for the i=2,this flag=0 provides comparing remainings
        }
    }

    @Override
    public void print() {
        System.out.print("Bubble Sort\t=>\t");
        super.print(); //print bubble sort then calls print method of SortAlgorithm class
    }
}
