package ar.com.ada.api.creditos.services;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.repos.PrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    PrestamoRepository repo;

    public Prestamo crearPrestamo(Integer clienteId, Date fecha, BigDecimal importe, int cuotas) {

        Prestamo prestamo = new Prestamo();

        prestamo.getCliente().setClienteId(clienteId);
        prestamo.setFecha(fecha);
        prestamo.setImporte(importe);
        prestamo.setCuotas(cuotas);

        return repo.save(prestamo);
    }
    
}
