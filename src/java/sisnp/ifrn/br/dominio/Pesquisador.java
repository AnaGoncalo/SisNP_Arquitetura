/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.dominio;

/**
 *
 * @author Ana Gonçalo
 */
public class Pesquisador {
    private int idPesquisador;
    private String matricula;
    private String Nome;

    public Pesquisador() {
    }

    public int getIdPesquisador() {
        return idPesquisador;
    }

    public void setIdPesquisador(int idPesquisador) {
        this.idPesquisador = idPesquisador;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    
}
