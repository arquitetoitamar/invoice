package br.com.emissor;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@ComponentScan("br.com.emissor")
@EnableJpaRepositories
@EnableJms
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	
		SpringApplication.run(Application.class, args);			
	}
	
	@Bean public Queue queueInvoice() {
		return new ActiveMQQueue("invoice.queue");
	}
	@Bean public Queue queueItem() {
		return new ActiveMQQueue("item.queue");
	}
	
}