/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "tarjeta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t")
    , @NamedQuery(name = "Tarjeta.findByNumerotarjeta", query = "SELECT t FROM Tarjeta t WHERE t.numerotarjeta = :numerotarjeta")
    , @NamedQuery(name = "Tarjeta.findByCaducidad", query = "SELECT t FROM Tarjeta t WHERE t.caducidad = :caducidad")
    , @NamedQuery(name = "Tarjeta.findByCvv", query = "SELECT t FROM Tarjeta t WHERE t.cvv = :cvv")})
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero_tarjeta")
    private Long numerotarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "caducidad")
    @Temporal(TemporalType.DATE)
    private Date caducidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvv")
    private int cvv;
    @JoinColumn(name = "IBAN", referencedColumnName = "IBAN")
    @ManyToOne(optional = false)
    private CuentaBancaria iban;

    public Tarjeta() {
    }

    public Tarjeta(Long numerotarjeta) {
        this.numerotarjeta = numerotarjeta;
    }

    public Tarjeta(Long numerotarjeta, Date caducidad, int cvv) {
        this.numerotarjeta = numerotarjeta;
        this.caducidad = caducidad;
        this.cvv = cvv;
    }

    public Long getNumerotarjeta() {
        return numerotarjeta;
    }

    public void setNumerotarjeta(Long numerotarjeta) {
        this.numerotarjeta = numerotarjeta;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public CuentaBancaria getIban() {
        return iban;
    }

    public void setIban(CuentaBancaria iban) {
        this.iban = iban;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerotarjeta != null ? numerotarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjeta)) {
            return false;
        }
        Tarjeta other = (Tarjeta) object;
        if ((this.numerotarjeta == null && other.numerotarjeta != null) || (this.numerotarjeta != null && !this.numerotarjeta.equals(other.numerotarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tarjeta[ numerotarjeta=" + numerotarjeta + " ]";
    }
    
}
