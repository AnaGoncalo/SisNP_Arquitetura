
package sisnp.ifrn.br.negocio;

import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.persistencia.DAProjeto;

/**
 *
 * @author Ana Gonçalo
 */
public class BLProjeto {
    
   private DAProjeto dataAcess = null;
    
    public BLProjeto(){
        dataAcess = new DAProjeto();
    }
    
    public Projeto getProjeto(int idProjeto){
        System.out.println("chegou aqui BL");
        return dataAcess.getProjeto(idProjeto);
    }
}
