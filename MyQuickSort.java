// Minor changes made but main credit to: http://www.java2novice.com/java-sorting-algorithms/quick-sort/
public class MyQuickSort {

    private int array[];
    private int length;
    private int compareCount;

    public int sort(int[] inputArr) {
        compareCount=0;

        if (inputArr == null || inputArr.length == 0) {
            return compareCount;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);

        return compareCount;
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            compareCount++;

            while (array[i] < pivot) {

                i++;
            }
            while (array[j] > pivot) {
                j--;

            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        compareCount++;
        if (i < higherIndex)
            quickSort(i, higherIndex);
        compareCount++;
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
