package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.User;

public class UserDaoImpl implements UserDao {
    private DaoFactory daoFactory;

    UserDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void add(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO users(firstName, lastName, login, password) VALUES(?, ?, ?, ?);");

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            // TODO: handle exception
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        Statement statement = null;
        ResultSet res = null;

        try {
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            res = statement.executeQuery("SELECT id, firstName, lastName, login FROM users;");

            while (res.next()) {
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");
                int id = res.getInt("id");

                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setLogin(login);
                user.setId(id);

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User get(int id) {

        Connection connection = null;
        ResultSet res = null;
        PreparedStatement preparedStatement = null;
        User user = new User();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT firstName, lastName, login FROM users WHERE id=?;");
            preparedStatement.setInt(1, id);
            res = preparedStatement.executeQuery();
            if (res.next()) {
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String login = res.getString("login");

                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setLogin(login);
                user.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE users SET firstName=?, lastName=?, login=?, password=? WHERE id=?;");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?;");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
