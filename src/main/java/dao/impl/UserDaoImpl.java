package dao.impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> getAll() {
        String sql="select * from users";
        List<User> users=jdbcTemplate.query(sql,new RowMapper<User>(){

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getString("password"));
                user.setUsername(resultSet.getString("username"));
                return user;
            }
        });
        return users;
    }

    @Override
    public void saveUser(User user) {
        String sql="insert into users values(?,?,?)";
        jdbcTemplate.update(sql,user.getId(),user.getUsername(),user.getPassword());
    }

    @Override
    public User login(String username, String password) {
        User user;
        String sql="select * from users where username=? and password=?";
        try{
            user=jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user1=new User();
                    String username=resultSet.getString("username");
                    String password=resultSet.getString("password");
                    user1.setUsername(username);
                    user1.setPassword(password);
                    return user1;
                }
            },username,password);
        }catch (Exception e){
            return null;
        }
        return user;
    }
}
