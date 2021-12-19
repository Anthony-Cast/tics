package com.example.proyecto;
import com.example.proyecto.repository.tempresRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);


        Mqtt2 connectionmqtt = new Mqtt2();
        connectionmqtt.subscribe();

    }



}

