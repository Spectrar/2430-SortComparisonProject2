

import java.util.ArrayList;
import java.util.Arrays;


public class SetGenerator {
    //tester
//    public static void main(String[] args) {
//        SetGenerator temp = new SetGenerator(4);
//        ArrayList<int[]> test = temp.permutation();
//        int count = 0;
//
//        for(int[] a:test){
//            System.out.println(Arrays.toString(a));
//            count++;
//        }
//        System.out.println(count);
//    }
    private int n;

    public SetGenerator(int n) {
        this.n = n;
    }

    public ArrayList<int[]> permutation(){
        ArrayList<int[]> arrayGroup = new ArrayList<>();
        int[] baseArray = new int[n];

        int[] reverseBase = new int[n];
        //populate basearray (first permutation)
        for (int i=0; i<n; i++) {
            baseArray[i]=i;
        }
        int[] tempArray = baseArray.clone();
        //add first permutation to the list of permutations
        arrayGroup.add(baseArray);
        //populate the reverse of the base array
        for (int i=n-1; i>=0; i--) {
            reverseBase[(n-1)-i]=baseArray[i];
        }

        //temp holds current permutation then adds it to array group after permutating it until it hits the reverse order
        while (!Arrays.equals(tempArray,reverseBase)){
            tempArray=permutate(tempArray);
            arrayGroup.add(tempArray.clone());
        }

        return arrayGroup;

    }
    //permutate an array given
    private int[] permutate(int [] a){
        int j;
        int k;
        int r;
        int s;

        j=a.length-1-1;
        while (a[j]>a[j+1]){
            j=j-1;
        }
        k=a.length-1;
        while (a[j]>a[k]){
            k=k-1;
        }
        a[j]=a[k]+a[j];
        a[k]=a[j]-a[k];
        a[j]=a[j]-a[k];
        r=a.length-1;
        s=j+1;
        while (r>s){
            a[r]=a[s]+a[r];
            a[s]=a[r]-a[s];
            a[r]=a[r]-a[s];

            r=r-1;
            s=s+1;
        }

        return a.clone();
    }
}
