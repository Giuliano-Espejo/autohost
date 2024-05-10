package com.hostauto.demo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	@Bean
	public CommandLineRunner schedulingRunner() {
		return args -> {
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					String url = "https://cargaimagenes.onrender.com/pais";
					RestTemplate restTemplate = new RestTemplate();
					ResponseEntity<?> response = restTemplate.getForEntity(url, String.class);
					if (response.getStatusCode().is2xxSuccessful()) {
						logger.info("GET a {} exitoso", url);
					} else {
						logger.info("GET a {} fallido", url);
					}
				}
			};

			// Programa la tarea para ejecutarse cada 2 horas (7200 segundos)
			timer.schedule(task, 0, 150 * 1000);
		};
	}
}
