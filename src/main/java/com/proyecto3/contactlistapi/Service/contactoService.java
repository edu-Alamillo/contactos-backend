package com.proyecto3.contactlistapi.Service;

import com.proyecto3.contactlistapi.dto.ContactDto;
import com.proyecto3.contactlistapi.entity.Contacto;
import com.proyecto3.contactlistapi.repository.contactoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.proyecto3.contactlistapi.exception.ResourceNotFoundException;

import java.time.LocalDate;

@Service
public class contactoService {

    private final contactoRepository ContactoRepositorio;
    private final ModelMapper mapper;

    public contactoService(contactoRepository contactoRepositorio) {
        ContactoRepositorio = contactoRepositorio;
        mapper = new ModelMapper();
    }

    public Iterable<Contacto> findAll(){
        return  ContactoRepositorio.findAll();
    }

    public Contacto findById(Integer id) {
        return ContactoRepositorio.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Contacto create(ContactDto contactDto) {
        Contacto contacto = mapper.map(contactDto, Contacto.class);
        contacto.setCreateAt(LocalDate.now());
        return ContactoRepositorio.save(contacto);
    }

    public Contacto update(Integer id, ContactDto contactDto) {
        Contacto contactoFormDb = findById(id);
        mapper.map(contactDto, contactoFormDb);

        return ContactoRepositorio.save(contactoFormDb);
    }

    public void delete(Integer id) {
        Contacto contactoFromDb = findById(id);
        ContactoRepositorio.delete(contactoFromDb);
    }
}
