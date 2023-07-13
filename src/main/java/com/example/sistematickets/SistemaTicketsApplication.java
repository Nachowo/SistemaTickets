package com.example.sistematickets;

import com.example.sistematickets.Models.Usuario;

import com.example.sistematickets.Services.TicketService;
import com.example.sistematickets.Services.UsuarioService;
import com.example.sistematickets.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SistemaTicketsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SistemaTicketsApplication.class, args);
        UsuarioService usuarioService = context.getBean(UsuarioService.class);
        TicketService ticketService = context.getBean(TicketService.class);


        Scanner input = new Scanner(System.in);
        String nombr = "Jano";
        String correo = "jano@usach.cl";
        String pass = "123";
        String rol = "OLA";

        Usuario user = new Usuario(nombr,correo,pass,rol);

            ///para ingresar usuarios a la bd
            /**
            System.out.println("Nombre");
            nombr = input.nextLine();
            System.out.println("Correo");
            correo = input.nextLine();
            System.out.println("Contrasena");
            pass = input.nextLine();
            */
        //System.out.println(ticketService.findTicket( 1L));
        usuarioService.guardarUsuario(user);
    }



}
