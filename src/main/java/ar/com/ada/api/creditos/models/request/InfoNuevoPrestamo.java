package ar.com.ada.api.creditos.models.request;

import java.math.BigDecimal;
import java.util.Date;

public class InfoNuevoPrestamo {

    public Integer clienteId;
    public Date fecha;
    public BigDecimal importe;
    public int cuotas;
}
