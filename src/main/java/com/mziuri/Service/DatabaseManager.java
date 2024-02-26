package com.mziuri.Service;

import com.mziuri.Classes.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager instace;

    public static DatabaseManager getInstance() {
        if (instace == null) {
            instace = new DatabaseManager();
        }
        return instace;
    }

    public DatabaseManager() {
    }

    public List<Product> read() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("candy");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);
        TypedQuery<Product> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Product> list = typedQuery.getResultList();
        return list;
    }

    public void write(Product product) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("candy");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    public boolean nameCheck(String name) {
        boolean tr = false;
        List<Product> list = read();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                tr = true;
            }
        }
        return tr;
    }

    public void updateProductAmount(String productName, int addAmount) {
        String sql = "UPDATE product SET prod_amount = prod_amount + ? WHERE prod_name = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/candyshop", "root", "root");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, addAmount);
            pstmt.setString(2, productName);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
