package com.mziuri.Servlets;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.Classes.AidClass;
import com.mziuri.Classes.Product;
import com.mziuri.Service.DatabaseManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;

@WebServlet("/store/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("productName");
//        System.out.println(req.getParameter("productName"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String password = req.getParameter("password");

        DatabaseManager databaseManager = new DatabaseManager();
//        ObjectMapper mapper = new ObjectMapper();
//        AidClass aidClass = null;
//        try {
//            aidClass = mapper.readValue(new File("src/main/resources/storage.json"), new TypeReference<AidClass>() {
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if ("asd".equals(password) && databaseManager.nameCheck(name)) {
            databaseManager.updateProductAmount(name, amount);
        } else {
            resp.setStatus(405);
        }

    }



}
