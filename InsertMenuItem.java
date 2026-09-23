import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertMenuItem {

    public static void main(String[] args) {

        String name = "Burger";
        double price = 120.00;
        int quantity = 10;

        String sql = "INSERT INTO menu_items (name, price, quantity) VALUES (?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, name);
            pst.setDouble(2, price);
            pst.setInt(3, quantity);

            pst.executeUpdate();

            System.out.println("Menu item added successfully!");

            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}