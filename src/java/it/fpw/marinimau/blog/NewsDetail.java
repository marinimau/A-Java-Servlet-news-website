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
public class NewsDetail extends HttpServlet {

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
            
        
            ArticoloFactory art = ArticoloFactory.getInstance();
            int notizia_id = -1;
            if(request.getParameter("id")!=null){
                notizia_id=Integer.parseInt(request.getParameter("id"));
            }
            if(notizia_id > 0){
                /*
                 * recupero l'articolo
                 */
                Articolo notizia = art.getArticoloById(notizia_id);
                if(notizia==null)
                    request.getRequestDispatcher("login.html").forward(request, response);
                /*
                 * Setto gli attributi
                 */
                else{
                    request.setAttribute("art", notizia);
                    CommentoFactory commF = CommentoFactory.getInstance();
                    ArrayList<Commento> listaCommenti;
                    listaCommenti = commF.getCommentobyArticolo(notizia);
                    request.setAttribute("commenti", listaCommenti);
                    /*
                     * e richiamo la JSP
                     */
                    request.getRequestDispatcher("M1/notizia.jsp").forward(request, response);
                }
            }
            /*
             * Se arriviamo a questa servlet senza specificare un id, verremo rimandati alla servlet login
             */
            else{
                request.getRequestDispatcher("login.html").forward(request, response);
            }
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
