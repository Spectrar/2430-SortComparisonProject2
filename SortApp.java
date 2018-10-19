import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SortApp {
    //variables to hold n=4 data
    private HashMap<int[], Integer> n4Q;
    private HashMap<int[], Integer> n4M;
    private HashMap<int[], Integer> n4H;
    private int[][] q4Best = new int[10][4];
    private int[][] q4Worst = new int[10][4];
    private int[][] m4Best = new int[10][4];
    private int[][] m4Worst = new int[10][4];
    private int[][] h4Best = new int[10][4];
    private int[][] h4Worst = new int[10][4];
    private int q4Average;
    private int m4Average;
    private int h4Average;
    //variables to hold n=6 data
    private HashMap<int[], Integer> n6Q;
    private HashMap<int[], Integer> n6M;
    private HashMap<int[], Integer> n6H;
    private int[][] q6Best = new int[10][4];
    private int[][] q6Worst = new int[10][4];
    private int[][] m6Best = new int[10][4];
    private int[][] m6Worst = new int[10][4];
    private int[][] h6Best = new int[10][4];
    private int[][] h6Worst = new int[10][4];
    private int q6Average;
    private int m6Average;
    private int h6Average;
    //variables to hold n=8 data
    private HashMap<int[], Integer> n8Q;
    private HashMap<int[], Integer> n8M;
    private HashMap<int[], Integer> n8H;
    private int[][] q8Best = new int[10][4];
    private int[][] q8Worst = new int[10][4];
    private int[][] m8Best = new int[10][4];
    private int[][] m8Worst = new int[10][4];
    private int[][] h8Best = new int[10][4];
    private int[][] h8Worst = new int[10][4];
    private int q8Average;
    private int m8Average;
    private int h8Average;

    public static void main(String[] args) {
        SortApp app = new SortApp();

        //populate variables with data for n=4
        SetGenerator myGen4 = new SetGenerator(4);
        Pair<HashMap<int[], Integer>,Integer> p4Quick = app.myQuick(myGen4.permutation(),app.q4Worst, app.q4Best);
        app.n4Q= p4Quick.getKey();
        app.q4Average = p4Quick.getValue();

        Pair<HashMap<int[], Integer>,Integer> p4Merge = app.myMerge(myGen4.permutation(),app.m4Worst, app.m4Best);
        app.n4M= p4Merge.getKey();
        app.m4Average = p4Merge.getValue();

        Pair<HashMap<int[], Integer>,Integer> p4Heap = app.myHeap(myGen4.permutation(),app.h4Worst, app.h4Best);
        app.n4H= p4Heap.getKey();
        app.h4Average = p4Heap.getValue();

        //populate variables with data for n=6
        SetGenerator myGen6 = new SetGenerator(6);
        Pair<HashMap<int[], Integer>,Integer> p6Quick = app.myQuick(myGen6.permutation(),app.q6Worst, app.q6Best);
        app.n6Q= p6Quick.getKey();
        app.q6Average = p6Quick.getValue();

        Pair<HashMap<int[], Integer>,Integer> p6Merge = app.myMerge(myGen6.permutation(),app.m6Worst, app.m6Best);
        app.n6M= p6Merge.getKey();
        app.m6Average = p6Merge.getValue();

        Pair<HashMap<int[], Integer>,Integer> p6Heap = app.myHeap(myGen6.permutation(),app.h6Worst, app.h6Best);
        app.n6H= p6Heap.getKey();
        app.h6Average = p6Heap.getValue();


        //populate variables with data for n=8
        SetGenerator myGen8 = new SetGenerator(8);
        Pair<HashMap<int[], Integer>,Integer> p8Quick = app.myQuick(myGen8.permutation(),app.q8Worst, app.q8Best);
        app.n8Q= p8Quick.getKey();
        app.q8Average = p8Quick.getValue();

        Pair<HashMap<int[], Integer>,Integer> p8Merge = app.myMerge(myGen8.permutation(),app.m8Worst, app.m8Best);
        app.n8M= p8Merge.getKey();
        app.m8Average = p8Merge.getValue();

        Pair<HashMap<int[], Integer>,Integer> p8Heap = app.myHeap(myGen8.permutation(),app.h8Worst, app.h8Best);
        app.n8H= p8Heap.getKey();
        app.h8Average = p8Heap.getValue();






        app.printLists();



    }

    //Print data from variables in a readable format
    private void printLists(){
        //print lists for QuickSort
        System.out.println("QuickSort n=4  Average: "+q4Average+" \nBest:               Worst:");
        for(int i=0; i<10; i++) {

                System.out.println(" " + Arrays.toString(q4Best[i])+": "+ n4Q.get(q4Best[i])+" | " +
                        Arrays.toString(q4Worst[i])+": "+ n4Q.get(q4Worst[i]));

        }
        System.out.println();
        System.out.println("QuickSort n=6  Average: "+q6Average+" \nBest:                     Worst:");
        for(int i=0; i<10; i++) {

            System.out.println(" " + Arrays.toString(q6Best[i])+": "+ n6Q.get(q6Best[i])+" | " +
                    Arrays.toString(q6Worst[i])+": "+ n6Q.get(q6Worst[i]));

        }
        System.out.println();
        System.out.println("QuickSort n=8  Average: "+q8Average+" \nBest:                           Worst:");
        for(int i=0; i<10; i++) {

            System.out.println(" " + Arrays.toString(q8Best[i])+": "+ n8Q.get(q8Best[i])+" | " +
                    Arrays.toString(q8Worst[i])+": "+ n8Q.get(q8Worst[i]));

        }
        System.out.println();

        //print lists for MergeSort
        System.out.println();
        System.out.println("MergeSort n=4  Average: "+m4Average+" \nBest:               Worst:");
        for(int i=0; i<10; i++) {

            System.out.println(" " + Arrays.toString(m4Best[i])+": "+ n4M.get(m4Best[i])+" | " +
                    Arrays.toString(m4Worst[i])+": "+ n4M.get(m4Worst[i]));

        }
        System.out.println();
        System.out.println("MergeSort n=6  Average: "+m6Average+" \nBest:                     Worst:");
        for(int i=0; i<10; i++) {

            System.out.println(" " + Arrays.toString(m6Best[i])+": "+ n6M.get(m6Best[i])+" | " +
                    Arrays.toString(m6Worst[i])+": "+ n6M.get(m6Worst[i]));

        }
        System.out.println();
        System.out.println("MergeSort n=8  Average: "+m8Average+" \nBest:                           Worst:");
        for(int i=0; i<10; i++) {

            System.out.println(" " + Arrays.toString(m8Best[i])+": "+ n8M.get(m8Best[i])+" | " +
                    Arrays.toString(m8Worst[i])+": "+ n8M.get(m8Worst[i]));

        }
        System.out.println();

        //print lists for HeapSort
        System.out.println();
        System.out.println("HeapSort n=4  Average: "+h4Average+" \nBest:               Worst:");
        for(int i=0; i<10; i++) {

            System.out.println(" " + Arrays.toString(h4Best[i])+": "+ n4H.get(h4Best[i])+" | " +
                    Arrays.toString(h4Worst[i])+": "+ n4H.get(h4Worst[i]));

        }
        System.out.println();
        System.out.println("HeapSort n=6  Average: "+h6Average+" \nBest:                     Worst:");
        for(int i=0; i<10; i++) {

            System.out.println(" " + Arrays.toString(h6Best[i])+": "+ n6H.get(h6Best[i])+" | " +
                    Arrays.toString(h6Worst[i])+": "+ n6H.get(h6Worst[i]));

        }
        System.out.println();
        System.out.println("HeapSort n=8  Average: "+h8Average+" \nBest:                           Worst:");
        for(int i=0; i<10; i++) {

            System.out.println(" " + Arrays.toString(h8Best[i])+": "+ n8H.get(h8Best[i])+" | " +
                    Arrays.toString(h8Worst[i])+": "+ n8H.get(h8Worst[i]));

        }
        System.out.println();





    }
    //controls QuickSort comparisons
    private Pair<HashMap<int[], Integer>, Integer> myQuick(ArrayList<int[]> sets, int[][] worst, int[][] best){
        int average=0;
        MyQuickSort qs = new MyQuickSort();
        HashMap<int[], Integer> compareCount = new HashMap();
        int count=0;
        String type ="q";

        //give data to top lists and average generator
        TopAverageGenerator topAverageGenerator = new TopAverageGenerator(type, sets, worst, best, average, qs, compareCount, count).invoke();
        average = topAverageGenerator.getAverage();
        count = topAverageGenerator.getCount();

        average= average/count;

        // return the average and hashmap of comparisons
        return new Pair<>(compareCount, average);

    }
    //controls MergeSort comparisons
    private Pair<HashMap<int[], Integer>, Integer> myMerge(ArrayList<int[]> sets, int[][] worst, int[][] best){
        int average=0;
        MyMergeSort ms = new MyMergeSort();
        HashMap<int[], Integer> compareCount = new HashMap();
        int count=0;

        String type ="m";
        //give data to top lists and average generator
        TopAverageGenerator topAverageGenerator = new TopAverageGenerator(type, sets, worst, best, average, ms, compareCount, count).invoke();
        average = topAverageGenerator.getAverage();
        count = topAverageGenerator.getCount();

        average= average/count;
        // return the average and hashmap of comparisons
        return new Pair<>(compareCount, average);

    }
    //controls HeapSort comparisons
    private Pair<HashMap<int[], Integer>, Integer> myHeap(ArrayList<int[]> sets, int[][] worst, int[][] best){
        int average=0;
        MyHeapSort hs = new MyHeapSort();
        HashMap<int[], Integer> compareCount = new HashMap();
        int count=0;

        String type ="h";
        //give data to top lists and average generator
        TopAverageGenerator topAverageGenerator = new TopAverageGenerator(type, sets, worst, best, average, hs, compareCount, count).invoke();
        average = topAverageGenerator.getAverage();
        count = topAverageGenerator.getCount();

        average= average/count;
        // return the average and hashmap of comparisons
        return new Pair<>(compareCount, average);

    }


}
