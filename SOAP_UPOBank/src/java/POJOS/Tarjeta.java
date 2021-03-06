package POJOS;
// Generated 07-jun-2022 18:31:50 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Tarjeta generated by hbm2java
 */
public class Tarjeta  implements java.io.Serializable {


     private int numeroTarjeta;
     private CuentaBancaria cuentaBancaria;
     private Date caducidad;
     private int ccv;

    public Tarjeta() {
    }

    public Tarjeta(int numeroTarjeta, CuentaBancaria cuentaBancaria, Date caducidad, int ccv) {
       this.numeroTarjeta = numeroTarjeta;
       this.cuentaBancaria = cuentaBancaria;
       this.caducidad = caducidad;
       this.ccv = ccv;
    }
   
    public int getNumeroTarjeta() {
        return this.numeroTarjeta;
    }
    
    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public CuentaBancaria getCuentaBancaria() {
        return this.cuentaBancaria;
    }
    
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    public Date getCaducidad() {
        return this.caducidad;
    }
    
    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }
    public int getCcv() {
        return this.ccv;
    }
    
    public void setCcv(int ccv) {
        this.ccv = ccv;
    }




}


