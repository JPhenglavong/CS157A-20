package com.cs157a.web.jdbc;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A class that  we can use this binary search tree both as a dictionary and as a priority queue.
 */
public class binarySearchTree {

    /* Create a Root song for this binary search Tree */
    private song root;
    protected ArrayList<song> songlist;

    /* default constructor */
    public binarySearchTree(){
        songlist = new ArrayList<>();
    }

    public void setRoot(song root){
        this.root = root;
    }

    public song getRoot(){
        return root;
    }

    //Insert a name to the Retirement BST based on his/her SSN.
    public void Tree_Insert(song z){
        song y = null;
        song x = this.root;
        while(x != null){
            y = x;
            if(z.getGenre() < x.getGenre()){
                x = x.getLeft();
            }else{
                x = x.getRight();
            }
        }
        z.setParent(y);
        if(y == null){
            this.setRoot(z);
        }else if(z.getGenre() < y.getGenre()){
            y.setLeft(z);
        }else{
            y.setRight(z);
        }
    }

    /* subroutine TRANSPLANT */
    public void Transplant(song u, song v){
        if(u.getParent() == null){
            this.root = v;
        }else if(u == u.getParent().getLeft()){
            u.getParent().setLeft(v);
        }else{
            u.getParent().setRight(v);
        }
        if(v != null){
            v.setParent(u.getParent());
        }
    }

    //Minimum
    public song BST_Minimum(song x){
        while(x.getLeft() != null){
            x = x.getLeft();
        }
        return x;
    }

    public song BST_Maximum(song x){
        while(x.getRight() != null){
            x = x.getRight();
        }
        return x;
    }

    public void BST_Delete(song z){
        if(z.getLeft() == null){
            Transplant(z, z.getRight());
        }else if(z.getRight() == null){
            Transplant(z, z.getLeft());
        }else{
            song y = BST_Minimum(z.getRight());
            if(y.getParent() != z){
                Transplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            Transplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
        }
    }

    public void Inorder_BST_Walk(song x){
        if(x != null){
            Inorder_BST_Walk(x.getLeft());
            songlist.add(x);
            Inorder_BST_Walk(x.getRight());
        }
    }

    public song BST_Search(song x, int k){
        if(x == null || k == x.getGenre()){
            return x;
        }
        if(k < x.getGenre()){
            return BST_Search(x.getLeft(), k);
        }else{
            return BST_Search(x.getRight(), k);
        }

    }
}

