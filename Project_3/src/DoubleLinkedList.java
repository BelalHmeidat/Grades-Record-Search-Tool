import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;

public class DoubleLinkedList {
    private DoubleNode first;
    private DoubleNode last;
    private int size;

    public DoubleLinkedList() {
        first = last = null;
        size = 0;
    }

    public DoubleNode getFirst(){
        if (size <= 0){
            return null;
        }
        return first;
    }

    public DoubleNode getLast(){
        if (size <= 0){
            return null;
        }
        return last;

    }

    public int getSize(){
        return this.size;
    }

    public void addFirst(Student element){
        if (size == 0){
            this.first = this.last = new DoubleNode(element);
            this.size = 1;
            return;
        }
        DoubleNode node = new DoubleNode(element);
        node.next = this.first;
        this.first.prev = node;
        //node.prev is already null;
        this.size++;
        this.first = node;
        this.first.prev = this.last;
        return;
    }

    public void addLast (Student elemnet){
//        if (this.size < 0){
//            System.out.println("NO");
//            return;
//        }
//        LnNode node = new LnNode(elemnet);
        if (this.size == 0){
            this.first = this.last = new DoubleNode(elemnet);
            this.size = 1;
            return;
        }
        if (size == 1){
            DoubleNode node = new DoubleNode(elemnet);
            this.last = node;
            this.first.next = this.last;
            this.last.prev = this.first;
            this.first.prev = this.last;
            this.size++;
            return;
        }

        DoubleNode newNode = new DoubleNode(elemnet);
        newNode.prev = this.last;
//        newNode.next is already null;
        this.last.next = newNode;
        this.last = newNode;
        this.size++;
        this.last.next = this.first;
        return;

    }
    public boolean removeFirst(){
        if (size <= 0){
            System.out.println("NO");
            return false;
        }
        if (size == 1) {
            last = first = null;
            size = 0;
            return true;
//            System.out.println(first);
//            System.out.println(last);
        }
        if (size == 2){
            first = last;
            first.next = null;
            last.prev = null;
            size--;
            return true;
        }
        DoubleNode nwNode = first.next;
        first.next = null;
        nwNode.prev = null;
        first = nwNode;
        first.prev = last;
        last.next = first;
        size--;
        return true;
    }

    public boolean removeLast(){
        if (size <= 0 ){
//            System.out.println("NO");
            return false;

        }
        if (size == 1){
            last = first = null;
            size = 0;
            return true;
        }
        if (size == 2){
            last = first;
            last.prev = null;
            first.next = null;
            size--;
            return true;
        }
        DoubleNode nwNode = last.prev;
        last.prev = null;
        nwNode.next = null;
        last = nwNode;
        last.next = first;
        first.prev = last;
        size--;
        return true;
    }
    //Not used
    public void add (Student element, int index){
        if (size <= 0 || index >= size || index < 0){
            System.out.println("NO");
            return;
        }
        if (index == 0){
            addFirst(element);
            return;
        }
        if (index == size - 1){
            addLast(element);
            return;
        }
        DoubleNode current = new DoubleNode();
        current = first;
        for (int i =0; i != index; i++){
            current = current.next;
        }
        DoubleNode newNode = new DoubleNode();
        newNode.prev = current;
        current.next = newNode;
        newNode.student = element;
        size++;
        return;

    }

    public void delete (Student student){
        if (size <= 0){
            System.out.println("NO");
            return;
        }
        DoubleNode current = new DoubleNode();
        current = first;
        for (int i = 0; i < size; i++){
            if (current.student.equals(student)){
                if (i == 0){
                    removeFirst();
                    return;
                }
                if (i == size - 1){
                    removeLast();
                    return;
                }
                DoubleNode removedNode = current;
                current.prev.next = current.next;
                current.next.prev = current.prev;
                removedNode.next = null;
                removedNode.prev = null;
                size--;
                return;
            }
            current = current.next;
        }
        System.out.println("NO");
        return;
    }
    //Not used
    public void remove (int index){
        if (size <= 0 || index >= size || index < 0){
            System.out.println("NO");
            return;
        }
        if (index == 0){
            removeFirst();
            return;
        }
        if (index == size - 1){
            removeLast();
            return;
        }
        DoubleNode current = new DoubleNode();
        current = first;
        for (int i = 0; i != index; i ++){
            current = current.next;
        }
        DoubleNode removedNode = current.next;
        current.next = removedNode.next;
        removedNode.next.prev = current;
        removedNode.next = null;
        removedNode.prev = null;
        size--;
        return;

    }
    public static DoubleLinkedList appendList(DoubleLinkedList list, DoubleLinkedList list2){

        list.last.next = list2.first;
        list2.first.prev = list.last;
        list.last = list2.last;
        list.size += list2.size;
        return list;
     }

    //  public void insertSort (){
    //     // LnList tmp = new LnList();
    //     // tmp = this.copy();
    //     LnNode current = this.getFirst();
    //     LnNode next = this.getFirst().next;

    //     for (int i = 1; i < this.size; i++){
    //         int key = array[i];
    //         int j = i - 1;
    //         while (j >= 0 && array[j] > key){
    //             array[j + 1] = array[j];
    //             j--;
    //         }
    //         array[j + 1] = key;
            

            
    //     }

    // }
    private static void swap(Student value1, Student value2) {
        Student temp = value1;
        value1 = value2;
        value2 = temp;
    }

     public DoubleLinkedList copy(){
        DoubleLinkedList copy = new DoubleLinkedList();
        DoubleNode current = first;
        for (int i = 0; i < this.size; i++){
            copy.addLast(current.student);
            current = current.next;
        }
        return copy;
    }

    public void print(){
        DoubleNode current = getFirst();
        for (int i = 0; i < size; i++){
            System.out.println(current.getStudent());
            current = current.next;
        }
    }
    public Student find(int id){
        DoubleNode current = first;
        for (int i = 0; i < size; i++){
            if ( current.student.getID() == id){
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    public void saveToFile(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        DoubleNode current = first;
        for (int i = 0; i < this.size; i++) {
            fw.write(((Student) current.student).getID() + "," + ((Student) current.student).branch + "," + ((Student) current.student).gpa + "\n");
            current = current.next;
        }
        fw.close();
    }

    public void setFirst(DoubleNode node) {
        this.first = node;
    }

    public void setLast(DoubleNode node) {
        this.last = node;
    }

    public void setSize(int i) {
        this.size = i;
    }

    public ObservableList<Student> getObservableList() {
        ObservableList<Student> list = FXCollections.observableArrayList();
        DoubleNode current = first;
        for (int i = 0; i < size; i++) {
            list.add(current.student);
            current = current.next;
        }
        return list;
    }
}