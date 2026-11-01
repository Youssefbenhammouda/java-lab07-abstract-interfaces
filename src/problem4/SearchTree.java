package problem4;

public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
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

        while (true) {
            int c = current.compareTo(item);
            if (c == 0) return false;
            if (c < 0) {
                if (current.next() == null) {
                    current.setNext(item);
                    return true;
                }
                current = current.next();
                continue;
            }

            if (current.previous() == null) {
                current.setPrevious(item);
                return true;
            }
            current = current.previous();


        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (root == null) return false;
        ListItem parent = null;
        ListItem child = root;
        while (child != null) {
            int c = child.compareTo(item);
            if (c == 0) {
                performRemoval(child, parent);
                return true;
            }
            parent = child;
            if (c < 0)
                child = child.next();
            else child = child.previous();

        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() == null || item.previous() == null) {
            ListItem newChild = item.next() != null ? item.next() : item.previous();
            if (parent != null) {
                if (parent.next() == item) parent.setNext(newChild);
                else parent.setPrevious(newChild);
            }else {
                root=newChild;
            }

            return;
        }
        ListItem minParent = item;
        ListItem min = item.next();
        while (min.previous() != null) {
            minParent = min;
            min = min.previous();
        }
        // foudnd min
        if(minParent.next()==min){
            minParent.setNext(min.next());
        }else {
            minParent.setPrevious(min.next());
        }
        min.setNext(item.next());
        min.setPrevious(item.previous());
        if(parent!=null){
            if(parent.next()==item){
                parent.setNext(min);
            }else {
                parent.setPrevious(min);
            }
        }
        else root = min;


    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
