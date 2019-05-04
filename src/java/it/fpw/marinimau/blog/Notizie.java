/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.marinimau.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mauro
 */
public class Notizie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ArrayList<Articolo> notizie;
            ArticoloFactory af=ArticoloFactory.getInstance();
            CategoriaFactory cf=CategoriaFactory.getInstance();
            Categoria categoria_scelta=null; //categoria specificata dall'utente
            Utente autore_scelto=null; //autore specificato dall'utente
            /*
             * recupero le categorie da visualizzare nel menu, non c'entra con quella corrente
             */
            ArrayList<Categoria> categorie=cf.getCategorie();
            /*
             * recupero gli utenti autori da visualizzare nel menà autori
             */
            UtenteFactory uf=UtenteFactory.getInstance();
            ArrayList<Utente> autori=uf.getAutori();
            /*
             * controllo se è stata impostata una categoria
             */
            if(request.getParameter("categoria")!=null)
                categoria_scelta=cf.getCategoriaById(Integer.parseInt(request.getParameter("categoria")));
            /*
             * se la categoria non è stata impostata
             */
            if(categoria_scelta==null){
                notizie=af.getNewsByDate();
                request.setAttribute("title","Notizie > Tutto");
            }
            /*
             * se la categoria è stata impostata
             */
            else{
                notizie=af.getNewsByCategoryOrdinate(categoria_scelta);
                request.setAttribute("title", categoria_scelta.getNome());
            }
            
            
             /*
             * controllo se è stata impostato un autore
             */
            if(request.getParameter("autore")!=null)
                autore_scelto=uf.getUtenteById(Integer.parseInt(request.getParameter("autore")));
            /*
             * se l'autore non è stato impostato
             */
            if(autore_scelto==null){
                notizie=af.getNewsByDate();
                request.setAttribute("title","Notizie > Tutto");
            }
            /*
             * se l'utente è stato impostato
             */
            else{
                notizie=af.getNewsByAuthor(autore_scelto);
                request.setAttribute("title", "Notizie di: "+autore_scelto.getNome()+" "+autore_scelto.getCognome());
            }
            
            request.setAttribute("autori",autori); //utenti da elencare nel menù degli autori
            request.setAttribute("categorie",categorie); //categorie da elencare nel menù delle categorie
            request.setAttribute("notizie",notizie); //categorie da elencare nel menù delle categorie
            /*
             * e mando la richiesta
             */
            request.getRequestDispatcher("M1/elenconotizie.jsp").forward(request, response);
       }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
