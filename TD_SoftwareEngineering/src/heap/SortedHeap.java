package heap;

import java.util.*;

public class SortedHeap extends MyComparator implements Heap<Integer> {


    private int capacity;
    private int size;
    private Integer queue[];
    private Comparator comp;

    public SortedHeap(int capacity, Comparator<Integer> mycomparator) {
        this.size = 0;
        this.capacity = capacity;
        this.queue = new Integer[capacity];
        this.comp = mycomparator;
    }


    /**
     * Converts a heap into an ArrayList
     *
     * @return an ArrayList that contains the values of the Heap
     */
    public ArrayList heapToArrayList() {
        Iterator it= this.iterator();
        ArrayList<Object > new_list = new ArrayList<Object>();
        while (it.hasNext()) {
            new_list.add(it.next());
        }
        return new_list;
    }


    /**
     * Returns true if this heap contains no elements.
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of elements contained in this heap
     */
    public int size() {
        return this.size;
    }


    /**
     * transforms the order of the elements so that they follow the properties of an heap in a recursive way
     * with a top-down approach
     *
     * @param father : starts with the father and its children (if they exist)
     */

    public void sortElementDown(int father){

        int up =father;
        int son_l= 2*father + 1;
        int son_r=2*father + 2; // on vérifiera ensuite que l'élément d'index father a des enfants


        if ( son_l < size && this.comp.compare(this.queue[up],this.queue[son_l])>0) {
            up=son_l;
        }
        if ( son_r < size && this.comp.compare(this.queue[up],this.queue[son_r])>0){
            up=son_r;
        }
        if (up!=father){
            this.exchange(father,up);
            this.sortElementDown(up);
        }
    }

    /**
     * transforms the order of the elements so that they follow the properties of an heap in a recursive way
     * with a bottom-up approach
     *
     * @param son : starts with the son and its father
     */
    public void sortElementUp(int son){

        int father= (son - 1)/2;

        if ( this.comp.compare(this.queue[father],this.queue[son])>0) {
            this.exchange(father,son);
            this.sortElementUp(father);
        }
    }


    /**
     * Add specified element into this heap.Heap, increase capacity of the heap if not enough space
     *
     * @return true if the element was successfully added
     */
    public boolean insertElement(Integer e) {
        if (this.isEmpty()){
            this.queue[0]=e;
            ++this.size;
            return true;
        }
        else {
            if (this.size == this.capacity) {
                ++this.capacity;
                this.queue = Arrays.copyOf(this.queue, this.capacity);
            }

            this.queue[this.size] = e;
            this.sortElementUp(this.size);// une fois l'élément ajouté, on trie en remontant
            ++this.size;
            return true;
        }
    }

    /**
     * Retrieves (without removing) the highest element of this heap
     *
     * @return the highest element of this heap
     * @throws NoSuchElementException if this heap is empty
     */
    public Integer element()
            throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return this.queue[0]; // on suppose que les éléments respectent les propriétés du tas
        }
    }

    /**
     *
     * Exchange the element of index i with the element of index j
     *
     */
    public void exchange(int i, int j){
        Integer val = this.queue[i];
        this.queue[i]=this.queue[j];
        this.queue[j]=val;
    }

    /**
     * Retrieves (and remove) the highest element of this heap
     *
     * @return the highest element of this heap
     * @throws NoSuchElementException if this heap is empty
     */
    public Integer popElement()
            throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Integer elmt=this.queue[0]; // on suppose que les éléments respectent les propriétés du tas
            this.queue[0]=null;
            this.exchange(0,(this.size-1));
            --this.size;
            this.sortElementDown(0);
            return elmt;
        }
    }



    public Iterator<Integer> iterator() {

        Iterator<Integer> it = new Iterator<>() {

            private int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < size && queue[currentIndex] != null;
            }

            public Integer next() {
                return queue[currentIndex++];
            }
        };

    return it;
    }


}







