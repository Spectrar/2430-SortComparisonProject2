//Minor changes made but Credit to: http://www.java2novice.com/java-sorting-algorithms/merge-sort/

    public class MyMergeSort {

    private int[] array;
    private int[] tempMergArr;
    private int length;
    private int compareCount;

//    public static void main(String a[]){
//
//        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
//        MyMergeSort mms = new MyMergeSort();
//        mms.sort(inputArr);
//        for(int i:inputArr){
//            System.out.print(i);
//            System.out.print(" ");
//        }
//    }

    public int sort(int[] inputArr) {
        compareCount=0;
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
        return compareCount;
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            compareCount++;
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }


    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            compareCount++;
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            compareCount++;
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
}
