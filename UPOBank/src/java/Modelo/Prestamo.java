package Modelo;
// Generated 01-jun-2022 11:27:02 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Prestamo generated by hbm2java
 */
public class Prestamo  implements java.io.Serializable {


     private Integer id;
     private CuentaBancaria cuentaBancaria;
     private Date inicio;
     private Date fin;
     private float mensualidad;
     private boolean hipoteca;
     private float cantidad;

    public Prestamo() {
    }

    public Prestamo(CuentaBancaria cuentaBancaria, Date inicio, Date fin, float mensualidad, boolean hipoteca, float cantidad) {
       this.cuentaBancaria = cuentaBancaria;
       this.inicio = inicio;
       this.fin = fin;
       this.mensualidad = mensualidad;
       this.hipoteca = hipoteca;
       this.cantidad = cantidad;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public CuentaBancaria getCuentaBancaria() {
        return this.cuentaBancaria;
    }
    
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    public Date getInicio() {
        return this.inicio;
    }
    
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
    public Date getFin() {
        return this.fin;
    }
    
    public void setFin(Date fin) {
        this.fin = fin;
    }
    public float getMensualidad() {
        return this.mensualidad;
    }
    
    public void setMensualidad(float mensualidad) {
        this.mensualidad = mensualidad;
    }
    public boolean isHipoteca() {
        return this.hipoteca;
    }
    
    public void setHipoteca(boolean hipoteca) {
        this.hipoteca = hipoteca;
    }
    public float getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }




}


