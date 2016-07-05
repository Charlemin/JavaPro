package com.plus;

import org.hamcrest.core.Is;

/**
 * Created by Eric on 2016/7/5.
 */
public class IsSubTree {
    private int val;
    private IsSubTree leftchild,rightchild;
    public IsSubTree(int val){
        this.val = val;
        this.leftchild = null;
        this.rightchild = null;
    }

    public Boolean isPart(IsSubTree node1,IsSubTree node2){
        if(node1 == null)
            return false;
        if(node2 == null)
            return true;
        if(node1.val != node2.val)
            return false;
        return isPart(node1.leftchild,node2.leftchild) && isPart(node1.rightchild,node2.rightchild);
    }

    public Boolean isPartTree(IsSubTree node1,IsSubTree node2){
        Boolean result = false;
        if(node1 != null && node2 != null){
            if(node1.val == node2.val)
                result = isPart(node1,node2);
            if(!result)
                result = isPartTree(node1.leftchild,node2);
            if(!result)
                result = isPartTree(node1.rightchild,node2);
        }
        return result;
    }
}
