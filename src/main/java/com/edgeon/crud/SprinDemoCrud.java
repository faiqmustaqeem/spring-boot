package com.edgeon.crud;

import com.edgeon.crud.storage.StorageProperties;
import com.edgeon.crud.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication
public class SprinDemoCrud {

    public static void main(String[] args) {

        SpringApplication.run(SprinDemoCrud.class, args);

    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
//            storageService.deleteAll();
            storageService.init();
        };
    }


}
