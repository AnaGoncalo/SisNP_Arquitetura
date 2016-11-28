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
import sisnp.ifrn.br.dominio.Noticia;

/**
 *
 * @author Ana Gonçalo
 */
public class DANoticia {
    private Connection conn;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BANCO = "jdbc:mysql://localhost/sisnp";
    private final String USER = "root";
    private final String PASS = "ananne";

    public DANoticia() {
        System.out.println("chegou aqui Construtor DA noticia");
        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(BANCO, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(DANoticia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DANoticia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Noticia> getNoticias(int idProjeto) {
        
        if (conn != null) {
            System.out.println("chegou aqui DA noticia");
            try {
                PreparedStatement psGetNoticia = conn.prepareStatement("SELECT * FROM Noticia where idProjeto = ?");
                psGetNoticia.setInt(1, idProjeto);
                ResultSet rsGetNoticia = psGetNoticia.executeQuery();
                List<Noticia> noticias = new ArrayList();
                
                if(rsGetNoticia.next()){
                    Noticia noticia = new Noticia();
                    noticia.setIdNoticia(rsGetNoticia.getInt("idNoticia"));
                    noticia.setTituloNoticia(rsGetNoticia.getString("tituloNoticia"));
                    noticia.setTexto(rsGetNoticia.getString("texto"));
                    noticia.setIdProjeto(rsGetNoticia.getInt("idProjeto"));
                    System.out.println(noticia.getTituloNoticia());
                    noticias.add(noticia);
                    
                    //libera os recursos
                    psGetNoticia.close();
                    
                    //retorna o projeto
                    return noticias;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DANoticia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
