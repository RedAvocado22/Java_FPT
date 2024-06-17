package data;
public interface I_LinkedList {
    public Node find(int val);
    public int size(); //
    public boolean isEmpty(); //
    
    public void clear(); //
    public void traverse(); //
    public void addTail(int val); //
    public void addTail(LinkedList list); //
    public void addHead(int val); //
    public void delTail(); //
    public void delHead(); //
    public void insert(int index, int val); //
    public void remove(int index); //
    public void reverse();//
    
    public void addAfter(int target, int val); //
    public void addBefore(int target, int val);
    public void addSorted(int val);//
    public void delAfter(int target); //
    public void del(int target); //
    public int search(int target); //

    public int max(); //

    public int min(); //
    public int sum(); // 
    public double avg(); //
    public boolean isSorted();//
    public boolean equalsIgnoreOrder(LinkedList list); //
    
    public void sort(); //
    public int[] toArray(); //
    
    public LinkedList merge(LinkedList list1, LinkedList list2);//
    
    
}
