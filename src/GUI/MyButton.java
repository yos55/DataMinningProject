/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Algo.Graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 *
 * @author amichay
 */
@SuppressWarnings("serial")
public class MyButton extends JButton implements ActionListener {

    private int me;
    private int myFriend;
    private String[] attributes;
    Graph graph;
    Window window;

    public MyButton(int indexX, int indexY, Window window, Graph graph) {
        super();
        this.me = indexX;
        this.myFriend = indexY;
        this.window = window;
        this.graph = graph;
        setText("(" + me + ", " + myFriend + ")");
        Font font = new Font("Tahoma", 1 , 12);
        setFont(font);
        this.addActionListener(this);
        //System.out.println(Arrays.toString(graph.getAttributes(indexX, indexY)));
        
    }

    public int getMe() {
        return me;
    }

    public int getMyFriend() {
        return myFriend;
    }

    public void setMe(int me) {
        this.me = me;
    }

    public void setMyFriend(int myFriend) {
        this.myFriend = myFriend;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.getIndexField().setText("("+me+", "+myFriend+")");
        window.getIndicationText().setFont(new Font("David",1,18));
        window.getIndicationText().setText("");
        attributes = graph.getAttributes(me, myFriend);
        for (int i = 0; i < attributes.length; i++) {
            window.getIndicationText().append(i+1+") " + attributes[i] + ". \n");
        }     
        setBackground(Color.YELLOW);
    }

}
