/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.negocio;

import java.util.List;
import sisnp.ifrn.br.dominio.Pesquisador;
import sisnp.ifrn.br.persistencia.DAPesquisador;

/**
 *
 * @author Ana Gonçalo
 */
public class BLPesquisador {
    private DAPesquisador dataAcess = null;

    public BLPesquisador() {
        dataAcess = new DAPesquisador();
    }
    
    public List<Pesquisador> getEquipe(int idProjeto){
        return dataAcess.getPesquisadores(idProjeto);
    }
}
