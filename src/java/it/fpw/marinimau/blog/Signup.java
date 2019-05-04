/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.fpw.marinimau.blog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Signup extends HttpServlet {

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

        UtenteFactory factory = UtenteFactory.getInstance();
        //se i campi di input non sono vuoti e password e confermapassword corrispondono
        if( request.getParameter("nome") != null &&
            request.getParameter("cognome") != null &&
            request.getParameter("datanascita") != null &&
            request.getParameter("username") != null &&
            request.getParameter("password") != null &&
            request.getParameter("confpassword") != null &&    
            request.getParameter("email") != null &&
            request.getParameter("urlImgProfilo") != null &&
            request.getParameter("password").equals(request.getParameter("confpassword"))){
            //Assegno i parametri alle variabili e chiamo la funzione di inserimento
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String data_nascita=request.getParameter("datanascita");
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            Tipo tipo_utente=Tipo.OSPITE; //chiunque appena si registra è solo ospite
            String urlProfImg = request.getParameter("urlImgProfilo");
            
            //Se la registrazione va a buon fine reindirizzo a login.html con un messaggio di successo
            if(factory.aggiungiUtente(nome, cognome, data_nascita, username, password, email, tipo_utente, urlProfImg)){
                request.setAttribute("registrazioneRiuscita", true);
                request.getRequestDispatcher("login.html").forward(request, response);
                return;
            }
            //Se va male verrò reindirizzato a signup.jsp con messaggio di errore
            else{
                request.setAttribute("title", "Registrazione fallita: compilare correttamente tutti i campi");
                request.getRequestDispatcher("M1/signup.jsp").forward(request, response);
                return;
            }
        }
        //se arrivo qui e i campi sono vuoti (non ho ancora fallito tentativi), mostro la pagina di registrazione normale
        request.setAttribute("title", "Registrazione");
        request.getRequestDispatcher("M1/signup.jsp").forward(request, response);
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