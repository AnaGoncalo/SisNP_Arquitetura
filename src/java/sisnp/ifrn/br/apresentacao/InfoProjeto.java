
package sisnp.ifrn.br.apresentacao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sisnp.ifrn.br.dominio.Noticia;
import sisnp.ifrn.br.dominio.Projeto;
import sisnp.ifrn.br.negocio.BLNoticia;
import sisnp.ifrn.br.negocio.BLProjeto;

/**
 *
 * @author Ana Gonçalo
 */
// para acessar esse servelt: projeto
public class InfoProjeto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("chegou no servelt");
        String idProjeto = request.getParameter("idProjeto");
       
        if(idProjeto != null && !idProjeto.isEmpty()){
            // http://localhost:8080/SisNP_Arquitetura/projeto?idProjeto=1
            System.out.println("oi");
            HttpSession session = request.getSession();
            
            int id = Integer.parseInt(idProjeto);
            
            BLProjeto bl = new BLProjeto();
            Projeto projeto = bl.getProjeto(id);
            session.setAttribute("projeto", projeto);
            
            BLNoticia blN = new BLNoticia();
            List<Noticia> noticias = blN.getNoticias(id);
            
            session.setAttribute("noticias", noticias);
            //request.setAttribute("listaNoticia", noticias);
            
            for(int i=0; i < noticias.size(); i++)
            {
                System.out.println("noticias " + noticias.get(i).getTituloNoticia());
            }
            
            System.out.println("chegou aqui");
            //System.out.println(projeto.getTitulo());
            
            request.getRequestDispatcher("viewProjeto.jsp").forward(request, response);
        }
       
        
        System.out.println("algo aqui" + idProjeto);
        request.getRequestDispatcher("/viewErro.jsp?msg=\"parinvalido\"").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
