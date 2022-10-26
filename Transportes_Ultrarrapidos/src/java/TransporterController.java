/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Class.TransArray;
import Class.TransModel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ramir
 */
@WebServlet(urlPatterns = {"/TransporterController"})
public class TransporterController extends HttpServlet {
TransModel trans;
TransArray registerTrans;
StringBuffer objectResponse = new StringBuffer();
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
        try ( PrintWriter out = response.getWriter()) {
    
                       
                           registerTrans = new TransArray();
                           
                           String control = request.getParameter("control");
                           if(control.toUpperCase().equals("GUARDAR")){
                                    trans = new TransModel(
                                             Integer.parseInt(request.getParameter("code")),
                                             request.getParameter("name"),
                                             request.getParameter("lastname"),
                                             request.getParameter("email"),
                                              request.getParameter("license")
                                    );
                                             registerTrans.saveTrans(trans);
                           }
                           else if(control.toUpperCase().equals("ELIMINAR")){
                                    int codeDelete = Integer.parseInt(request.getParameter("id_Transportista"));
                                    registerTrans.deleteTrans(codeDelete);
                                              
                            
                           }
          
            out.write(objectResponse.toString()); 
       
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
