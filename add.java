import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class add implements ActionListener {

    JFrame frame;
    JTextField userField, priceField;
    JSpinner quantityField;
    JLabel userLabel, priceLabel, quantityLabel;
    JButton addButton;

    public add() {

        frame = new JFrame("Add Item");
        frame.getContentPane().setBackground(Color.GREEN);
        userLabel = new JLabel("Item");
        userLabel.setBounds(100, 100, 100, 30);


        userField = new JTextField();
        userField.setBounds(200, 100, 150, 30);

        priceLabel = new JLabel("Price");
        priceLabel.setBounds(100, 150, 100, 30);

        priceField = new JTextField();
        priceField.setBounds(200, 150, 150, 30);

        quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(100, 200, 100, 30);

        quantityField = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        quantityField.setBounds(200, 200, 150, 30);

        addButton = new JButton("Add Item");
        addButton.addActionListener(this);
        addButton.setBounds(150, 270, 120, 35);

        frame.add(userLabel);
        frame.add(priceLabel);
        frame.add(userField);
        frame.add(quantityLabel);
        frame.add(quantityField);
        frame.add(addButton);
        frame.add(priceField);

        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String item = userField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = (int) quantityField.getValue();

        if (!item.isEmpty()) {

        String sql = "INSERT INTO menu_items (name, price, quantity) VALUES (?, ?, ?)";

        try {
        Connection con = DBConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, item);
        pst.setDouble(2, price);
        pst.setInt(3, quantity);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(frame, "Item Added");

        pst.close();
        con.close();

        userField.setText("");
        priceField.setText("");
        quantityField.setValue(1);

        } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(frame, "Database Error");
        }

                } else {

            JOptionPane.showMessageDialog(frame, "Please enter item name");

        }
    }

    public static void main(String[] args) {
        new add();
    }
}
