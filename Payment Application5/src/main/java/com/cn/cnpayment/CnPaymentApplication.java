package com.cn.cnpayment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CnPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnPaymentApplication.class, args);

	}
}
