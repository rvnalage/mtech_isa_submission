package org.example;

import org.example.dtos.TreeNode;
import org.example.service.VertexCover;

public class VertexCoverApplication {

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        root.children.add(child1);
        root.children.add(child2);

        VertexCover vc = new VertexCover();
        int[] result = vc.minVertexCover(root);
        System.out.println("Minimum Vertex Cover Size: " + Math.min(result[0], result[1]));
    }

}





