import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateMenuItem {

    public static void main(String[] args) {

        int id = 1;
        double newPrice = 150.00;
        int newQuantity = 20;

        String sql = "UPDATE menu_items SET price = ?, quantity = ? WHERE id = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setDouble(1, newPrice);
            pst.setInt(2, newQuantity);
            pst.setInt(3, id);

            pst.executeUpdate();

            System.out.println("Menu item updated successfully!");

            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}