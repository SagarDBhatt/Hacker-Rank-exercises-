/**
 * LinkedList is the data structure which implements the "List" Interface. LinkedList structure has the Nodes. Each
 * node has 2 values. i. Data ii. Node reference of the next Node.
 * For eg: below is the linkedList:
 *
 * 1->2->3->4->5->null.
 *
 * Here, each data (1,2,3..) has the node reference to the next node.
 *
 * INTERVIEW QUESTION:
 * Q) WHat is the difference between ArrayList and LinkedList. When do we use the datastructures.
 * A) The ArrayList has the collection of the data like [1,2,3,4]. Each element is referred using index such as
 * Array[0] = 1, Array[1] = 2 ect. Whereas LinkedList has Data and Node reference of the next element. (Node reference
 * is the memory address of the object).
 *
 * When we need to add or remove elements from the collections then LinkedList is faster as it only needs to updatge
 * the link with the new element. Whereas if we need to read the data then ArrayList is faster.
 */

package ThreeMonthPreparationKit.October_2022.Week7;

public class Ex6_ReverseLinkedList {
    public static void main(String[] args) {
        System.out.println(ResultReverseLinkedList.reverse(new SinglyLinkedListNode(1)));
    }//END OF MAIN
}//END OF CLASS

class ResultReverseLinkedList {

    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        //head = llist
        if (llist == null) {
            return null;
        }

        //single node
        if (llist.next == null) {
            return llist;
        }

        SinglyLinkedListNode prevNode = null;
        SinglyLinkedListNode currNode = llist;

        while (currNode != null) {
            SinglyLinkedListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        llist = prevNode;
        return llist;
    }

}

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}