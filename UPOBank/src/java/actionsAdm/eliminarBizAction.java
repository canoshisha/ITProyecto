/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionsAdm;

import Entidades_REST.Bizum;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import wsREST.BizumREST;

/**
 *
 * @author Carlos Herrera
 */
public class eliminarBizAction extends ActionSupport{
    
    private String idBizum;
     GenericType<Bizum> genericType = new GenericType<Bizum>() {
    };
    GenericType<List<Bizum>> genericTypeLista = new GenericType<List<Bizum>>() {
    };

    BizumREST dao = new BizumREST();
    private Bizum biz;

    ActionContext actionContext;

    private Map session;

    public Bizum getBiz() {
        return biz;
    }

    public void setBiz(Bizum biz) {
        this.biz = biz;
    }
    
    public String getIdBizum() {
        return idBizum;
    }

    public void setIdBizum(String idBizum) {
        this.idBizum = idBizum;
    }
    
        public String execute() throws Exception {
        return SUCCESS;

    }

    public String eliminarBiz() throws Exception {
        dao.remove(this.getIdBizum());
        List<Bizum> listaBiz= (List<Bizum>) dao.findAll_XML(genericTypeLista);

        actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put("listaBizum", listaBiz);

        dao.close();
        return execute();
    }
}
