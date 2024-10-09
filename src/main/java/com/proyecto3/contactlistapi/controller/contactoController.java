package com.proyecto3.contactlistapi.controller;

import com.proyecto3.contactlistapi.Service.contactoService;
import com.proyecto3.contactlistapi.dto.ContactDto;
import com.proyecto3.contactlistapi.entity.Contacto;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/api/contacto/")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class contactoController {

    private final contactoService ContactoService;

    public contactoController(contactoService contactoService) {
        ContactoService = contactoService;
    }

    @GetMapping
    public Iterable<Contacto> list(){
        return  ContactoService.findAll();
    }

    @GetMapping("{id}")
    public Contacto get(@PathVariable Integer id) {
        return ContactoService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contacto create(@Validated @RequestBody ContactDto contactDto) {
        return ContactoService.create(contactDto);
    }

    @PutMapping("{id}")
    public Contacto update(@PathVariable Integer id, @Validated @RequestBody ContactDto contactDto) {
        return ContactoService.update(id, contactDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        ContactoService.delete(id);
    }

}
