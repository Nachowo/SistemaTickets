package com.example.sistematickets;

import com.example.sistematickets.Controllers.TicketController;
import com.example.sistematickets.Models.Usuario;

import com.example.sistematickets.Services.TicketService;
import com.example.sistematickets.Services.UsuarioService;
import com.example.sistematickets.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class SistemaTicketsApplication {

    public static void main(String[] args) {SpringApplication.run(SistemaTicketsApplication.class, args);


    }



}
