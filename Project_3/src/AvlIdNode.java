public class AvlIdNode {


    private DoubleNode data;

    private int familySize = 1;

    private int height = 0;

    private int leftHeight;
    private int rightHeight;

    private AvlIdNode left;

    private AvlIdNode right;

    public AvlIdNode(DoubleNode stuNode) {
        this.data = stuNode;
    }


    public DoubleNode getStuNode(){
        return this.data;
    }


    public int getNumber() {
        return this.data.getStudent().ID;
    }

    public void setLeft(AvlIdNode left) {
        this.left = left;
    }

    public void setRight(AvlIdNode right) {
        this.right = right;
    }

    public boolean isLeaf () {
        return this.left == null && this.right == null;
    }

    public boolean hasLeft () {
        return this.left != null;
    }

    public boolean hasRight () {
        return this.right != null;
    }

    public boolean hasBoth () {
        return this.left != null && this.right != null;
    }

    public int getFamilySize() {
        int count = 1;
        if (this.hasLeft()) count += this.getLeft().getFamilySize();
        if (this.hasRight()) count += this.getRight().getFamilySize();
        return count;
    }


    public AvlIdNode getLeft() {
        return this.left;
    }

    public AvlIdNode getRight() {
        return this.right;
    }

    public boolean isComplete() {
        if (this.isLeaf()) {
            return true;
        }
        if (this.hasBoth()) {
            return this.getLeft().isComplete() && this.getRight().isComplete();
        }
        return false;
    }

    public int compareTo(int value) {
        return Integer.compare(this.getNumber(), value);
    }

    public Student [] traverseLevelOrder(){
        return traverseLevelOrder(this);
    }

    private Student [] traverseLevelOrder(AvlIdNode node){
        if (node == null) return null;
        Student [] studentsList = new Student[node.getFamilySize()];
        int index = 0;
        Queue queue = new Queue(node.getFamilySize());
        queue.enqueue(node);
        while (!queue.isEmpty()){
            AvlIdNode temp = (AvlIdNode) queue.dequeue();
            studentsList[index++] = temp.getStuNode().getStudent();
//            System.out.println(temp.getNumber());
            if (temp.getLeft() != null) {
                queue.enqueue(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.enqueue(temp.getRight());
            }
        }
        for (int i = 0; i < studentsList.length; i++) {
            System.out.println(studentsList[i].toString());
        }
        return studentsList;
    }

    public int getHeight(){
//        leftHeight = 0;
//        rightHeight = 0;
//        Queue queue = new Queue(this.getFamilySize());
//        queue.enqueue(this);
//        while (!queue.isEmpty()){
//            AvlIdNode temp = (AvlIdNode) queue.dequeue();
//            if (temp.getLeft() != null) {
//                queue.enqueue(temp.getLeft());
//                this.leftHeight++;
//            }
//            if (temp.getRight() != null) {
//                queue.enqueue(temp.getRight());
//                this.rightHeight++;
//            }
//        }
        leftHeight = getLeftHeight();
        rightHeight = getRightHeight();
        this.height = Math.max(leftHeight, rightHeight);
        return this.height;
    }

    public int getLeftHeight() {
        if (this.getLeft() == null) {
            return  0;
        }
        return this.getLeft().getHeight() + 1;
    }

    public int getRightHeight() {
        if (this.getRight() == null) {
            return 0;
        }
        return this.getRight().getHeight() + 1;
    }

    public AvlIdNode findMin(){
        return findMin(this);
    }

    private AvlIdNode findMin(AvlIdNode node){
        if (node.getLeft() == null) return node;
        return findMin(node.getLeft());
    }

    public AvlIdNode findMax(){
        return findMax(this);
    }

    private AvlIdNode findMax(AvlIdNode node){
        if (node.getRight() == null) return node;
        return findMax(node.getRight());
    }
//    public void insert (Student inserted){
//        insert(this, inserted);
//    }
//
//    private void insert (AvlIdNode node, Student inserted){
//        if (node == null) {
//            return;
//        }
//        if (node.compareTo(inserted.getID()) > 0){
//            if (node.getLeft() == null){
//                node.setLeft(new AvlIdNode(inserted));
//            } else {
//                insert(node.getLeft(), inserted);
//            }
//        } else {
//            if (node.getRight() == null){
//                node.setRight(new AvlIdNode(inserted));
//            } else {
//                insert(node.getRight(), inserted);
//            }
//        }
//    }

//    public Student find (int id){
//        return find(this, id).getStudent();
//    }
//
//    private AvlIdNode find (AvlIdNode node, int id){
//        if (node == null) return null;
//        if (node.compareTo(id) == 0) return node;
//        else if (node.compareTo(id) > 0) return find(node.getLeft(), id);
//        else return find(node.getRight(), id);
//    }
//    public void delete (Student student){
//        IntBinaryTree Successor = null;
//        IntBinaryTree parent = null;
//        IntBinaryTree current = find(student);
//        //no node with value found
//        if (current == null) return;
//        //current is the first root and the only node in the tree
//        if (current == this && current.isLeaf()){
//            this.data = null;
//            return;
//        }
//        //current is not the first root but is leaf
//        parent = findParent(current);
//        if (current.isLeaf()){
//            if (parent.getLeft() == current) parent.left = null;
//            else parent.right = null;
//        }
//        //current is in the middle
//        else {
//            if (current.hasLeft()) {
//                Successor = current.getLeft().findMax();
//            }
//            else if (current.hasRight()) {
//                Successor = current.getRight().findMin();
//            }
//            if (Successor != null) {//it will never be null here
//                parent = findParent(Successor);
//                current.data = Successor.data;
//                if (parent.getLeft() == Successor) parent.left = Successor.left;
//                else parent.right = Successor.right;
//            }
//        }
//    }

//    private IntBinaryTree findParent (IntBinaryTree child){
//        if(child == this) return null;
//        IntBinaryTree parent = this;
//        IntBinaryTree current = null;
//        if(child.compareTo(parent.getNumber()) < 0) {
//            current = parent.getLeft();
//        } else {
//            current = parent.getRight();
//        }
//        while (current != child) {
//            parent = current;
//            if (current.hasLeft() && child.compareTo(current.getNumber()) < 0) {
//                current = current.getLeft();
//            } else if ( current.hasRight() && child.compareTo(current.getNumber()) >= 0) {
//                current = current.getRight();
//            }
//        }
//        return parent;
//    }


    public void traverseInOrder (){
        traverseInOrder(this);
    }

    public void traversePreOrder (){
        traversePreOrder(this);
    }

    public void traversePostOrder (){
        traversePostOrder(this);
    }

    private void traverseInOrder(AvlIdNode root){
        if (root == null) return;
        if (root.hasLeft()) traverseInOrder(root.getLeft());
        System.out.println(root.getNumber());
        if (root.hasRight()) traverseInOrder(root.getRight());
    }

    private void traversePreOrder(AvlIdNode root){
        if (root == null) return;
        System.out.println(root.getNumber());
        if (root.hasLeft()) traversePreOrder(root.getLeft());
        if (root.hasRight()) traversePreOrder(root.getRight());
    }

    private void traversePostOrder(AvlIdNode root) {
        if (root == null) return;
        if (root.hasLeft()) traversePostOrder(root.getLeft());
        if (root.hasRight()) traversePostOrder(root.getRight());
        System.out.println(root.getNumber());
    }

    public AvlIdNode rotateLeft(){
        AvlIdNode temp = this.getRight();
        this.setRight(temp.getLeft());
        temp.setLeft(this);
        temp.getHeight();
        return temp;
    }

    public AvlIdNode rotateRight(){
        AvlIdNode temp = this.getLeft();
        this.setLeft(temp.getRight());
        temp.setRight(this);
        temp.getHeight();
        return temp;
    }

    public AvlIdNode rotateLeftRight(){
        this.setLeft(this.getLeft().rotateLeft());
        return rotateRight();
    }

    public AvlIdNode rotateRightLeft(){
        this.setRight(this.getRight().rotateRight());
        return rotateLeft();
    }


}
