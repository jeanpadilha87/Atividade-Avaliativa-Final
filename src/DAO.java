import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private static final String URL  = "jdbc:mysql://localhost:3306/receitas";
    private static final String USER = "root";
    private static final String PASS = ""; // coloque a senha do seu MySQL aqui

    public static Connection getConnection() throws Exception {
        // Driver novo do MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
