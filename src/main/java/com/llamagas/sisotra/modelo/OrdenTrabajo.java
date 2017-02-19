package com.llamagas.sisotra.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author DENIS
 */
@Entity
@Table(name = "orden_trabajo")
@NamedQueries({
    @NamedQuery(name = "OT.getTodos",
            query = "SELECT new com.llamagas.sisotra.modelo.OrdenTrabajo"
            + "(o.IdOrdenT, o.IdPlaca, o.IdNomima, o.F_Ingreso, o.F_termino, o.Descripcion, o.Kilometraje, o.Estado)"
            + " FROM OrdenTrabajo o")
})
public class OrdenTrabajo implements Serializable {

    //datos de orden trabajo

    @Id
    @Column(name = "idORDEN_TRABAJO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdOrdenT;
    
    @Column(name = "idPLACA")
    private String IdPlaca;
    
    @Column(name = "idNOMINA")
    private String IdNomima;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso", updatable = false)
    private Date F_Ingreso;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_terminacion", updatable = false)
    private Date F_termino;
    
    @Column(name = "descripcion")
    private String Descripcion;
    @Column(name = "kilometraje")
    private Integer Kilometraje;
    @Column(name = "estado")
    private String Estado;
    //datos del empleado o jefe de flota
//    private String Empleado;
//    private String Cargo_emple;
//    private String Area_emple;
    //datos de la unidad
//    private String IdPlaca;
//    private String Marca;
//    private String Modelo;
//    private String Zonal;
//    private Integer A_fabri;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Integer IdOrdenT, String IdPlaca, String IdNomima, Date F_Ingreso, Date F_termino, String Descripcion, Integer Kilometraje, String Estado) {
        this.IdOrdenT = IdOrdenT;
        this.IdPlaca = IdPlaca;
        this.IdNomima = IdNomima;
        this.F_Ingreso = F_Ingreso;
        this.F_termino = F_termino;
        this.Descripcion = Descripcion;
        this.Kilometraje = Kilometraje;
        this.Estado = Estado;
    }

    public Integer getIdOrdenT() {
        return IdOrdenT;
    }

    public void setIdOrdenT(Integer IdOrdenT) {
        this.IdOrdenT = IdOrdenT;
    }

    public String getIdPlaca() {
        return IdPlaca;
    }

    public void setIdPlaca(String IdPlaca) {
        this.IdPlaca = IdPlaca;
    }

    public String getIdNomima() {
        return IdNomima;
    }

    public void setIdNomima(String IdNomima) {
        this.IdNomima = IdNomima;
    }

    public Date getF_Ingreso() {
        return F_Ingreso;
    }

    public void setF_Ingreso(Date F_Ingreso) {
        this.F_Ingreso = F_Ingreso;
    }

    public Date getF_termino() {
        return F_termino;
    }

    public void setF_termino(Date F_termino) {
        this.F_termino = F_termino;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getKilometraje() {
        return Kilometraje;
    }

    public void setKilometraje(Integer Kilometraje) {
        this.Kilometraje = Kilometraje;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
