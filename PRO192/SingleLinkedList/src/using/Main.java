package using;

import data.LinkedList;
import java.util.Scanner;

/**
 * 1.addHead 2.addTail 3.insert 4.traverse 5.delHead 6.delTail 7.delAfter 8.del
 * 9.search 10.count 11.remove 12.sort 13.del 14.toArray 15.merge 16.addAfter
 * 17.addTail 18.max 19.min 20.sum 21.avg 22.isSorted 23. addSorted 24.reverse
 * 25. equalsIgnoreOrder
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int choice = sc.nextInt();
        int n, x;
        n = sc.nextInt();
        switch (choice) {
            case 1: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                x = sc.nextInt();
                System.out.print("1. Add " + x + " before the head of " + n + "-element list: ");
                list.traverse();
                list.addHead(x);
                list.traverse();
                break;
            case 2: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                x = sc.nextInt();
                System.out.print("2. Add " + x + " after the tail of " + n + "-element list: ");
                list.traverse();
                list.addTail(x);
                list.traverse();

                break;

            case 3: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                int t = sc.nextInt();
                x = sc.nextInt();

                System.out.print("3. Insert an element " + x + " after the element " + t + " in the " + n + "-element list ");
                list.traverse();
                list.addAfter(t, x);
                list.traverse();

                break;
            case 4: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                System.out.print("4. Traverse the " + n + "-element list: ");
                list.traverse();

                break;

            case 5: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }

                System.out.print("5. Delete the head of the " + n + "-element list: ");
                list.traverse();
                list.delHead();
                list.traverse();

                break;

            case 6: //ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }

                System.out.print("6. Delete the tail of the " + n + "-element list: ");
                list.traverse();
                list.delTail();
                list.traverse();
                break;

            case 7: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                x = sc.nextInt();
                System.out.print("7. Delete the element after the element " + x + " of the " + n + "-element list: ");
                list.traverse();
                list.delAfter(x);
                list.traverse();
                break;

            case 8: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                x = sc.nextInt();
                System.out.print("8. Delete the element " + x + " int the " + n + "-element list: ");
                list.traverse();
                list.del(x);
                list.traverse();
                break;

            case 9: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                x = sc.nextInt();
                System.out.print("9. Search the element " + x + " in the " + n + "-element list: ");
                list.traverse();
                System.out.println(x);
                break;
            case 10: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }

                System.out.print("10. Count the number of the elements of the " + n + "-element list: ");
                list.traverse();
                System.out.println(n);
                break;
            case 11: // ok
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                x = sc.nextInt();
                System.out.print("11. Delete the  " + x + "rd element in the " + n + "-element list: ");
                list.traverse();
                list.remove(x - 1);
                list.traverse();

                break;
            case 12:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }

                System.out.print("12. Sort in accending order the " + n + "-node list: ");
                list.traverse();
                list.sort();
                list.traverse();
                break;
            case 13:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                x = sc.nextInt();
                System.out.print("13. Delete the element " + x + " in the " + n + "-node list: ");
                list.traverse();
                list.del(x);
                list.traverse();
                break;
            case 14:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }

                System.out.print("14. create and return array containing info of all nodes in the " + n + "-node list.\n");
                list.traverse();
                int[] a = list.toArray();

            case 15:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                LinkedList list2 = new LinkedList();
                int n2 = sc.nextInt();
                for (int i = 1; i <= n2; i++) {
                    list2.addTail(sc.nextInt());
                }
                LinkedList l = list.merge(list, list2);
                System.out.print("15. Merge two ordered singly linked lists of integers into one ordered list: " + n + "-node list = ");
                list.traverse(1);
                System.out.print("; " + n2 + "-node list: ");
                list2.traverse();
                l.traverse();
                break;

            case 16:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                t = sc.nextInt();
                x = sc.nextInt();

                System.out.print("16. add a node with value " + t + " before the node " + x + " in the " + n + "-node list: ");
                list.traverse(1);
                System.out.println(".");
                list.addBefore(x, t);
                list.traverse();

                break;
            case 17:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                list2 = new LinkedList();
                n2 = sc.nextInt();
                for (int i = 1; i <= n2; i++) {
                    list2.addTail(sc.nextInt());
                }
                System.out.print("17. Attach a singly linked list of " + n2 + " elements ");
                list2.traverse(1);
                System.out.print(" to the end of another singly linked list of " + n + " nodes: ");
                list.traverse();
                list.addTail(list2);
                list.traverse();
                break;

            case 18:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                System.out.print("18. find and return the maximum value in the " + n + "-node list: ");
                list.traverse();
                System.out.print(list.max());
                break;
            case 19:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                System.out.print("19. find and return the minimum value in the " + n + "-node list: ");
                list.traverse();
                System.out.print(list.min());
                break;
            case 20:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                System.out.print("20. return the sum of all values in the " + n + "-node list: ");
                list.traverse();
                System.out.print(list.sum());
                break;
            case 21:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                System.out.print("21. return the average of all values in the " + n + "-node list: ");
                list.traverse();
                System.out.print(String.format("%.2f", list.avg()));
                break;
            case 22:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                System.out.print("22. check and return true if the " + n + "-node list: ");
                list.traverse(1);
                System.out.print(" is sorted, return false if the list is not sorted.\n");
                System.out.print(list.isSorted());
                break;
            case 23:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                x = sc.nextInt();
                System.out.print("23. sort the 19-node list: ");
                list.traverse(1);
                System.out.println(" then insert a node with value " + x + " into the sorted list so that the new list is a sorted list");
                list.sort();
                list.traverse();
                list.addSorted(x);
                list.traverse();
                break;
            case 24:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                System.out.print("24. Reverse the singly linked list of 20 nodes: ");
                list.traverse();
                list.reverse();
                list.traverse();
                break;
            case 25:
                for (int i = 1; i <= n; i++) {
                    list.addTail(sc.nextInt());
                }
                list2 = new LinkedList();
                n2 = sc.nextInt();
                for (int i = 1; i <= n2; i++) {
                    list2.addTail(sc.nextInt());
                }

                System.out.print("25. Check whether two singly linked list have the same contents: 1st list of " + n + " elements: ");
                list.traverse(1);
                System.out.print("; 2nd list of " + n2 + " elements: ");
                list2.traverse();
                if (list.equalsIgnoreOrder(list2)) {
                    System.out.print("yes");
                } else {
                    System.out.print("no");

                }
                break;
            default:
        }
    }
}
