import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Home implements ActionListener {
    JFrame frame;
    JButton addButton;
    public Home(){
        frame=new JFrame("Restaurant Management-Home");
        frame.getContentPane().setBackground(Color.blue);
        JLabel title=new JLabel("Welcome to Our Restaurant");
        title.setBounds(80,50,300,30);
        addButton= new JButton("Add");
        addButton.setBounds(100,120,100,40);
        addButton.addActionListener(this);
    
       
        JButton updateButton= new JButton("Update");
        updateButton.setBounds(220,120,100,40);
         JButton deleteButton= new JButton("Delete");
        deleteButton.setBounds(100,180,100,40);
         JButton searchButton= new JButton("Search");
        searchButton.setBounds(220,180,100,40);
        frame.add(title);
        frame.add(addButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(searchButton);
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
     @Override 
        public void
        actionPerformed(ActionEvent e){
            if(e.getSource() == addButton)
            {
                new add();
                frame.dispose();
            }
        }
}
