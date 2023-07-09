package com.example.sistematickets;

import com.example.sistematickets.Models.Usuario;
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



        Scanner input = new Scanner(System.in);
        String nombr;
        String correo;
        String pass;
        while (true){
            //para ingresar usuarios a la bd

            System.out.println("Nombre");
            nombr = input.nextLine();
            System.out.println("Correo");
            correo = input.nextLine();
            System.out.println("Contrasena");
            pass = input.nextLine();

            usuarioService.guardarUsuario(new Usuario(nombr,correo,pass));

        }

    }



}
