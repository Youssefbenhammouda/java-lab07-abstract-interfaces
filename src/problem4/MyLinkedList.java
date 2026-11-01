package problem4;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (root == null) {
            root = item;
            return true;
        }
        ListItem current = root;
        ListItem prev = null;

        while (current!=null){

            if(current.compareTo(item)==0) return false;
            if(current.compareTo(item)>0) break;


            prev=current;
            current=current.next();
        }
        if(prev!=null){
            prev.setNext(item);
            item.setPrevious(prev);
        }
        else {
            item.setNext(root);
            root.setPrevious(item);
            root = item;
        }
        if(current!=null){
            current.setPrevious(item);
            item.setNext(current);
        }else{
            prev.setNext(item);
            item.setPrevious(prev);
        }


        return true;
    }

    @Override
    public boolean removeItem(ListItem item) {
        ListItem current = root;
        while (current!=null){

            if(current.compareTo(item)==0){
                ListItem next = current.next();
                ListItem prev = current.previous();
                if(next!=null)next.setPrevious(prev);
                if(prev!=null)prev.setNext(next);
                if (current==root)root=next;
                return true;
            }
            current=current.next();
        }
        return false;

    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }
        while (root != null) {
            System.out.println(root.getValue());
            root = root.next();
        }
    }
}
