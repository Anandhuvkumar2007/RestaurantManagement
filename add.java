import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class add implements ActionListener {

    JFrame frame;
    JTextField userField;
    JSpinner quantityField;
    JLabel userLabel, quantityLabel;
    JButton addButton;

    public add() {

        frame = new JFrame("Add Item");
        frame.getContentPane().setBackground(Color.GREEN);
        userLabel = new JLabel("Item");
        userLabel.setBounds(100, 100, 100, 30);


        userField = new JTextField();
        userField.setBounds(200, 100, 150, 30);

        quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(100, 150, 100, 30);

        quantityField = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        quantityField.setBounds(200, 150, 150, 30);

        addButton = new JButton("Add Item");
        addButton.setBounds(150, 220, 120, 35);
        addButton.addActionListener(this);

        frame.add(userLabel);
        frame.add(userField);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(addButton);

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String item = userField.getText();
        int quantity = (int) quantityField.getValue();

        if (!item.isEmpty()) {

            JOptionPane.showMessageDialog(frame, "Item Added");
            userField.setText("");
            quantityField.setValue(1);

        } else {

            JOptionPane.showMessageDialog(frame, "Please enter item name");

        }
    }
}
