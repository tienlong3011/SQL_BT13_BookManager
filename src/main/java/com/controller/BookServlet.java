package com.controller;

import com.bookService.BookService;
import com.bookService.IBookService;
import com.categoryService.CategoryService;
import com.categoryService.ICategoryService;
import com.model.Book;
import com.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/books")
public class BookServlet extends HttpServlet {
    private final IBookService bookService = new BookService();
    private final ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteBook(request,response);
                break;
            default:
                listBook(request, response);
                break;
        }
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
        try {
            bookService.delete(id);
            response.sendRedirect("/books");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id_book = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.selectById(id_book);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book/edit.jsp");
        request.setAttribute("book", book);
        request.setAttribute("category", categoryService.selectAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/create.jsp");
        request.setAttribute("category", categoryService.selectAll());
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response) {
        List<Book> bookList = bookService.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/list.jsp");
        request.setAttribute("bookList", bookList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createBook(request, response);
                break;
            case "edit":
                editBook(request, response);
                break;
        }
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameBook = request.getParameter("nameBook");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category"));
        Category category = categoryService.selectById(category_id);
        Book book = new Book(id,nameBook, price, description, category);
        try {
            bookService.update(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/edit.jsp");
        request.setAttribute("book",book);
        request.setAttribute("category",categoryService.selectAll());
        request.setAttribute("message","Successfully edited!");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryService.selectAll();
        String nameBook = request.getParameter("nameBook");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int category_id = Integer.parseInt(request.getParameter("category"));
        Category category = categoryService.selectById(category_id);
        Book book = new Book(nameBook, price, description, category);
        try {
            bookService.insert(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/create.jsp");
        request.setAttribute("category", categoryList);
        request.setAttribute("message", "Successful new creation!");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }
}
