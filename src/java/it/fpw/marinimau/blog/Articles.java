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
import javax.servlet.http.HttpSession;

/**
 *
 * @author mauro
 */
public class Articles extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
            UtenteFactory uf=UtenteFactory.getInstance();
            Utente autore;
            ArticoloFactory af=ArticoloFactory.getInstance();
            ArrayList<Articolo> articoliPerAutore;
            /*
             * se vi è un utente loggato e questo è un autore:
             */
            if((session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) && uf.getUtenteById((int)session.getAttribute("userId")).getTipoUtente().equals(Tipo.AUTORE)){
                /*
                 * Sei un autore
                 */
                autore=uf.getUtenteById((int)session.getAttribute("userId"));
                articoliPerAutore=af.getNewsByAuthor(autore);
                /*
                 * setto gli attributi
                 */
                request.setAttribute("title","I tuoi articoli");
                request.setAttribute("articoli",articoliPerAutore);
                request.setAttribute("messaggio","");
            }
            /*
             * se l'utente non è loggato oppure non è un autore:
             */
            else{
                /*
                 * Non sei loggato o non sei un autore setto differenti attributi
                 */
                request.setAttribute("title","Permesso negato");
                request.setAttribute("articoli",null);
                request.setAttribute("messaggio","Non disponi dei privilegi necessari per vedere questa pagina.");
            }
            /*
             * E invio la richiesta
             */            
            request.getRequestDispatcher("M1/articoli.jsp").forward(request, response);
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
