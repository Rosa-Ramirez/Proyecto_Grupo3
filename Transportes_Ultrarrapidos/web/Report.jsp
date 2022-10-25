<%-- 
    Document   : Report
    Created on : 24/10/2022, 21:27:50
    Author     : ramir
--%>

<%@page import="java.sql.* "%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <link href="tableStyle.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
          <style>
            *{
                margin: 0;
                padding: 0;
            }
            body{
                min-height: 100vh;
                background-image: radial-gradient(circle at 87.5% 12.5%, #5b96ff 0, #1c4884 50%, #00001b 100%);
                background-size: 100%;
                background-position: center center;
                background-attachment: fixed;
                background-repeat: no-repeat;
                background-size: cover;
            }
            .header .navbar {
                width: 100%;
                height: 30px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 30px 10%;
                background: rgba(0,0,0,0.6);
                font-family:sans-serif;

            }

        </style> 
        <header class="header">
            <nav class="navbar navbar-expand-lg navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="https://materilejuguetes.com/img/entrega.png" width="60" height="60" alt="">
                        Transportes Ultrarrápidos
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav m-auto">
                            <li class="nav-item active">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">About Us</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Dropdown
                                </a>
                                <ul class="dropdown-menu dropdown-menu-dark" id="menu-navbar">
                                    <li><a class="dropdown-item" href="EgressForm.html">Registrar Egreso</a></li>
                                    <li><a class="dropdown-item" href="DriverForm.html">Registrar Piloto</a></li>
                                    <li><a class="dropdown-item" href="TruckForm.html">Registrar Camión</a></li>
                                    <li><a class="dropdown-item" href="TransporterForm.jsp">Registrar Transportista</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="login.jsp">Iniciar sesión o Registrarse</a></li>
                                </ul>
                            </li>
                        </ul>
                        <form class="d-flex" role="search">
                            <a class="btn btn-outline-success"  href="Logout">Cerrar Sesion</a>
                        </form>
                    </div>
                </div>
            </nav>
        </header>
        <%
     Connection conn;  
     String url="jdbc:mysql://localhost:3306/transportes_ultrarrapidos_sa";
    String usuario="root";
    String clave="root";
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection( url, usuario,clave);
    
    PreparedStatement ps;
    ResultSet rs;
    ps=conn.prepareStatement("select * from registro_ingreso");
    rs=ps.executeQuery();
        %>
        <div class="container">
            <div class="container search">
                <form class="form">
            <input type="text" name="txtsearch" class="form-control">
        <input type="submit" value="search" class="btn btn-outline-success">
        </form>
                </div>
            <div class="table-responsive">
        <table class="table table-hover table-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Piloto</th>
                <th scope="col">Placa</th>
                <th scope="col">Predio</th>
                <th scope="col">Bodega</th>
                <th scope="col">Hora</th>
                <th scope="col">Dia</th>
                <th scope="col">Origen</th>
                <th scope="col">Carga</th>
                <th scope="col">Transportista</th>
            </tr>
            <%
                while(rs.next()){
            %>
            <tr>
                <td><%= rs.getInt("id_registro_ingreso")%></td>
                <td><%= rs.getInt("id_dpi_piloto")%></td>
                <td><%= rs.getString("camion_placa")%></td>
                <td><%= rs.getInt("id_predio")%></td>
                <td><%= rs.getInt("id_bodega")%></td>
                <td><%= rs.getString("hora")%></td>
                <td><%= rs.getString("dia")%></td>
                <td><%= rs.getString("origen")%></td>
                <td><%= rs.getString("tipo_carga")%></td>
                <td><%= rs.getInt("transportista_id_transportista")%></td>
                <td>
                    <a class="btn btn-outline-success">Editar</a>
                    <a class="btn btn-outline-danger">Elimintar</a>
                </td>
            </tr>
            <%}%>
        </table>
            </div>
        </div>
    </body>
</html>
