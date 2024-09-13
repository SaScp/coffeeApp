package ru.alex.coffeapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Parameter;
import jakarta.persistence.Query;
import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;



@SpringBootApplication
@EnableAsync
@EnableScheduling
public class CoffeeAppApplication {

    private final JdbcTemplate jdbcTemplate;

    private final EntityManager manager;

    public CoffeeAppApplication(JdbcTemplate jdbcTemplate, EntityManager manager) {
        this.jdbcTemplate = jdbcTemplate;
        this.manager = manager;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoffeeAppApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Scheduled(fixedRate = 157_680_000_000L)
    public void clearStatistic() {
        this.jdbcTemplate.update("UPDATE recipe SET quantity_buyers = 0 WHERE quantity_buyers > 0;");
    }


}
