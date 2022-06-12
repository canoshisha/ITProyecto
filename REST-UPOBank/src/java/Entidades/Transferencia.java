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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "transferencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transferencia.findAll", query = "SELECT t FROM Transferencia t")
    , @NamedQuery(name = "Transferencia.findById", query = "SELECT t FROM Transferencia t WHERE t.id = :id")
    , @NamedQuery(name = "Transferencia.findByIBANdestinatario", query = "SELECT t FROM Transferencia t WHERE t.iBANdestinatario = :iBANdestinatario")
    , @NamedQuery(name = "Transferencia.findByFechaInicio", query = "SELECT t FROM Transferencia t WHERE t.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Transferencia.findByFechaFin", query = "SELECT t FROM Transferencia t WHERE t.fechaFin = :fechaFin")
    , @NamedQuery(name = "Transferencia.findByCantidad", query = "SELECT t FROM Transferencia t WHERE t.cantidad = :cantidad")
    , @NamedQuery(name = "Transferencia.findByConcepto", query = "SELECT t FROM Transferencia t WHERE t.concepto = :concepto")})
public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "IBAN_destinatario")
    private String iBANdestinatario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private float cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "concepto")
    private String concepto;
    @JoinColumn(name = "IBAN", referencedColumnName = "IBAN")
    @ManyToOne(optional = false)
    private CuentaBancaria iban;

    public Transferencia() {
    }

    public Transferencia(Integer id) {
        this.id = id;
    }

    public Transferencia(Integer id, String iBANdestinatario, Date fechaInicio, Date fechaFin, float cantidad, String concepto) {
        this.id = id;
        this.iBANdestinatario = iBANdestinatario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIBANdestinatario() {
        return iBANdestinatario;
    }

    public void setIBANdestinatario(String iBANdestinatario) {
        this.iBANdestinatario = iBANdestinatario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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
        if (!(object instanceof Transferencia)) {
            return false;
        }
        Transferencia other = (Transferencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Transferencia[ id=" + id + " ]";
    }
    
}
