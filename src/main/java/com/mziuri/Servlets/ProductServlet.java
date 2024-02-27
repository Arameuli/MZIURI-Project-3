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
import java.util.List;

import org.json.JSONObject;

@WebServlet("/store/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");
        DatabaseManager databaseManager = new DatabaseManager();
        List<Product> list = databaseManager.read();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProd_name().equals(productName)) {
                int amount = list.get(i).getProd_amount();
                float price = list.get(i).getProd_price();
//                req.setAttribute("productName", productName);
//                req.setAttribute("amount", amount);
//                req.setAttribute("price", price);
//
//                req.getRequestDispatcher("/store/product").forward(req, resp);
//                return;

                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("productName", productName);
                jsonResponse.put("amount", amount);
                jsonResponse.put("price", price);

                resp.setContentType("application/json");

                resp.getWriter().write(jsonResponse.toString());

                break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String productName = req.getParameter("productName");
        int firstAmount = Integer.parseInt(req.getParameter("amount"));
        int amount = Integer.parseInt(req.getParameter("quantity"));
        System.out.println(productName + " " + firstAmount + " " + amount);
        DatabaseManager databaseManager = new DatabaseManager();
        if(amount <= firstAmount){
            databaseManager.buyProduct(productName, amount);
        }else{
            resp.setStatus(405);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("productName");
//        System.out.println(req.getParameter("productName"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String password = req.getParameter("password");

        DatabaseManager databaseManager = new DatabaseManager();
        ObjectMapper mapper = new ObjectMapper();
        AidClass aidClass = null;
        try {
            aidClass = mapper.readValue(new File("src/main/resources/storage.json"), new TypeReference<AidClass>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (aidClass.getPassword().equals(password) && databaseManager.nameCheck(name)) {
            databaseManager.updateProductAmount(name, amount);
        } else {
            resp.setStatus(405);
        }

    }



}
