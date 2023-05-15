public class StringBinaryTree{

    protected String data;

    private int height = 0;

    protected static int count = 0;

    protected StringBinaryTree left;

    protected StringBinaryTree right;

    public StringBinaryTree(String data) {
        this.data = data;
    }
    public String getString() {
        return this.data;
    }

    public void setLeft(StringBinaryTree left) {
        this.left = left;
        count++;
    }

    public void setRight(StringBinaryTree right) {
        this.right = right;
        count++;
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

    public int getHeight(){
        this.traverseLevelOrder();
        return this.height;
    }

    public String toString () {
        return this.data;
    }

    public static int getCount () {
        return count;
    }


    public StringBinaryTree getLeft() {
        return this.left;
    }

    public StringBinaryTree getRight() {
        return this.right;
    }

    public boolean isFull () {
        if (this.isLeaf()) {
            return true;
        }
        if (this.hasBoth()) {
            return this.getLeft().isFull() && this.getRight().isFull();
        }
        return false;
    }

    public int compareTo(String string) {
        return this.getString().compareTo(string);
    }

    public void traverseLevelOrder(){
        traverseLevelOrder(this);
    }

    protected void traverseLevelOrder(StringBinaryTree node){
        if (node == null) return;
        int leftHeight = 0;
        int rightHeight = 0;
        Queue queue = new Queue(StringBinaryTree.getCount());
        queue.enqueue(node);
        while (!queue.isEmpty()){
            StringBinaryTree temp = (StringBinaryTree) queue.dequeue();
            System.out.println(temp.getString());
            if (temp.getLeft() != null) {
                queue.enqueue(temp.getLeft());
                leftHeight++;
            }
            if (temp.getRight() != null){
                queue.enqueue(temp.getRight());
                rightHeight++;
            }
        }
        height = Math.max(leftHeight, rightHeight) - 1;
    }

    public StringBinaryTree findMin(){
        return findMin(this);
    }

    protected StringBinaryTree findMin(StringBinaryTree node){
        if (node.getLeft() == null) return node;
        return findMin(node.getLeft());
    }

    public StringBinaryTree findMax(){
        return findMax(this);
    }

    protected StringBinaryTree findMax(StringBinaryTree node){
        if (node.getRight() == null) return node;
        return findMax(node.getRight());
    }

    public void insert (String inserted){
        insert(this, inserted);
    }

    protected void insert (StringBinaryTree node, String inserted){
        if (node == null) return;
        if (node.compareTo(inserted) > 0){
            if (node.getLeft() == null){
                node.setLeft(new StringBinaryTree(inserted));
            } else {
                insert(node.getLeft(), inserted);
            }
        } else {
            if (node.getRight() == null){
                node.setRight(new StringBinaryTree(inserted));
            } else {
                insert(node.getRight(), inserted);
            }
        }
    }

    public StringBinaryTree find (String string){
        return find(this, string);
    }

    protected StringBinaryTree find (StringBinaryTree node, String string){
        if (node == null) return null;
        if (node.compareTo(string) == 0) return node;
        else if (string.compareTo(node.getString()) < 0) return find(node.getLeft(), string);
        else return find(node.getRight(), string);
    }
    public void delete (String value){
        StringBinaryTree subtitute = null;
        StringBinaryTree parent = null;
        StringBinaryTree current = find(value);
        //no node with value found
        if (current == null) return;
        //current is the first root and the only node in the tree
        if (current == this && current.isLeaf()){
            this.data = null;
            return;
        }
        //current is not the first root but is leaf
        parent = findParent(current);
        if (current.isLeaf()){
            if (parent.getLeft() == current) parent.left = null;
            else parent.right = null;
        }
        //current is in the middle
        else {
            if (current.hasLeft()) {
                subtitute = current.getLeft().findMax();
            }
            else if (current.hasRight()) {
                subtitute = current.getRight().findMin();
            }
            if (subtitute != null) {//it will never be null here
                parent = findParent(subtitute);
                current.data = subtitute.getString();
                if (parent.getLeft() == subtitute) parent.left = subtitute.left;
                else parent.right = subtitute.right;
            }
        }
    }

    protected StringBinaryTree findParent (StringBinaryTree child){
        if(child == this) return null;
        StringBinaryTree parent = this;
        StringBinaryTree current = null;
        if(child.getString().compareTo(parent.getString()) < 0) {
            current = parent.getLeft();
        } else {
            current = parent.getRight();
        }
        while (current != child) {
            parent = current;
            if (current.hasLeft() && child.getString().compareTo(current.getString()) < 0) {
                current = current.getLeft();
            } else if ( current.hasRight() && child.getString().compareTo(current.getString()) >= 0) {
                current = current.getRight();
            }
        }
        return parent;
    }

    private StringBinaryTree deleteMin(StringBinaryTree right) {
        if (right.getLeft() == null) return right.getRight();
        right.setLeft(deleteMin(right.getLeft()));
        return right;
    }

    public void traverseInOrder (){
        traverseInOrder(this);
    }

    public void traversePreOrder (){
        traversePreOrder(this);
    }

    public void traversePostOrder (){
        traversePostOrder(this);
    }

    protected void traverseInOrder(StringBinaryTree root){
        if (root == null) return;
        if (root.hasLeft()) traverseInOrder(root.getLeft());
        System.out.println(root.getString());
        if (root.hasRight()) traverseInOrder(root.getRight());
    }

    protected void traversePreOrder(StringBinaryTree root){
        if (root == null) return;
        System.out.println(root.getString());
        if (root.hasLeft()) traversePreOrder(root.getLeft());
        if (root.hasRight()) traversePreOrder(root.getRight());
    }

    protected void traversePostOrder(StringBinaryTree root) {
        if (root == null) return;
        if (root.hasLeft()) traversePostOrder(root.getLeft());
        if (root.hasRight()) traversePostOrder(root.getRight());
        System.out.println(root.getString());
    }




}


