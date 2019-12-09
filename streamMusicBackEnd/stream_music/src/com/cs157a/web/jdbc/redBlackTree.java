package com.cs157a.web.jdbc;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A red-black tree is a binary search tree with one extra bit of storage per node: its color,
 * which can be either RED or BLACK. By constraining the node colors on any simple path from the root to a leaf,
 * red-black trees ensure that no such path is more than twice as long as any other,
 * so that the tree is approximately balanced.
 */
public class redBlackTree {

    private redBlackSongNode root;
    private redBlackSongNode nil;

//    protected Set<String> rblist;
    protected ArrayList<redBlackSongNode> redBlackNodeslist;

    public redBlackTree(){
//        nil = new redBlackSongNode("Tom", 999999999,"BLACK");
        nil = new redBlackSongNode(45, "Red Black Tree", 17, 5, 7, "2:08", "resource/music/Intro.mp3", 5, 5, "BLACK");
        setRoot(getNil());
//        rblist = new LinkedHashSet<>();
        redBlackNodeslist = new ArrayList<>();
    }

    public redBlackSongNode getNil(){
        return nil;
    }

    public void setRoot(redBlackSongNode root){
        this.root = root;
    }

    public redBlackSongNode getRoot() {
        return root;
    }

    public void Left_Rotate(redBlackSongNode x){
        redBlackSongNode y = x.getRight();
        x.setRight(y.getLeft());
        if(y.getLeft() != getNil()){
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == getNil()){
            setRoot(y);
        }else if(x == x.getParent().getLeft()){
            x.getParent().setLeft(y);
        }else{
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    public void Right_Rotate(redBlackSongNode x){
        redBlackSongNode y = x.getLeft();
        x.setLeft(y.getRight());
        if(y.getRight() != nil){
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == nil){
           setRoot(y);
        }else if(x == x.getParent().getRight()){
            x.getParent().setRight(y);
        }else{
            x.getParent().setLeft(y);
        }
        y.setRight(x);
        x.setParent(y);
    }

    public void RB_Insert(redBlackSongNode z){
        redBlackSongNode y = getNil();
        redBlackSongNode x = getRoot();
        while(x != getNil()){
            y = x;
            if(z.getArtist() < x.getArtist()){
                x = x.getLeft();
            }else{
                x = x.getRight();
            }
        }
        z.setParent(y);
        if(y == getNil()){
            setRoot(z);
        }else if(z.getArtist() < y.getArtist()){
            y.setLeft(z);
        }else{
            y.setRight(z);
        }
        z.setLeft(getNil());
        z.setRight(getNil());
        z.setColor("RED");
        RB_Insert_Fixup(z);
    }

    public void RB_Insert_Fixup(redBlackSongNode z){

        while(z.getParent().getColor().equals("RED")){
            if(z.getParent() == z.getParent().getParent().getLeft()){
                //set the uncle to y, its grandparent right child
                redBlackSongNode y = z.getParent().getParent().getRight();

                if(y.getColor().equals("RED")){
                    z.getParent().setColor("BLACK");            //case 1
                    y.setColor("BLACK");                        //case 1
                    z.getParent().getParent().setColor("RED");  //case 1
                    z = z.getParent().getParent();              //case 1
                }else{
                    if(z == z.getParent().getRight()){
                        z = z.getParent();                      //case 2
                        Left_Rotate(z);                         //case 2
                    }
                    z.getParent().setColor("BLACK");            //case 3
                    z.getParent().getParent().setColor("RED");  //case 3
                    Right_Rotate(z.getParent().getParent());    //case 3
                }
            }else if(z.getParent() == z.getParent().getParent().getRight()){
                redBlackSongNode y = z.getParent().getParent().getLeft();
                if(y.getColor().equals("RED")){
                    z.getParent().setColor("BLACK");                //case 1
                    y.setColor("BLACK");                            //case 1
                    z.getParent().getParent().setColor("RED");      //case 1
                    z = z.getParent().getParent();                  //case 1
                }else{
                    if(z == z.getParent().getLeft()){
                        z = z.getParent();                          //case 2
                        Right_Rotate(z);                            //case 2
                    }
                    z.getParent().setColor("BLACK");                //case 3
                    z.getParent().getParent().setColor("RED");      //case 3
                    Left_Rotate(z.getParent().getParent());         //case 3
                }
            }
        }
        root.setColor("BLACK");
    }

    public void RB_Transplant(redBlackSongNode u, redBlackSongNode v){
        if(u.getParent() == getNil()){
            setRoot(v);
        }else if(u == u.getParent().getLeft()){
            u.getParent().setLeft(v);
        }else{
            u.getParent().setRight(v);
        }
        v.setParent(u.getParent());
    }

    public void RB_Delete(redBlackSongNode z){
        redBlackSongNode y = z;
        redBlackSongNode x;

        String y_original_color = y.getColor();

        if(z.getLeft() == getNil()){
            x = z.getRight();
            RB_Transplant(z, z.getRight());
        }else if(z.getRight() == getNil()){
            x = z.getLeft();
            RB_Transplant(z, z.getLeft());
        }else{
            y = RBTree_minimum(z.getRight());
            y_original_color = y.getColor();
            x = y.getRight();
            if(y.getParent() == z){
                x.setParent(y);
            }else{
                RB_Transplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            RB_Transplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
            y.setColor(z.getColor());
        }
        if(y_original_color.equals("BLACK")){
            RB_Delete_Fixup(x);
        }
    }

    public void RB_Delete_Fixup(redBlackSongNode x){
        while(x != root && x.getColor().equals("BLACK")){
            if(x == x.getParent().getLeft()) {
                redBlackSongNode w = x.getParent().getRight();
                if(w.getColor().equals("RED")){
                    w.setColor("BLACK");                        //Case 1
                    x.getParent().setColor("RED");              //Case 1
                    Left_Rotate(x.getParent());                 //Case 1
                    w = x.getParent().getRight();               //Case 1
                }
                if(w.getLeft().getColor().equals("BLACK") && w.getRight().getColor().equals("BLACK")){
                    w.setColor("RED");                          //Case 2
                    x = x.getParent();                          //Case 2
                }
                else {
                    if(w.getRight().getColor().equals("BLACK")){
                        w.getLeft().setColor("BLACK");          //Case 3
                        w.setColor("RED");                      //Case 3
                        Right_Rotate(w);                        //Case 3
                        w = x.getParent().getRight();           //Case 3
                    }
                    w.setColor(x.getParent().getColor());       //Case 4
                    x.getParent().setColor("BLACK");            //Case 4
                    w.getRight().setColor("BLACK");             //Case 4
                    Left_Rotate(x.getParent());                 //Case 4
                    setRoot(x);                             //Case 4
                }
            }
            else {
                redBlackSongNode w = x.getParent().getLeft();
                if(w.getColor().equals("RED")){
                    w.setColor("BLACK");                        //Case 1
                    x.getParent().setColor("RED");              //Case 1
                    Right_Rotate(x.getParent());                //Case 1
                    w = x.getParent().getLeft();                //Case 1
                }
                if(w.getRight().getColor().equals("BLACK") && w.getLeft().getColor().equals("BLACK")){
                    w.setColor("RED");                          //Case 2
                    x = x.getParent();                          //Case 2
                }
                else {
                    if(w.getLeft().getColor().equals("BLACK")){
                        w.getRight().setColor("BLACK");         //Case 3
                        w.setColor("RED");                      //Case 3
                        Left_Rotate(w);                         //Case 3
                        w = x.getParent().getLeft();            //Case 4
                    }
                    w.setColor(x.getParent().getColor());       //Case 4
                    x.getParent().setColor("BLACK");            //Case 4
                    w.getLeft().setColor("BLACK");              //Case 4
                    Right_Rotate(x.getParent());                //Case 4
                    setRoot(x);                               //Case 4
                }
            }
        }
        x.setColor("BLACK");
    }

    public redBlackSongNode RBTree_minimum(redBlackSongNode min){
        while(min.getLeft() != nil){
            min = min.getLeft();
        }
        return min;
    }

    /* Tree search method */
    public redBlackSongNode RB_search(redBlackSongNode temp, int key) {

        /* return the node if the key match */
        if(temp == nil || key == temp.getArtist())
            return temp;
        if(key < temp.getArtist())
            return RB_search(temp.getLeft(), key);
        else
            return RB_search(temp.getRight(), key);
    }

    public void Inorder_RBT_Walk(redBlackSongNode x){
        if(x != null){
            Inorder_RBT_Walk(x.getLeft());
//            rblist.add(x.toString());
            redBlackNodeslist.add(x);
            Inorder_RBT_Walk(x.getRight());
        }
    }
}






























