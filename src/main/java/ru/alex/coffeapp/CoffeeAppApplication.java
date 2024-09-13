package ru.alex.coffeapp;

import org.modelmapper.ModelMapper;
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

    public CoffeeAppApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
