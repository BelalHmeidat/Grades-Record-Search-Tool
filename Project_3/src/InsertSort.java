//public class InsertSort {
//    public static void sortArray(int arr[]){
//        for (int i = 1; i < arr.length; i++){
//            int temp = arr[i];
//            int j = i - 1;
//            while (j >= 0 && arr[j] > temp){
//                arr[j + 1] = arr[j];
//                j--;
//            }
//            arr[j + 1] = temp;
//        }
//
//    }
//    public static void sortLinkedList (DoubleLinkedList list){
//        if (list.getSize() == 0){
//            return;
//        }
//        DoubleNode current = list.getFirst().next;
//        while (current != null){
//            int tmp = (int) current.data;
//            DoubleNode jNode = current.prev;
//            while (jNode != null && (int) jNode.data > tmp){
//                jNode.next.data = jNode.data;
//                jNode = jNode.prev;
//            }
//            System.out.println("---");
//            list.print();
//            if (jNode == null){
//                list.getFirst().data = tmp;
//            } else {
//                jNode.next.data = tmp;
//            }
//            current = current.next;
//
//        }
//    }
//}
////class Main { //forTesting
////    public static void printArr(int [] arr){
////        for (int i =0; i < arr.length; i++){
////            System.out.print(arr[i] + ",");
////        }
////        System.out.println();
////    }
////    public static void main(String[] args) {
////        int [] arr = {88, 43, 2, 34, 5, 3, 2, 9, 11, 93, 49, 58, 38};
////        DoubleLinkedList list = new DoubleLinkedList();
////        for (int i = 0; i < arr.length; i++){
////            list.addLast(arr[i]);
////        }
//////        System.out.println(list.getSize());
//////        list.print();
////        InsertSort.sortLinkedList(list);
//////        list.print();
////        InsertSort.sortArray(arr);
////        printArr(arr);
////    }
////}