package com.llamagas.sisotra.action;

import com.llamagas.sisotra.dao.OrdenTrabajoDao;
import com.llamagas.sisotra.dao.OrdenTrabajoDaoImpl;
import com.llamagas.sisotra.modelo.OrdenTrabajo;
import com.llamagas.sisotra.service.OrdenTrabajoService;
import com.llamagas.sisotra.service.OrdenTrabajoServiceJpaImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import org.apache.struts2.interceptor.SessionAware;

public class OrdenTrabajoAction extends ActionSupport implements SessionAware {

    private OrdenTrabajo ordenTrabajo;
    //public String mensaje;
    private List<OrdenTrabajo> listaOT;
    public String cod;
    //public Map listaArea;
    private Map<String, Object> mapaSesion;

    private OrdenTrabajoService creaOTService() {
        OrdenTrabajoServiceJpaImpl service = new OrdenTrabajoServiceJpaImpl();
        Map<String, Object> application = (Map) ActionContext.getContext().get("application");
        service.setEmf((EntityManagerFactory) application.get("emf"));
        return service;
    }

    public String inicializar() throws Exception {
        OrdenTrabajoService cursoService = creaOTService();
        List<OrdenTrabajo> listaOts = cursoService.listar();
        mapaSesion.put("OTs", listaOts);
        return SUCCESS;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

//    public String ListarOT() throws Exception {
//        OrdenTrabajoDao dao = new OrdenTrabajoDaoImpl();
//        listaOT = dao.listarTodo();
//        return SUCCESS;
//    }

    public String nuevo_actualizar_OT() throws Exception {
        OrdenTrabajoService ordenTrabajoService = creaOTService();
        if (ordenTrabajo.getIdOrdenT() != null) {
            ordenTrabajoService.actualizar(ordenTrabajo);
        } else {
            ordenTrabajoService.registrar(ordenTrabajo);
        }
        return SUCCESS;
//        OrdenTrabajoDao dao = new OrdenTrabajoDaoImpl();
//        dao.registrar(ordenTrabajo);
//        mensaje = "Se agrego con EXito";
//        ordenTrabajo = new OrdenTrabajo();
//        return SUCCESS;
    }

    public String getOT() {
        OrdenTrabajoDao dao = new OrdenTrabajoDaoImpl();
        ordenTrabajo = dao.ObtenerOT(cod);
        return SUCCESS;
    }

    public String getasignarOT() throws Exception {
        OrdenTrabajoDao dao = new OrdenTrabajoDaoImpl();
        ordenTrabajo = dao.ObtenerOT(cod);
//        listaArea = new HashMap();
//        listaArea.put("MECANICA", "MECANICA");
//        listaArea.put("ELECTRICIDAD", "ELECTRICIDAD");
//        listaArea.put("PINTURA", "PINTURA");
        return SUCCESS;
    }

    public String modificarOrdenTrabajo() {
        OrdenTrabajoDao dao = new OrdenTrabajoDaoImpl();
        dao.actualizar(ordenTrabajo);
        listaOT = dao.listarTodo();
        return SUCCESS;
    }

    public String eliminarOrdenTrabajo() {
        OrdenTrabajoDao dao = new OrdenTrabajoDaoImpl();
        dao.eliminarSegun(ordenTrabajo);
        listaOT = dao.listarTodo();
        return SUCCESS;
    }

    public String registroOT() throws Exception {
        return SUCCESS;
    }

    public String iniciarAsignacionOT() {
        OrdenTrabajoDao dao = new OrdenTrabajoDaoImpl();
        listaOT = dao.listarTodo();
        return SUCCESS;
    }

    public String asignarOT() {
        OrdenTrabajoDao dao = new OrdenTrabajoDaoImpl();
        dao.Asignar(ordenTrabajo);
        listaOT = dao.listarTodo();
        return SUCCESS;
    }

    public String detalleAsignacionOT() {
        OrdenTrabajoDao dao = new OrdenTrabajoDaoImpl();
        listaOT = dao.listarTodo();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.mapaSesion = map;
    }
}
