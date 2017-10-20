import java.sql.*;
import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads  {
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {

            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @Override
    public List<Ad> all() {
        String selectQuery = "SELECT * FROM adlister_db.ads";
        List<Ad> ads = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                ads.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        Long id = 0L;

        try {
            Statement stmt = connection.createStatement();

            String selectQuery = String.format(
                    "INSERT INTO ads (id, user_id, title, description) VALUES ('%s', '%s', '%s', '%s')",
                    ad.getId(),
                    ad.getUserId(),
                    ad.getTitle(),
                    ad.getDescription()
            );

            stmt.executeUpdate(selectQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = stmt.getGeneratedKeys();

            if (resultSet.next()) {
                id = resultSet.getLong(1);
                return id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
