package problem4;

public class Main {
    public static void main(String[] args) {
        String data = "5 7 3 9 8 2 1 0 4 6";

        System.out.println("===== MyLinkedList =====");
        test(new MyLinkedList(null), data);

        System.out.println();
        System.out.println("===== SearchTree =====");
        test(new SearchTree(null), data);
    }

    private static void test(NodeList list, String data) {
        for (String s : data.split(" ")) {
            list.addItem(new Node(s));
        }
        System.out.println("After adding " + data + ":");
        list.traverse(list.getRoot());

        System.out.println("Add duplicate 5: " + list.addItem(new Node("5")));

        String[] toRemove = {"3", "5", "0", "9", "4", "42"};
        for (String s : toRemove) {
            System.out.println("Remove " + s + ": " + list.removeItem(new Node(s)));
        }
        System.out.println("After removals:");
        list.traverse(list.getRoot());

        for (String s : "1 2 6 7 8".split(" ")) {
            list.removeItem(new Node(s));
        }
        System.out.println("After removing everything:");
        list.traverse(list.getRoot());
    }
}
