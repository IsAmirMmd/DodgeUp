import java.sql.*;

public class SQL {
    public static void addToSQL(int score){
        String url = "jdbc:mysql://localhost:3306/dodgeScore";
        String username = "root";
        String password = "";
        int maxScore = 0;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM score");
            int max = 0;
            while (resultSet.next()) {
                if (resultSet.getInt(2)>maxScore){
                    maxScore = resultSet.getInt(2);
                }
                max = resultSet.getInt(1);
            }
            max += 1;
            String sql = "INSERT INTO `score` (`id`, `score`) VALUES (? , ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, max);
            if (score>maxScore) {
                DodgeUp.HighScore = true;
            }
            stmt.setInt(2, score);
            stmt.executeUpdate();

            stmt.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
