package heap;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {


    /**
     *compares two Integers n1 and n2
     *
     * @return negative int if n1>n2, 0 if n1==n2 and positive int if n1<n2
     */
    public int compare(Integer n1, Integer n2){
        return n2-n1;
    }

}
