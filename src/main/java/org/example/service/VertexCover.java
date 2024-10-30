package org.example.service;

import org.example.dtos.TreeNode;

public class VertexCover {

    public int[] minVertexCover(TreeNode root) {
        int[] result = dfs(root);
        return result;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0}; // {include, exclude}

        int include = 1; // count this node
        int exclude = 0; // do not count this node

        for (TreeNode child : node.children) {
            int[] childCover = dfs(child);
            include += Math.min(childCover[0], childCover[1]);
            exclude += childCover[0]; // must include child if this node is excluded
        }

        return new int[]{include, exclude};
    }


}





