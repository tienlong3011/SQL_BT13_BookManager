package com.categoryService;

import com.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/book_manager?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456";

    private static final String INSERT_CATEGORY_SQL = "INSERT INTO category (nameCategory,description) VALUES (?, ?)";
    private static final String SELECT_CATEGORY_BY_ID = "select * from category where id =?";
    private static final String SELECT_ALL_CATEGORY = "select * from category";
    private static final String DELETE_CATEGORY_SQL = "delete from category where id = ?";
    private static final String UPDATE_CATEGORY_SQL = "update category set name = ?,description = ? where id = ?";

    public static Connection getConnection() {
        Connection connection = null;
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    @Override
    public void insert(Category category) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getNameCategory());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Category selectById(int id) {
        Category category = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nameCategory = resultSet.getString("nameCategory");
                String description = resultSet.getString("description");
                category = new Category(id, nameCategory, description);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> selectAll() {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");
                String description = resultSet.getString("description");
                categoryList.add(new Category(id, nameCategory, description));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY_SQL)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean update(Category category) {
        boolean rowUpdate = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY_SQL)) {
            preparedStatement.setString(1, category.getNameCategory());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setInt(3,category.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdate;
    }
}
