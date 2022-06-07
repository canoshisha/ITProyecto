/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findById", query = "SELECT p FROM Prestamo p WHERE p.id = :id")
    , @NamedQuery(name = "Prestamo.findByInicio", query = "SELECT p FROM Prestamo p WHERE p.inicio = :inicio")
    , @NamedQuery(name = "Prestamo.findByFin", query = "SELECT p FROM Prestamo p WHERE p.fin = :fin")
    , @NamedQuery(name = "Prestamo.findByMensualidad", query = "SELECT p FROM Prestamo p WHERE p.mensualidad = :mensualidad")
    , @NamedQuery(name = "Prestamo.findByHipoteca", query = "SELECT p FROM Prestamo p WHERE p.hipoteca = :hipoteca")
    , @NamedQuery(name = "Prestamo.findByCantidad", query = "SELECT p FROM Prestamo p WHERE p.cantidad = :cantidad")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin")
    @Temporal(TemporalType.DATE)
    private Date fin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mensualidad")
    private float mensualidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hipoteca")
    private boolean hipoteca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @JoinColumn(name = "IBAN", referencedColumnName = "IBAN")
    @ManyToOne(optional = false)
    private CuentaBancaria iban;

    public Prestamo() {
    }

    public Prestamo(Integer id) {
        this.id = id;
    }

    public Prestamo(Integer id, Date inicio, Date fin, float mensualidad, boolean hipoteca, float cantidad) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.mensualidad = mensualidad;
        this.hipoteca = hipoteca;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public float getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(float mensualidad) {
        this.mensualidad = mensualidad;
    }

    public boolean getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(boolean hipoteca) {
        this.hipoteca = hipoteca;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicios.Prestamo[ id=" + id + " ]";
    }
    
}
