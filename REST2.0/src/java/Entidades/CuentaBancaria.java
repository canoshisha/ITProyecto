/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "cuenta bancaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaBancaria.findAll", query = "SELECT c FROM CuentaBancaria c")
    , @NamedQuery(name = "CuentaBancaria.findByIban", query = "SELECT c FROM CuentaBancaria c WHERE c.iban = :iban")
    , @NamedQuery(name = "CuentaBancaria.findByCantidad", query = "SELECT c FROM CuentaBancaria c WHERE c.cantidad = :cantidad")})
public class CuentaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "IBAN")
    private String iban;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iban")
    private Collection<Transferencia> transferenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iban")
    private Collection<Prestamo> prestamoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iban")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iban")
    private Collection<Tarjeta> tarjetaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iban")
    private Collection<Bizum> bizumCollection;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String iban) {
        this.iban = iban;
    }

    public CuentaBancaria(String iban, float cantidad) {
        this.iban = iban;
        this.cantidad = cantidad;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public Collection<Transferencia> getTransferenciaCollection() {
        return transferenciaCollection;
    }

    public void setTransferenciaCollection(Collection<Transferencia> transferenciaCollection) {
        this.transferenciaCollection = transferenciaCollection;
    }

    @XmlTransient
    public Collection<Prestamo> getPrestamoCollection() {
        return prestamoCollection;
    }

    public void setPrestamoCollection(Collection<Prestamo> prestamoCollection) {
        this.prestamoCollection = prestamoCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Tarjeta> getTarjetaCollection() {
        return tarjetaCollection;
    }

    public void setTarjetaCollection(Collection<Tarjeta> tarjetaCollection) {
        this.tarjetaCollection = tarjetaCollection;
    }

    @XmlTransient
    public Collection<Bizum> getBizumCollection() {
        return bizumCollection;
    }

    public void setBizumCollection(Collection<Bizum> bizumCollection) {
        this.bizumCollection = bizumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iban != null ? iban.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria other = (CuentaBancaria) object;
        if ((this.iban == null && other.iban != null) || (this.iban != null && !this.iban.equals(other.iban))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CuentaBancaria[ iban=" + iban + " ]";
    }
    
}
