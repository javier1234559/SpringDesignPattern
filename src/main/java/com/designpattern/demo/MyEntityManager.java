package com.designpattern.demo;

import com.designpattern.demo.model.Category;
import com.designpattern.demo.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class MyEntityManager {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void processData() {

        Category category = new Category();
        category.setName("Electronics");
        em.persist(category);

        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setCategory(category);
        em.persist(product1);

        Product product2 = new Product();
        product2.setName("Smartphone");
        product2.setCategory(category);
        em.persist(product2);

        // Sử dụng proxy để tải danh sách sản phẩm từ danh mục
        Category categoryProxy = em.getReference(Category.class, category.getId());
        List<Product> products = categoryProxy.getProducts();

        // Proxy lazy loading - không có truy vấn dữ liệu
        System.out.println("Lazy Loading (Proxy):");
        System.out.println("Category Name: " + categoryProxy.getName());
        System.out.println("Products: " + products); // In ra proxy

        // Thực hiện truy vấn dữ liệu từ cơ sở dữ liệu để tải danh sách sản phẩm đầy đủ
        em.clear(); // Xóa cache để đảm bảo truy vấn từ cơ sở dữ liệu
        Category categoryFull = em.find(Category.class, category.getId());
        List<Product> productsFull = categoryFull.getProducts();

        System.out.println("\nFull Loading:");
        System.out.println("Category Name: " + categoryFull.getName());
        System.out.println("Products: " + productsFull);
    }

}
