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
public class EliminaArticolo extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            UtenteFactory uf=UtenteFactory.getInstance();
            ArticoloFactory af=ArticoloFactory.getInstance();
            Articolo art=null;
            Utente utente=null;
            String password;
            int articoloId;
            /*
             * se vi è un utente loggato e se è stato impostato l'articolo e l'utente loggato ne è l'autore
             */
            if(session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)
               && request.getParameter("id_articolo")!=null && 
               (af.getArticoloById(Integer.parseInt(request.getParameter("id_articolo")))).getAutore().getId()==(uf.getUtenteById((int)session.getAttribute("userId")).getId())){
                /*
                 * Sei loggato e anche autore dell'articolo controlla se ho il parametro password è già stata impostata
                 */
                 articoloId=Integer.parseInt(request.getParameter("id_articolo"));
                 if(request.getParameter("password")!=null){
                     /*controllo se è corretta*/
                     password=request.getParameter("password");
                     utente=uf.getUtenteById((int) session.getAttribute("userId"));
                     if(utente.getPassword().equals(password)){
                         /*La password è corretta elimino l'utente*/
                        if(af.eliminaArticolo(articoloId)){
                            /*se l'eliminazione ha avuto successo*/                          
                           /*e imposto gli attributi*/
                           request.setAttribute("title", "Articolo eliminato correttamente");
                           request.setAttribute("messaggio","");
                           /*inoltro la richiesta*/
                           request.getRequestDispatcher("articoli.html").forward(request, response);
                           return;
                        } 
                     }
                     else{
                         /*la password non è corretta, la chiedo di nuovo*/
                         /*abilito il form*/
                        request.setAttribute("elimina_articolo", true);
                        /*e imposto gli attributi*/
                        request.setAttribute("title", "Elimina articolo: password non corretta");
                        request.setAttribute("messaggio","");
                        //l'Id verrà passato al form perché ci venga restituito, evito di usare una sessione
                        request.setAttribute("id_articolo",articoloId);
                        /*inoltro la richiesta*/
                       request.getRequestDispatcher("M1/conferma.jsp").forward(request, response);
                       return;
                     }
                     
                 }
                 /* se non è stata impostata la richiedi*/
                 else{
                    /*abilito il form*/
                    request.setAttribute("elimina_articolo", true);
                    /*e imposto gli attributi*/
                    request.setAttribute("title", "Elimina articlo: password richiesta");
                    request.setAttribute("messaggio","");
                    //l'Id verrà passato al form perché ci venga restituito, evito di usare una sessione
                    request.setAttribute("id_articolo",articoloId);
                    /*inoltro la richiesta*/
                    request.getRequestDispatcher("M1/conferma.jsp").forward(request, response);
                    return;
                 }
            }
            else{
                /*
                 * Non sei loggato
                 */
                request.setAttribute("title", "Permesso negato");
                request.setAttribute("messaggio", "Non disponi dei permessi necessari per visualizzare questa pagina");
                request.getRequestDispatcher("M1/conferma.jsp").forward(request, response);
                return;
            }
            /*in caso di errori non previsti inoltro a articoli.html*/
            request.getRequestDispatcher("notizie.html").forward(request, response);
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
