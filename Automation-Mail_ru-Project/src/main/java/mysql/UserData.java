package mysql;

import org.apache.log4j.Logger;

import java.sql.*;

public class UserData {

    private String login;
    private String password;
    private String email;
    private String text;
    private Logger logger = Logger.getLogger(UserData.class);

    public UserData() {
        this.fromDataBase();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }

    private void fromDataBase() {
        String url = "jdbc:mysql://localhost:3306/mail?useSSL=false&useUnicode=true&serverTimezone=UTC";
        String user = "root";
        String password = "0305mm83zz";
        String query = "SELECT * FROM mail.maildata ";
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                this.login = rs.getString("login");
                this.password = rs.getString("password");
                this.email = rs.getString("email");
                this.text = rs.getString("text");
            }
            logger.info("get from database");
        } catch (SQLException ex) {
            logger.error("No database connection");
            ex.printStackTrace();
        }
    }
}
