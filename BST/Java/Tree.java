package tree;

/**
 * @Abdulrahman
 */
public class Tree {


    public static void main(String[] args) {
    
    Binary_Search_Tree T = new Binary_Search_Tree();
    
    T.add(30);
    T.add(60);
    T.add(20);
    T.add(40);
    T.add(50);
    T.add(70);
    T.add(10);
    T.remove(70);
    
    T.display();
    System.out.println("\nMax: "+T.Max());
    System.out.println(T.Search(10));
    System.out.println(T.Search2(0));
    }    
}

