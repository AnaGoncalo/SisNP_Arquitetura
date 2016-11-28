/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.negocio;

import java.util.List;
import sisnp.ifrn.br.dominio.Noticia;
import sisnp.ifrn.br.persistencia.DANoticia;

/**
 *
 * @author Ana Gonçalo
 */
public class BLNoticia {
    private DANoticia dataAcess = null;
    
    public BLNoticia(){
        dataAcess = new DANoticia();
    }
    
    public List<Noticia> getNoticias(int idProjeto){
        System.out.println("chegou aqui BL Noticia");
        return dataAcess.getNoticias(idProjeto);
    }
}
