import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * 
 */
public class MiddleOfTheLinkedList {


    /**
     * Definition for singly-linked list.
     */
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        void printList() {
            ListNode node = this;
            while (node != null) {
                System.out.print(node.val);
                if (node.next != null)
                    System.out.print(" -> ");
                else
                    System.out.println();
                node = node.next;
            }
        }
    }


    /**
     * Given the head of a singly linked list, 
     * return the middle node of the linked list.
     * 
     * Using a stack.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 36.2 MB, less than 89.35% of Java online submissions.
     * 
     * Runtime O(n) - Space: O(n)
     */
    static public ListNode middleNode0(ListNode head) {
        
        // **** initialization ****
        Stack<ListNode> stack = new Stack<>();

        // **** traverse the linked list - O(n) ****
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        // **** return middle node ****
        return stack.elementAt(stack.size() / 2);
    }


    /**
     * Given the head of a singly linked list, 
     * return the middle node of the linked list.
     * 
     * Using two pointers.
     * 
     * 36 / 36 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms
     * Memory Usage: 36.7 MB
     * 
     * Runtime : O(n) - Space: O(1)
     */
    static public ListNode middleNode(ListNode head) {

        // **** initialization ****
        ListNode p = head;
        ListNode q = head;

        // **** traverse the list - O(n) ****
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
        }

        // **** return middle node ****
        return q;
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read list node values into int[] ****
        int[] arr = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** close the buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));

        // **** populate the linked list ****
        ListNode head = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (head == null)
                head = new ListNode(arr[i]);
            else
                head = new ListNode(arr[i], head);   
        }
 
        // ???? ????
        System.out.print("main <<< head: ");
        head.printList();

        // **** call the function of interest ****
        ListNode mid = middleNode0(head);

        // **** display the middle node ****
        System.out.print("main <<< output: ");
        mid.printList();

        // **** call the function of interest ****
         mid = middleNode(head);

        // **** display the middle node ****
        System.out.print("main <<< output: ");
        mid.printList();
    }

}