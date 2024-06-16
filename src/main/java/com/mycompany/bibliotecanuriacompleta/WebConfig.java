/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *///Autora página web: Núria Marzo Marquès
package com.mycompany.bibliotecanuriacompleta;

/**
 *
 * @author Administrador
 */

//Este WebConfig lo necesitamos para poder recibir las solicitudes desde la parte de frontend/navegador.
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    
   @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080");
            }
        };
    }
    
    
     //Segunda forma de conectar back con front
    /* @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//aquí añadimos todo
                .allowedOrigins("http://localhost:8080") //esto es la url
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //los metodos que le permitimos. El options es para que el navegador nos permita hacer estos metodos
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600); //tiempo máximo que correrá
    }*/
    
}