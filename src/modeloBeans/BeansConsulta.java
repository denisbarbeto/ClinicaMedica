/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

import java.util.Date;

/**
 *
 * @author Denis
 */
public class BeansConsulta {

    public int getConsultaID() {
        return consultaID;
    }

    public void setConsultaID(int consultaID) {
        this.consultaID = consultaID;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public Date getData_ini() {
        return data_ini;
    }

    public void setData_ini(Date data_ini) {
        this.data_ini = data_ini;
    }

    public Date getData_fin() {
        return data_fin;
    }

    public void setData_fin(Date data_fin) {
        this.data_fin = data_fin;
    }
    
    private int consultaID;
    private String diagnostico, receita;
    private Date data_ini, data_fin;
    
    
    
}
