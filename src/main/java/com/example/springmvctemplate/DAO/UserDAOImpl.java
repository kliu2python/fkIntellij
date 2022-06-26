package com.example.springmvctemplate.DAO;
import javax.sql.DataSource;
import com.example.springmvctemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int registerUser(User user) {
        String sql = "INSERT INTO user(username, password) VALUES(?,?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    @Override
    public String loginUser(User user) {
        String sql = "SELECT USER_ID FROM USER WHERE iDUser=? AND password=?";
        try {

            String userId = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUserId(), user.getPassword() }, String.class);

            return userId;

        } catch (Exception e) {
            return null;
        }
    }
}
