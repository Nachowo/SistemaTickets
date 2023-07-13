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
        UsuarioRepository usuarioRepository = context.getBean(UsuarioRepository.class);


        Scanner input = new Scanner(System.in);
        String nombr = "Jano";
        String correo = "jano@usach.cl";
        String pass = "123";
        String rol = "OLA";


            /**
            System.out.println("Nombre");
            nombr = input.nextLine();
            System.out.println("Correo");
            correo = input.nextLine();
            System.out.println("Contrasena");
            pass = input.nextLine();
            */
        //System.out.println(ticketService.findTicket( 1L));

        System.out.println("usuario Jano y pass 123");
        if (usuarioService.login(correo,pass)){
            System.out.println("LOGIN EXITOSO");
        }
        System.out.println("Usuario jano y pass 124");
        if (usuarioService.login(correo,"124")){
            System.out.println("LOGIN EXITOSO");
        }else {
            System.out.println("SALIO BIEN");
        }
        System.out.println("Usuario pedro y pass 12");
        if (usuarioService.login("pedro","12")){
            System.out.println("LOGIN EXITOSO");
        }else {
            System.out.println("SALIO BIEN");
        }
        //usuarioService.guardarUsuario(user);

    }



}
