package tree;

import tree.model.Node;

public class Main {
    public static void main(String[] args) {
        Node root = new Node("John");
        populate(root);
        Node.preorderTraversal(root);
        System.out.println();
        Node.keepChild(root);
        Node.preorderTraversal(root);

    }

    public static void populate(Node root){

        /* Let's create this tree
         *                          John
         *       /                   |          \
         *   Jasmine            Unavailable    Johanna
         *     /     \              /  \
         *    Jay  Unavailable   Jack  Jeremy
         */
        root.children.add(new Node("Jasmine"));
        root.children.add(new Node("Unavailable"));
        root.children.add(new Node("Johanna"));
        root.children.get(0).children.add(new Node("Jay"));
        root.children.get(0).children.add(new Node("Unavailable"));
        root.children.get(1).children.add(new Node("Jack"));
        root.children.get(1).children.add(new Node("Jeremy"));

    }

}
