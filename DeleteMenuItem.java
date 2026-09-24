import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteMenuItem {

    public static void main(String[] args) {

        int id = 4;

        String sql = "DELETE FROM menu_items WHERE id = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();

            System.out.println("Menu item deleted successfully!");

            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}