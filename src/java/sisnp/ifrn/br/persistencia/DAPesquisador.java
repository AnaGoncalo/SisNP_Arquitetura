/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisnp.ifrn.br.persistencia;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Pesquisador;

/**
 *
 * @author Ana Gonçalo
 */
public class DAPesquisador {
    private Connection conn;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BANCO = "jdbc:mysql://localhost/sisnp";
    private final String USER = "root";
    private final String PASS = "ananne";

    public DAPesquisador() {
        System.out.println("chegou aqui Construtor DA pesquisador");
        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(BANCO, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DANoticia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DANoticia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Pesquisador> getPesquisadores(int idProjeto) {
        
        if (conn != null) {
            System.out.println("chegou aqui DA pesquisador");
            try {
                PreparedStatement psGetPesquisador = conn.prepareStatement("SELECT * FROM pesquisador "
                        + "inner join pesquisador_projeto on pesquisador.idPesquisador = pesquisador_projeto.idPesquisador "
                        + "where pesquisador_projeto.idProjeto = ?");
                psGetPesquisador.setInt(1, idProjeto);
                ResultSet rsGetPesquisador = psGetPesquisador.executeQuery();
                List<Pesquisador> pesquisadores = new ArrayList();
                
                while(rsGetPesquisador.next()){
                    Pesquisador pesquisador = new Pesquisador();
                    pesquisador.setIdPesquisador(rsGetPesquisador.getInt("idProjeto"));
                    pesquisador.setMatricula(rsGetPesquisador.getString("matricula"));
                    pesquisador.setNome(rsGetPesquisador.getString("nome"));
                    System.out.println(pesquisador.getNome());
                    pesquisadores.add(pesquisador);
                }
                System.out.println(pesquisadores.size());
                //libera os recursos
                psGetPesquisador.close();
                return pesquisadores;
            } 
            catch (SQLException ex) {
                Logger.getLogger(DAPesquisador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return null;
    }
}
