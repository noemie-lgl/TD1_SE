package heap;

import java.util.ArrayList;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter capactity:");

        int capacity=sc.nextInt();

        SortedHeap heap = new SortedHeap(capacity, new MyComparator());

        System.out.println("Enter the elements:");


        for(int i=0; i<capacity ; i++){
            heap.insertElement(sc.nextInt());
        }


        ArrayList array=heap.heapToArrayList();

        System.out.println("The heap corresponding is:" + array);

        System.out.println("Enter another element (this time, the heap is full) :");

        heap.insertElement(sc.nextInt());

        ArrayList array2=heap.heapToArrayList();

        System.out.println("The heap is now bigger:" + array2 );

        System.out.println("The bigger element of the heap is: " + heap.element());


        heap.popElement();

        ArrayList array3=heap.heapToArrayList();
        System.out.println("The heap without this element becomes:" + array3);


    }
}


