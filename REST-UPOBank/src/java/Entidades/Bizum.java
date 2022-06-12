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
@Table(name = "bizum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bizum.findAll", query = "SELECT b FROM Bizum b")
    , @NamedQuery(name = "Bizum.findById", query = "SELECT b FROM Bizum b WHERE b.id = :id")
    , @NamedQuery(name = "Bizum.findByMovilDestinatario", query = "SELECT b FROM Bizum b WHERE b.movilDestinatario = :movilDestinatario")
    , @NamedQuery(name = "Bizum.findByFecha", query = "SELECT b FROM Bizum b WHERE b.fecha = :fecha")
    , @NamedQuery(name = "Bizum.findByCantidad", query = "SELECT b FROM Bizum b WHERE b.cantidad = :cantidad")
    , @NamedQuery(name = "Bizum.findByConcepto", query = "SELECT b FROM Bizum b WHERE b.concepto = :concepto")})
public class Bizum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movil_destinatario")
    private int movilDestinatario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
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

    public Bizum() {
    }

    public Bizum(Integer id) {
        this.id = id;
    }

    public Bizum(Integer id, int movilDestinatario, Date fecha, float cantidad, String concepto) {
        this.id = id;
        this.movilDestinatario = movilDestinatario;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMovilDestinatario() {
        return movilDestinatario;
    }

    public void setMovilDestinatario(int movilDestinatario) {
        this.movilDestinatario = movilDestinatario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof Bizum)) {
            return false;
        }
        Bizum other = (Bizum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Bizum[ id=" + id + " ]";
    }
    
}
