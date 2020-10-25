package tree.model;

import java.util.Vector;

public class Node {
    public String name;
    public Vector<Node> children= new Vector<>();

    public Node(String name) {
        this.name = name;
    }


    public static void preorderTraversal(Node node){
        System.out.println(node.name);
        for(Node p : node.children){
            preorderTraversal(p);
        }
    }

    public static boolean keepChild(Node node) {

        if(node.name.equals("Unavailable")){
            return false;
        }else{

            Vector<Node> updatedChildren = new Vector<>();
            for(Node p : node.children){
                if(keepChild(p)){
                    updatedChildren.add(p);
                }
            }
            node.children = updatedChildren;
            return true;
        }

    }



}
