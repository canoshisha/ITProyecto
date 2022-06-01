package Modelo;
// Generated 01-jun-2022 11:27:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * CuentaBancaria generated by hbm2java
 */
public class CuentaBancaria  implements java.io.Serializable {


     private String iban;
     private float cantidad;
     private Set tarjetas = new HashSet(0);
     private Set bizums = new HashSet(0);
     private Set transferencias = new HashSet(0);
     private Set usuarios = new HashSet(0);
     private Set prestamos = new HashSet(0);

    public CuentaBancaria() {
    }

	
    public CuentaBancaria(String iban, float cantidad) {
        this.iban = iban;
        this.cantidad = cantidad;
    }
    public CuentaBancaria(String iban, float cantidad, Set tarjetas, Set bizums, Set transferencias, Set usuarios, Set prestamos) {
       this.iban = iban;
       this.cantidad = cantidad;
       this.tarjetas = tarjetas;
       this.bizums = bizums;
       this.transferencias = transferencias;
       this.usuarios = usuarios;
       this.prestamos = prestamos;
    }
   
    public String getIban() {
        return this.iban;
    }
    
    public void setIban(String iban) {
        this.iban = iban;
    }
    public float getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    public Set getTarjetas() {
        return this.tarjetas;
    }
    
    public void setTarjetas(Set tarjetas) {
        this.tarjetas = tarjetas;
    }
    public Set getBizums() {
        return this.bizums;
    }
    
    public void setBizums(Set bizums) {
        this.bizums = bizums;
    }
    public Set getTransferencias() {
        return this.transferencias;
    }
    
    public void setTransferencias(Set transferencias) {
        this.transferencias = transferencias;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    public Set getPrestamos() {
        return this.prestamos;
    }
    
    public void setPrestamos(Set prestamos) {
        this.prestamos = prestamos;
    }




}


