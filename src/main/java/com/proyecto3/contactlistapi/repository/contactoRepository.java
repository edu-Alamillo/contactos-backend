package com.proyecto3.contactlistapi.repository;

import com.proyecto3.contactlistapi.entity.Contacto;
import org.springframework.data.repository.CrudRepository;

public interface contactoRepository extends CrudRepository<Contacto, Integer> {
}
