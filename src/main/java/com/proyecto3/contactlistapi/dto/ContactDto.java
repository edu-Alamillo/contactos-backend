package com.proyecto3.contactlistapi.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ContactDto {

    /*@NotBlank*/
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El correo es invalido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }



}
