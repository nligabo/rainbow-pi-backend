package br.com.rainbow_pi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan
public class RainbowPiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RainbowPiApplication.class, args);
	}

}
