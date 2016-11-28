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
import java.util.logging.Level;
import java.util.logging.Logger;
import sisnp.ifrn.br.dominio.Projeto;

/**
 *
 * @author Ana Gonçalo
 */
public class DAProjeto {

    private Connection conn;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BANCO = "jdbc:mysql://localhost/sisnp";
    private final String USER = "root";
    private final String PASS = "ananne";

    public DAProjeto() {
        System.out.println("chegou aqui Construtor DA");
        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(BANCO, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Projeto getProjeto(int idProjeto) {
        
        if (conn != null) {
            System.out.println("chegou aqui DA");
            try {
                PreparedStatement psGetProjeto = conn.prepareStatement("SELECT * FROM Projeto where id = ?");
                psGetProjeto.setInt(1, idProjeto);
                ResultSet rsGetProjeto = psGetProjeto.executeQuery();
                Projeto projeto = new Projeto();
                if(rsGetProjeto.next()){
                    projeto.setId(rsGetProjeto.getInt("id"));
                    projeto.setTitulo(rsGetProjeto.getString("titulo"));
                    projeto.setDescricao(rsGetProjeto.getString("descricao"));
                    
                    //libera os recursos
                    psGetProjeto.close();
                    
                    //retorna o projeto
                    return projeto;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
