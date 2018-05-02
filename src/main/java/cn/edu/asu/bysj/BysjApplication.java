package cn.edu.asu.bysj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
public class BysjApplication {

	public static void main(String[] args) {
		SpringApplication.run(BysjApplication.class, args);
		System.out.println("======complete======");
	}
}
