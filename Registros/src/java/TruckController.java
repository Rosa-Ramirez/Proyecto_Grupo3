/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Clases.TruckArray;
import Clases.Truck;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernanda Cordón
 */
@WebServlet(urlPatterns = {"/TruckController"})
public class TruckController extends HttpServlet {
    Truck camion;
    TruckArray guardarAlumno2;
    StringBuffer objetoRespuesta = new StringBuffer();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
         guardarAlumno2=new TruckArray();
           String control = request.getParameter("control");
           if(control.toUpperCase().equals("GUARDAR")){
               camion=new Truck(
                request.getParameter("Placa"),
                request.getParameter("Modelo"),
                request.getParameter("Capacidad_peso"),
                request.getParameter("Hora")); 
                guardarAlumno2.registerTruck(camion);//almacenarlo en BD      
        }
            else if(control.toUpperCase().equals("DELETE")){
                                    int codeDelete = Integer.parseInt(request.getParameter("Placa"));
                                    guardarAlumno2.eliminarAlumno(codeDelete);
    out.println("<script>console.log('Hola4')</script>");
        }
      guardarAlumno2.getClient2(objetoRespuesta);
                        out.write(objetoRespuesta.toString());
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




