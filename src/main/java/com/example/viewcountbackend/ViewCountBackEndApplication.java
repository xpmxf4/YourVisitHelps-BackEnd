package com.example.viewcountbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:63343")
@SpringBootApplication
public class ViewCountBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViewCountBackEndApplication.class, args);
    }

}
