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
import sisnp.ifrn.br.dominio.Meta;

/**
 *
 * @author Ana Gonçalo
 */
public class DAMeta {
    private Connection conn;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BANCO = "jdbc:mysql://localhost/sisnp";
    private final String USER = "root";
    private final String PASS = "ananne";

    public DAMeta() {
        System.out.println("chegou aqui Construtor DA meta");
        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(BANCO, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DAMeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAMeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Meta> getMetas(int idProjeto) {
        
        if (conn != null) {
            System.out.println("chegou aqui DA meta");
            try {
                PreparedStatement psGetMeta = conn.prepareStatement("SELECT * FROM Meta where idProjeto = ?");
                psGetMeta.setInt(1, idProjeto);
                ResultSet rsGetMeta = psGetMeta.executeQuery();
                List<Meta> metas = new ArrayList();
                
                while(rsGetMeta.next()){
                    Meta meta = new Meta();
                    meta.setIdMeta(rsGetMeta.getInt("idMeta"));
                    meta.setNome(rsGetMeta.getString("nome"));
                    meta.setDataEntrega(rsGetMeta.getDate("dataEntrega"));
                    meta.setIdProjeto(rsGetMeta.getInt("idProjeto"));
                    
                    metas.add(meta);
                }
                
                //libera os recursos
                psGetMeta.close();
                return metas;
            } 
            catch (SQLException ex) {
                Logger.getLogger(DAMeta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return null;
    }
}
