/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.marinimau.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mauro
 */
public class NewArticle extends HttpServlet {

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
            /* dichiaro le variabili */
            HttpSession session = request.getSession(false);
            UtenteFactory uf=UtenteFactory.getInstance();
            ArticoloFactory af=ArticoloFactory.getInstance();
            Articolo art;
            CategoriaFactory cf=CategoriaFactory.getInstance();
            ArrayList<Categoria> categorie;
            int id_nuovo;
            /*
             * Recupero un eventuale articolo da modificare
             */   
            int id=-1;
            if(request.getParameter("id")!=null)
                id=Integer.parseInt(request.getParameter("id"));
            /*
             * se vi è un utente loggato e questo è un autore:
             */
            if((session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)) && uf.getUtenteById((int)session.getAttribute("userId")).getTipoUtente()==Tipo.AUTORE){
                /*
                 * Sei un autore
                 */
                categorie=cf.getCategorie();
                request.setAttribute("messaggio","");
                request.setAttribute("categorie",categorie);

                /*
                 * Se è stato richiamato su un articolo da modficare
                 */
                if(id!=-1){
                    /*
                     * Se l'articolo abbiamo ricevuto la richiesta di modifica
                     */
                    if((request.getParameter("modifica")!=null) && (Integer.parseInt(request.getParameter("modifica"))==1)){
                        art=af.getArticoloById(id); 
                        /*setto i nuovi attributi all'articolo che passerò alla funzione per la modifica*/
                        art.setId(id);
                        art.setTitolo(request.getParameter("titolo"));
                        art.setCorpo(request.getParameter("testo"));
                        art.setUrlImg(request.getParameter("url"));
                        art.setDidascaliaImg(request.getParameter("didascalia"));
                        art.setAutore(uf.getUtenteById((int)session.getAttribute("userId")));
                        art.setCategoria(cf.getCategoriaById(Integer.parseInt(request.getParameter("categoria"))));
                        /*
                         * se tutto e ok modifico e reindirizzo
                         */
                        if(af.modificaArticolo(art)){
                            request.setAttribute("title","Modifica effettuata!");
                        }
                        /*se fallisco la modifica avverto dell'errore*/
                        else{
                            request.setAttribute("title","Modifica fallita!");
                        }
                        //in ogni caso reindirizzo, l'articolo lo prelevo comunque dal db, così è sempre l'ultimo salvato con successo
                        request.setAttribute("articolo",af.getArticoloById(id));
                        request.getRequestDispatcher("M1/scriviArticolo.jsp").forward(request, response);
                    }
                    request.setAttribute("title","Modifica articolo");
                    request.setAttribute("articolo",af.getArticoloById(id));
                }
                /*
                 * è stato richiamato per creare un nuovo articolo
                 */
                else{
                    request.setAttribute("title","Nuovo Articolo");
                    request.setAttribute("articolo",null);
                    /*
                     * Se l'articolo lo stiamo inserendo
                     */
                    if((request.getParameter("nuovo")!=null) && (Integer.parseInt(request.getParameter("nuovo"))==1)){
                        /*Stiamo scrivendo un nuovo articolo*/
                        art=af.getArticoloById(id); 
                        /*setto i nuovi attributi all'articolo che passerò alla funzione per la modifica*/
                        art.setTitolo(request.getParameter("titolo"));
                        art.setCorpo(request.getParameter("testo"));
                        art.setUrlImg(request.getParameter("url")); 
                        art.setDidascaliaImg(request.getParameter("didascalia"));
                        art.setAutore(uf.getUtenteById((int)session.getAttribute("userId")));
                        art.setCategoria(cf.getCategoriaById(Integer.parseInt(request.getParameter("categoria"))));
                        /*
                         * se tutto e ok modifico e reindirizzo
                         */
                        id_nuovo=af.inserisciArticolo(art);
                        if(id_nuovo!=-1){
                            request.setAttribute("title","Pubblicazione articolo avvenuta con successo!");
                            request.getRequestDispatcher("scriviArticolo.html?id="+id_nuovo).forward(request, response);
                        }
                        /*se fallisco la modifica avverto dell'errore*/
                        else{
                            request.setAttribute("title","Pubblicazione fallita!");
                        }
                        //in ogni caso reindirizzo,
                        request.getRequestDispatcher("M1/scriviArticolo.jsp").forward(request, response);
                    }
                }
                request.getRequestDispatcher("M1/scriviArticolo.jsp").forward(request, response);
            }
            /*
             * se l'utente non è loggato oppure non è un autore:
             */
            else{
                /*
                 * Non sei loggato o non sei un autore
                 */
                request.setAttribute("title","Permesso negato");
                request.setAttribute("articolo",null);
                request.setAttribute("messaggio","Non disponi dei privilegi necessari per vedere questa pagina.");
                request.getRequestDispatcher("M1/scriviArticolo.jsp").forward(request, response);
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
