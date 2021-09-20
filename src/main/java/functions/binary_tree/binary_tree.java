package functions.binary_tree;

public class binary_tree
{
    private  node had;
    class node {
        int data;
        node right;
        node left;
        node(int a)
        {
            data = a;
        }
    }
    void insert(int a){
        node not_found = new node(a);
        search(not_found, had);
    }
    void search(node not_found, node temp){
        if(temp != null) {
            if (not_found.data > temp.data) {
                if (temp.right != null)
                    search(not_found, temp.right);
                else
                    temp.right = not_found;
            } else {
                if (temp.right != null)
                    search(not_found, temp.left);
                else
                    temp.left = not_found;
            }
        }
        else {
            had = not_found;
        }
    }
    String print_left() {
        node temp = had;
        while (temp.left !=null) {
            temp = temp.left;
        }
        return "data:" +temp.data;
    }
    public static void main(String[] args) {
        binary_tree test = new binary_tree();
        test.insert(5);
        test.insert(6);
        test.insert(7);
        test.insert(2);
        test.insert(3);
        test.insert(1);
        System.out.println(test.print_left());
    }
}

