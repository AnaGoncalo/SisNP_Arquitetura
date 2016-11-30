/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.negocio;

import java.util.List;
import sisnp.ifrn.br.dominio.Meta;
import sisnp.ifrn.br.persistencia.DAMeta;

/**
 *
 * @author Ana Gonçalo
 */
public class BLMeta {
    private DAMeta dataAcess = null;
    
    public BLMeta(){
        dataAcess = new DAMeta();
    }
    public List<Meta> getMetas(int idProjeto){
        System.out.println("chegou aqui BL Meta");
        return dataAcess.getMetas(idProjeto);
    }
    
}
