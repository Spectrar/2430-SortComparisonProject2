import java.util.ArrayList;

import java.util.HashMap;

public class TopAverageGenerator {
    private ArrayList<int[]> sets;
    private int[][] worst;
    private int[][] best;
    private int average;
    private MyQuickSort qs;
    private MyMergeSort ms;
    private MyHeapSort hs;
    private HashMap<int[], Integer> compareCount;
    private int count;
    private String type;
    //constructor for quick sort
    public TopAverageGenerator(String type, ArrayList<int[]> sets, int[][] worst, int[][] best, int average, MyQuickSort qs, HashMap<int[], Integer> compareCount, int count) {
        this.sets = sets;
        this.worst = worst;
        this.best = best;
        this.average = average;
        this.qs = qs;
        this.compareCount = compareCount;
        this.count = count;
        this.type = type;
    }
    //constructor for Merge sort
    public TopAverageGenerator(String type, ArrayList<int[]> sets, int[][] worst, int[][] best, int average, MyMergeSort ms, HashMap<int[], Integer> compareCount, int count) {
        this.sets = sets;
        this.worst = worst;
        this.best = best;
        this.average = average;
        this.ms = ms;
        this.compareCount = compareCount;
        this.count = count;
        this.type = type;
    }
    //constructor for Heap sort
    public TopAverageGenerator(String type, ArrayList<int[]> sets, int[][] worst, int[][] best, int average, MyHeapSort hs, HashMap<int[], Integer> compareCount, int count) {
        this.sets = sets;
        this.worst = worst;
        this.best = best;
        this.average = average;
        this.hs = hs;
        this.compareCount = compareCount;
        this.count = count;
        this.type = type;
    }

    public int getAverage() {
        return average;
    }

    public int getCount() {
        return count;
    }

    public TopAverageGenerator invoke() {
        for (int[] a: sets){

            //determine which sort is required
            if(type=="q") {
                compareCount.put(a, qs.sort(a.clone()));
            }else if(type=="m"){
                compareCount.put(a, ms.sort(a.clone()));
            }else if(type=="h"){
                compareCount.put(a, hs.sort(a.clone()));
            }

            //populate worst list as values are sorted
            if(worst[0][0]==0 || compareCount.get(a)>compareCount.get(worst[0])) {

                for (int i = 1; i < 10; i++) {
                    //if at the end of the list and bigger
                    if(i==9 && (worst[i][0]==0 ||!(compareCount.get(a)>compareCount.get(worst[i])))){
                        worst[i-1]=worst[i];
                        worst[i]=a;
                        break;
                    }
                    //if current value is larger then one in the list at i
                    if(worst[i][0]==0 ||!(compareCount.get(a)>compareCount.get(worst[i]))){
                        //worst[i-1]=compareCount.get(a);
                        worst[i-1]=worst[i];

                    }else{

                        worst[i-1]=a;
                        break;
                    }

                }
            }
            //populate best list as values are sorted
            if(best[0][0]==0 ||compareCount.get(a)<compareCount.get(best[0])) {

                for (int i = 1; i < 10; i++) {
                    //if at the end of the list and bigger
                    if(i==9 && (best[i][0]==0 || !(compareCount.get(a)<compareCount.get(best[i])))){
                        best[i-1]=best[i];
                        best[i]=a;
                        break;
                    }
                    //if current value is smaller then one in the list at i
                    if(best[i][0]==0 || !(compareCount.get(a)<compareCount.get(best[i]))){
                        best[i-1]=best[i];
                    }else{
                        best[i-1]=a;

                        break;
                    }

                }
            }
            average+=compareCount.get(a);
            count++;
        }
        return this;
    }
}
