package modelos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Importante agregar este import

@JsonIgnoreProperties(ignoreUnknown = true) 
public class LoteDeTransacciones {
    private String loteId;
    private String fechaGeneracion;
    private List<Transaccion> transacciones;
 
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }
    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
    
   
}