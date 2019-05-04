/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.marinimau.blog;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mauro
 */
public class Profilo extends HttpServlet {

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
            Utente utente=null;
            /*
             * se vi è un utente loggato e questo è un autore:
             */
            if(session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)){
                /*
                 * Sei loggato
                 */
                /*se ho effettuato modifiche*/
                if((request.getParameter("modificato")!=null) && (Integer.parseInt(request.getParameter("modificato"))==1)){
                    utente=uf.getUtenteById((int)session.getAttribute("userId"));
                    /*setto i nuovi attributi*/
                    utente.setNome(request.getParameter("nome"));
                    utente.setCognome(request.getParameter("cognome"));
                    utente.setUsername(request.getParameter("username"));
                    utente.setEmail(request.getParameter("email"));
                    utente.setUrlImgProfilo(request.getParameter("url"));
                    //utente.setData_nascita("datanascita");
                    /*controllo che password e conferma coincidano*/
                    if(request.getParameter("password").equals(request.getParameter("confpassword"))){
                        utente.setPassword(request.getParameter("password"));
                    }
                    /*senno annullo tutto avvertendo dell'errore*/
                    else{
                        request.setAttribute("utente",uf.getUtenteById((int)session.getAttribute("userId")));
                        request.setAttribute("title","Errore: le password non coincidono");
                        request.setAttribute("messaggio","");
                        request.getRequestDispatcher("M1/profilo.jsp").forward(request, response);
                    }
                    /*se tutto è ok procedo con la modifica*/
                    /*se la modfica avviene correttamente mostro un messaggio di successo*/
                    if(uf.modficaUtente(utente)){
                        request.setAttribute("utente",uf.getUtenteById((int)session.getAttribute("userId")));
                        request.setAttribute("title","Modifica effettuata!");
                        request.setAttribute("messaggio","");
                        request.getRequestDispatcher("M1/profilo.jsp").forward(request, response);
                    }
                    /*senno avverto dell'errore*/
                    else{
                        request.setAttribute("utente",uf.getUtenteById((int)session.getAttribute("userId")));
                        request.setAttribute("title","Errore nel salvataggio dei dati");
                        request.setAttribute("messaggio","");
                        request.getRequestDispatcher("M1/profilo.jsp").forward(request, response);
                    }
                        
                }
                /*se non ho effettuato modifiche mostro il profilo e basta*/
                else{
                    request.setAttribute("utente",uf.getUtenteById((int)session.getAttribute("userId")));
                }
                request.setAttribute("title","Il tuo profilo");
                request.setAttribute("messaggio","");
                request.getRequestDispatcher("M1/profilo.jsp").forward(request, response);
            }
            /*
             * se l'utente non è loggato oppure non è un autore:
             */
            else{
                /*
                 * Non sei loggato o non sei un autore
                 */
                request.setAttribute("utente",null);
                request.setAttribute("title","Permesso negato");
                request.setAttribute("messaggio","Non disponi dei privilegi necessari per vedere questa pagina.");
                request.getRequestDispatcher("M1/profilo.jsp").forward(request, response);
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
