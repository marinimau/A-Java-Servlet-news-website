
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
public class Login extends HttpServlet {

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
            /*
             * dichiaro la sessione
             */
            HttpSession session = request.getSession();
            /*
             * controllo se logout non è null
             * -nel caso invalido la sessione e reidirizzo alla pagina di login
             */
            if (request.getParameter("logout") != null){
                session.invalidate();
                request.getRequestDispatcher("/M1/login.jsp").forward(request, response);
                return;
            }
            /*
             * Se provengo dal form di registrazione
             */
            if (request.getParameter("registrazioneRiuscita") != null){
                request.setAttribute("registrazioneRiuscita", true);
                request.getRequestDispatcher("/M1/login.jsp").forward(request, response);
                return;
            }
            
            //Utente Loggato
            if (session.getAttribute("loggedIn") != null && session.getAttribute("loggedIn").equals(true)){
                /*
                 * setto gli attributi e reidirizzo a notizia.html
                 */
                request.setAttribute("title", "Notizia");
                request.getRequestDispatcher("notizie.html").forward(request, response);
                return;
            }
            //Utente non loggato
            else{
                /*
                 * recupero i dati dal form 
                 */
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                UtenteFactory factory = UtenteFactory.getInstance();
                /*
                 * se non sono null chiamo il metodo login e se anch'esso restituisce true
                 */               
                if (email != null && password != null && factory.login(email, password)){
                   /*
                    * recupero i dati utente e setto gli attributi della sessione
                    */
                    int userId = factory.getUtenteByEmail(email).getId();
                    String username = factory.getUtenteById(userId).getUsername();
                    Tipo tipo = factory.getUtenteById(userId).getTipoUtente();
                    session.setAttribute("userId", userId);
                    session.setAttribute("username", username);
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("tipo",tipo);
                    /*
                     * setto gli attributi della pagina e effetuo la redirect
                     */
                    request.setAttribute("title", "Ciao, "+username);
                    request.getRequestDispatcher("notizie.html").forward(request, response);
                    return;
                }
                /*
                 * se i dati non erano null ma il login non è andato a buon fine
                 */
                else if(email != null && password != null){
                    /*
                     * rimando alla pagina di login mostrando un messaggio di errore
                     */
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("M1/login.jsp").forward(request, response);
                    return;
                }
            } 
            request.getRequestDispatcher("M1/login.jsp").forward(request, response);
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
