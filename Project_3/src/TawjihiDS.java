import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TawjihiDS {
    AvlIdTree IDs = null;
    AvlGpaTree GPAs ;

    DoubleLinkedList students = new DoubleLinkedList();

    TawjihiDS() {
    }

    TawjihiDS(File file) throws FileNotFoundException {
        if (file == null){
            return;
        }
        fill(file);

    }

    public boolean exist(int id){
        if (IDs == null){
            return false;
        }
        return IDs.find(id) != null;
    }

    public Student find(int id){
        if (IDs == null){
            return null;
        }
        return IDs.find(id).getStudent();
    }

    public boolean removeStudent(int id) {
        if (students.getSize() == 0){
            Interface.removeError.setText("No students!");
            return false;
        }
        DoubleNode tmp = IDs.find(id);
        if (tmp == null){
            Interface.removeError.setText("Student not found!");
            return false;
        }
        if (tmp.next == tmp){
            students = new DoubleLinkedList();
            IDs = null;
            GPAs = null;
            return true;
        }
        if (tmp == students.getFirst()){
            students.removeFirst();

        }
        else if (tmp == students.getLast()){
            students.removeLast();
        }
        else {
            DoubleNode next = tmp.next;
            DoubleNode prev = tmp.prev;
            next.prev = prev;
            prev.next = next;
            tmp.next = null;
            tmp.prev = null;
            students.setSize(students.getSize() - 1);
        }
        updateTrees();
        return true;

    }

    public void updateTrees(){
        IDs = new AvlIdTree(new AvlIdNode(students.getFirst()));
        GPAs = new AvlGpaTree(new AvlGpaNode(students.getFirst().getStudent()));
        DoubleNode current = students.getFirst().next;
        while (current != students.getFirst()) {
            IDs.insert(current);
            GPAs.insert(current.getStudent());
            current = current.next;
        }

    }


    public void fill(File file) throws FileNotFoundException{
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String [] data = line.split(",");
            String branch = data[1];
            if (branch.trim().equalsIgnoreCase("Scientific") && Interface.literaryRadio.isSelected()){
                continue;
            }
            else if (branch.trim().equalsIgnoreCase("Literary") && Interface.scientificRadio.isSelected()){
                continue;
            }
            int ID = -1;
            try{
                ID = Integer.parseInt(data[0]);
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid ID");
                continue;
            }
            float GPA = -1;
            try {
                GPA = Float.parseFloat(data[2]);
            }
            catch (NumberFormatException e){
                System.out.println("Invalid GPA");
                continue;
            }
            Student student = new Student(ID, branch, GPA);
            this.students.addLast(student);
            if (this.IDs == null){
                this.IDs = new AvlIdTree(new AvlIdNode(students.getFirst()));
                this.GPAs = new AvlGpaTree(new AvlGpaNode(students.getFirst().getStudent()));
                continue;
            }
            this.IDs.insert(students.getLast());
            this.GPAs.insert(student);
        }
    }

    public void traverseLevelOrder() {
        this.IDs.traverseLevelOrder();
        this.GPAs.traverseLevelOrder();
    }

    public void saveToFile(String filename) throws IOException {
        this.students.saveToFile(filename);
    }


    public void insert(Student student) {
        if (this.students.getSize() == 0){
            this.students.addLast(student);
            this.IDs = new AvlIdTree(new AvlIdNode(students.getFirst()));
            this.GPAs = new AvlGpaTree(new AvlGpaNode(students.getFirst().getStudent()));
            return;
        }
        this.students.addLast(student);
        this.IDs.insert(students.getLast());
        this.GPAs.insert(student);
    }

    public ObservableList<Student> getObservableList() {
        return this.students.getObservableList();
    }
}
