package com.paulovictor.cursomc;

import com.paulovictor.cursomc.domain.*;
import com.paulovictor.cursomc.domain.enums.EstadoPagamento;
import com.paulovictor.cursomc.domain.enums.TipoCliente;
import com.paulovictor.cursomc.repositories.*;
import com.paulovictor.cursomc.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private S3Service s3Service;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        s3Service.uplodadFile("C:\\Users\\paulo\\Pictures\\Camera Roll\\WIN_20210413_13_27_13_Pro.jpg");
    }
}
