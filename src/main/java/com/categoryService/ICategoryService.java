package com.categoryService;

import com.IService;
import com.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService extends IService<Category> {
    @Override
    void insert(Category category) throws SQLException;

    @Override
    Category selectById(int id);

    @Override
    List<Category> selectAll();

    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Category category) throws SQLException;
}
