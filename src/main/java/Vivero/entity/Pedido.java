/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vivero.entity;

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

/**
 *
 * @author Carlos Velez
 */
@Entity
@Table(name = "pedido")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByPedidoId", query = "SELECT p FROM Pedido p WHERE p.pedidoId = :pedidoId"),
    @NamedQuery(name = "Pedido.findByUnidades", query = "SELECT p FROM Pedido p WHERE p.unidades = :unidades"),
    @NamedQuery(name = "Pedido.findByPrecioTotal", query = "SELECT p FROM Pedido p WHERE p.precioTotal = :precioTotal"),
    @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pedido_id")
    private Long pedidoId;
    @Basic(optional = false)
    @Column(name = "unidades")
    private int unidades;
    @Basic(optional = false)
    @Column(name = "precio_total")
    private int precioTotal;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "articulo_id", referencedColumnName = "articulo_id")
    @ManyToOne(optional = false)
    private Articulo articuloId;
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    @ManyToOne(optional = false)
    private Cliente clienteId;

    public Pedido() {
    }

    public Pedido(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Pedido(Long pedidoId, int unidades, int precioTotal, Date fecha) {
        this.pedidoId = pedidoId;
        this.unidades = unidades;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Articulo getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Articulo articuloId) {
        this.articuloId = articuloId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoId != null ? pedidoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedidoId == null && other.pedidoId != null) || (this.pedidoId != null && !this.pedidoId.equals(other.pedidoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vivero.entity.Pedido[ pedidoId=" + pedidoId + " ]";
    }
    
}
