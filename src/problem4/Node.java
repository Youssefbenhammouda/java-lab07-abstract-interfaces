package problem4;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    ListItem next() {
        return this.rightLink;
    }

    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    ListItem previous() {
        return this.leftLink;
    }

    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }
    @Override
    int compareTo(  ListItem item){
        if (item == null) {
            return 1;
        }
        return ((Comparable<Object>) this.value).compareTo(item.getValue());
    }
}
