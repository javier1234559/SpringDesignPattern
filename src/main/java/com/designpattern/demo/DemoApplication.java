package com.designpattern.demo;

import com.designpattern.demo.beans.Bean;
import com.designpattern.demo.model.Product;
import com.designpattern.demo.repository.ProductRepository;
import com.designpattern.demo.service.BeanService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

//		SingletonPattern(args);
//		DependencyInjectionPattern(args);
//		ProxyPattern(args);
		TemplatePattern(args);
	}

	public static void SingletonPattern (String[] args){
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Bean bean1 = context.getBean(Bean.class); // This is also demo for DI
		Bean bean2 = context.getBean(Bean.class);
		System.out.println(bean1);
		System.out.println(bean2);
		if(bean1 == bean2) {
			System.out.println("This is the same instance") ;
			bean1.doSomething();
		}

		// Pause
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Enter to exit.");
		scanner.nextLine();
	}

	public static void DependencyInjectionPattern (String[] args){
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		BeanService beanService = context.getBean(BeanService.class);
		beanService.doSomethingWithBean();

		// Pause
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Enter to exit.");
		scanner.nextLine();
	}

	public static void ProxyPattern (String[] args){
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		MyEntityManager myEntityManager = context.getBean(MyEntityManager.class);
		myEntityManager.processData();

		// Pause
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Enter to exit.");
		scanner.nextLine();
	}

	public static void TemplatePattern(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		ProductRepository productRepository = context.getBean(ProductRepository.class);

		Product product = new Product();
		product.setName("Example Product");

		productRepository.save(product);

		Optional<Product> retrievedProduct = productRepository.findById(product.getId());
		System.out.println("Retrieved product: " + retrievedProduct.get());

		productRepository.delete(retrievedProduct.get());
		System.out.println("Product deleted.");

		// Pause
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Enter to exit.");
		scanner.nextLine();
	}

}
