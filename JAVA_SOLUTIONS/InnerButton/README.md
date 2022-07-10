The Java file on this page represents a
complete source file. Your job is to play
compiler and determine whether this file
will compile. If it won't compile, how
would you fix it, and if it does
compile, what would it do?


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class InnerButton {
    JFrame frame;
    JButton b;

    public static void main(String[] args){
        InnerButton gui = new InnerButton();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b = new JButton("A");
        b.addActionListener();
        frame.getContentPane().add(BorderLayout.SOUTH,b);
        frame.setSize(200,100);
        frame.setVisible(true);
    }

    class BListener extends ActionListener{ 
        public void actionPerformed(ActionEvent e){
            if(b.getText().equals("A")){
                b.setText("B");
            }else{
                b.setText("A");
            }
        }
    }
}


Ответь 
Программа Не будет работать если вы обратите внимания можно заметить что класс BListener наследует(extends) функция а не класс чтобы исправить надо использовать "implements" потому чтобы мы хотим имплиментировать функция внутри класс "BListener", затем внутри функция addActionListener() добавим нашу функциональный объект BListener.
Таким образом addActionListener(new BListener).

