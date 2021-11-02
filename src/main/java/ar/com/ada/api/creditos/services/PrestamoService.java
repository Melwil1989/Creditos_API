package ar.com.ada.api.creditos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.repos.PrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    PrestamoRepository repo;

    public void crearPrestamo(Prestamo prestamo) {

        repo.save(prestamo);
    }
    
}
